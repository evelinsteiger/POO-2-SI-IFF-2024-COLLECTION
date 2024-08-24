package model.dao;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.dao.GameCustomSerializer.APIGame;


public class GameCustomSerializer extends StdSerializer<APIGame> {
    
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    
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
    
    public GameCustomSerializer() {
        this(null);
    }
  
    public GameCustomSerializer(Class<APIGame> t) {
        super(t);
    }
    
    @Override
    public void serialize(APIGame value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        
        jgen.writeNumberField("id", value.id);
        jgen.writeStringField("name", value.name);
        jgen.writeStringField("image", "https://images.igdb.com/igdb/image/upload/t_cover_big/" + value.cover.image_id + ".jpg");
        jgen.writeStringField("releaseDates", formatter.format(new java.util.Date(value.first_release_date)));
        jgen.writeNumberField("rating", value.total_rating);
        
        jgen.writeStringField("gender", value.name);
        jgen.writeStringField("platforms", value.name);
        jgen.writeEndObject();
    } 
}

