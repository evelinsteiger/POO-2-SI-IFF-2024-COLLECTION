package model.dao;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Game;


public class GameCustomDeserializer extends StdDeserializer<Game> {
    
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public GameCustomDeserializer() {
        this(null);
    }
  
    public GameCustomDeserializer(Class<Game> t) {
        super(t);
    }
    
    @Override
    public Game deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        
        JsonNode node = jp.getCodec().readTree(jp);

        String name = node.get("name").asText();
        String image = "https://images.igdb.com/igdb/image/upload/t_cover_big/" + node.get("cover").findValue("image_id").asText() + ".jpg";
        
        float rating = 0;
        
        if (node.findValue("total_rating") !=  null) {
             rating = node.get("total_rating").floatValue();
        }
        
        String gender = "";
        String platforms = "";
        
        if (node.findValue("genres") !=  null) {
            List<?> genderList = node.get("genres").findValuesAsText("name");
            gender = genderList.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(",", "", ""));
        }
        
        if (node.findValue("platforms") !=  null) {
            List<?> platformsList = node.get("platforms").findValuesAsText("name");
            platforms = platformsList.stream().map(item -> String.valueOf(item)).collect(Collectors.joining(",", "", ""));
        }

        boolean favorite = false;
                
        String description = "Não informado";
        Date createdAt = new Date();
        
        return new Game(name, image, gender, rating, platforms, favorite, description, createdAt.toString());
    }
 
}

