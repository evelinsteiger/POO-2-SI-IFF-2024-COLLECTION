
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Game;

public class GameDaoJdbc implements InterfaceDao<Game>{
    private final Connection conn;
    
    public GameDaoJdbc() throws Exception {
        this.conn = ConnFactory.getConnection();
    }

    public void create(Game input) throws Exception {
        try {
            PreparedStatement insert = conn.prepareStatement("INSERT INTO games(name,gender,rating,favorite,platforms,description,image) VALUES (?,?,?,?,?,?,?);");

            insert.setString(1, input.getName());
            insert.setString(2, input.getGender());
            insert.setFloat(3, input.getRating());
            insert.setBoolean(4, input.isFavorite());
            insert.setString(5, input.getPlatforms());
            insert.setString(6, input.getDescription());
            insert.setString(7, input.getImage());
                       
            insert.execute();
            
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    @Override
    public void update(Game input, int id) throws Exception {
    }

    @Override
    public void delete(Game input) throws Exception {
        try {
            Game game = new Game();
            game.setId(input.getId());
            
            PreparedStatement delete = conn.prepareStatement("DELETE FROM games WHERE id = ?");

            delete.setInt(1, game.getId());
            delete.execute();
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    @Override
    public Game show(int id) throws Exception {
        try {
            PreparedStatement select = conn.prepareStatement("SELECT * FROM games WHERE id = ?");
            Game item = new Game();
            select.setInt(1, id);
            ResultSet response = select.executeQuery();

            while (response.next()) {
                item.setId(response.getInt("id"));
                item.setName(response.getString("name"));
            }
            
            return item;
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    @Override
    public List<Game> index(String param) throws Exception {
        List<Game> list = new ArrayList();

        return list;
    }

    @Override
    public List<Game> favorite(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Game> updateStatus(Game input) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
