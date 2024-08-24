/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import static controller.APIController.fetchGames;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Game;
import model.dao.GameCustomDeserializer;
import start.App;


/**
 *
 * @author evelinsteiger
 */
public class GameController {

    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnMenuDashboard;
    @FXML
    private Button btnMenuFavorite;
    @FXML
    private Button btnMenuCollection;
    @FXML
    private Button btnMenuCreateGame;
    @FXML
    private TableView<Game> tableGames;
    @FXML
    private TableColumn<?, ?> colImage;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colRelease;
    @FXML
    private TableColumn<?, ?> colPlatforms;
    @FXML
    private TableColumn<?, ?> colGender;
    
    private List<Game> list = new ArrayList();
    private ObservableList<Game> observableList;
   
    
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) throws Exception {

    }
    
    
    @FXML
    private void onSearch(ActionEvent event) throws Exception {
        Map<Integer, String> response = fetchGames(txtSearch.getText());
        
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Game.class, new GameCustomDeserializer()); 
        mapper.registerModule(module);

        response.forEach((key, value) -> {
            try {
                Game game = mapper.readValue(value, Game.class);
                list.add(game.getId(), game);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        observableList = FXCollections.observableArrayList(list);

        colImage.setCellValueFactory(new PropertyValueFactory<>("Imagem"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Título"));
        colRelease.setCellValueFactory(new PropertyValueFactory<>("Lançamento"));
        colPlatforms.setCellValueFactory(new PropertyValueFactory<>("Plataformas"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("Gênero"));
        
        tableGames.setItems(observableList);
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        App.setRoot("welcome");
    }

    @FXML
    private void handleNavigateDashboard(ActionEvent event) throws IOException, Exception {
        App.setRoot("main");
    }

    @FXML
    private void handleNavigateFavorite(ActionEvent event) throws IOException {
        App.setRoot("favorite");
    }

    @FXML
    private void handleNavigateCollection(ActionEvent event) throws IOException {
        App.setRoot("collections");
    }

    @FXML
    private void handleNavigateCreateGame(ActionEvent event) throws IOException {
        App.setRoot("create_game");
    }

}
