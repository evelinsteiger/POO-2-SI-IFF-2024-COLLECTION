package model.dao;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Game;


public class GameCustomDeserializer extends StdDeserializer<Game> {
    
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    private enum collectionStatus {
        PENDING,
        PLAYING_NOW,
        FINISHED,
        NOT_INTERESTED;
    }
    
    public class Cover {
        public int id;
        public String image_id;
    }
    
    public class Genre {
        public int id;
        public String name;
    }
    
    public class Platform {
        public int id;
        public String name;
    }
    
    public class APIGame {
        public int id;
        public String name;
        public Cover cover;
        public String first_release_date;
        public ArrayList<Genre> genres;
        public ArrayList<Platform> platforms;
        public Float total_rating;
    }
    
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
        String releaseDates = node.get("first_release_date").asText();
        
        float rating = 0;
        
        if (node.findValue("total_rating") !=  null) {
             rating = node.get("total_rating").floatValue();
        }

        List<?> platformsList = node.findParents("platforms");
        String platforms = node.findValuesAsText("name", (List<String>) platformsList).toString();
        
        List<?> genderList = node.findParents("genres");        
        String gender = node.findValuesAsText("name", (List<String>) genderList).toString();
        
        boolean favorite = false;
                
        String description = "Não informado";
        Date createdAt = new Date();
        
        return new Game(name, image, releaseDates, gender, rating, platforms, favorite, description, createdAt.toString());
    }
 
}

