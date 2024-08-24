package model;

import java.util.ArrayList;

public class APIGame {
    
    public int id;
    public String name;
    public Cover cover;
    public String first_release_date;
    public ArrayList<Genre> genres;
    public ArrayList<Platform> platforms;
    public Float total_rating;
    
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

    public APIGame(int id, String name, Cover cover, String first_release_date, ArrayList<Genre> genres, ArrayList<Platform> platforms, Float total_rating) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.first_release_date = first_release_date;
        this.genres = genres;
        this.platforms = platforms;
        this.total_rating = total_rating;
    }

    public APIGame() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getFirst_release_date() {
        return first_release_date;
    }

    public void setFirst_release_date(String first_release_date) {
        this.first_release_date = first_release_date;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }

    public Float getTotal_rating() {
        return total_rating;
    }

    public void setTotal_rating(Float total_rating) {
        this.total_rating = total_rating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APIGame{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", cover=").append(cover);
        sb.append(", first_release_date=").append(first_release_date);
        sb.append(", genres=").append(genres);
        sb.append(", platforms=").append(platforms);
        sb.append(", total_rating=").append(total_rating);
        sb.append('}');
        return sb.toString();
    }
   
    
    
}
