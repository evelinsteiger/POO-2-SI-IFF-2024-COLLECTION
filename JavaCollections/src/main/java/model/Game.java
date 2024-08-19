package model;

public class Game {
    
    private enum collectionStatus {
        PENDING,
        PLAYING_NOW,
        FINISHED,
        NOT_INTERESTED;
    }
    
    private int id;
    private String name;
    private String gender;
    private Float rating;
    private String releaseDates;
    private boolean favorite;
    private int platformId;
    private String description;
    private String image;
    private String createdAt;
    private collectionStatus status;
   

    public Game() {
    }

    public Game(int id, String name, String gender, Float rating, String releaseDates, boolean favorite, int platformId, String description, String image, String createdAt, collectionStatus status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.rating = rating;
        this.releaseDates = releaseDates;
        this.favorite = favorite;
        this.platformId = platformId;
        this.description = description;
        this.image = image;
        this.createdAt = createdAt;
        this.status = status;
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

    public String getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(String releaseDates) {
        this.releaseDates = releaseDates;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "Game{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", rating=" + rating + ", releaseDates=" + releaseDates + ", favorite=" + favorite + ", platformId=" + platformId + ", description=" + description + ", image=" + image + ", createdAt=" + createdAt + ", status=" + status + '}';
    }

    

}
