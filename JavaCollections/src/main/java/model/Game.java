package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.dao.GameCustomDeserializer;

//@JsonDeserialize(using = GameCustomDeserializer.class)
public class Game {
    
    private enum collectionStatus {
        PENDING,
        PLAYING_NOW,
        FINISHED,
        NOT_INTERESTED;
    }
    
    private int id;
    private String name;
    private String image;
    private String releaseDates;
    private String gender;
    private Float rating;
    private String platforms;

    @JsonIgnore 
    private boolean favorite;
    
    @JsonIgnore 
    private String description;
    
    @JsonIgnore
    private String createdAt;
    
    @JsonIgnore
    private collectionStatus status;

    public Game() {
        
    }

    public Game(String name, String image, String releaseDates, String gender, Float rating, String platforms, boolean favorite, String description, String createdAt) {
        this.name = name;
        this.image = image;
        this.releaseDates = releaseDates;
        this.gender = gender;
        this.rating = rating;
        this.platforms = platforms;
        this.favorite = favorite;
        this.description = description;
        this.createdAt = createdAt;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(String releaseDates) {
        this.releaseDates = releaseDates;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public collectionStatus getStatus() {
        return status;
    }

    public void setStatus(collectionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", image=").append(image);
        sb.append(", releaseDates=").append(releaseDates);
        sb.append(", gender=").append(gender);
        sb.append(", rating=").append(rating);
        sb.append(", platforms=").append(platforms);
        sb.append(", favorite=").append(favorite);
        sb.append(", description=").append(description);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
