package model;

public class User {
    
    private int id;
    private String name;
    private String email;
    private String client_id;
    private String grant_type;

    public User() {
    }

    public User(int id, String name, String email, String client_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.client_id = client_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getClientId() {
        return client_id;
    }

    public void setClientId(String client_id) {
        this.client_id = client_id;
    }
    
    public String getGrantType() {
        return grant_type;
    }

    @Override
    public String toString() {
        return "Usuário: " + id + " | " + name + " | " + email;
    }
}
