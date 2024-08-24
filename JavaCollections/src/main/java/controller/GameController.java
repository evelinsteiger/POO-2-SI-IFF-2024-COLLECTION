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
import javafx.beans.binding.Bindings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import model.Game;
import model.dao.DaoFactory;
import model.dao.GameCustomDeserializer;
import model.dao.GameDaoJdbc;
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
    private TableColumn<Game, String> colImage;
    @FXML
    private TableColumn<Game, String> colName;
    @FXML
    private TableColumn<Game, String> colPlatforms;
    @FXML
    private TableColumn<Game, String> colGender;
    
    private List<Game> list = new ArrayList();
    private ObservableList<Game> observableList;
    @FXML
    private Button btnCreateGame;
   
    
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) throws Exception {

    }
    
    
    @FXML
    private void onSearch(ActionEvent event) throws Exception {
        tableGames.setItems(null);
        
        Map<Integer, String> response = fetchGames(txtSearch.getText());
        
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Game.class, new GameCustomDeserializer()); 
        mapper.registerModule(module);

        response.forEach((var key, var value) -> {
            try {
                Game game = mapper.readValue(value, Game.class);

                list.add(game.getId(), game);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        observableList = FXCollections.observableArrayList(list);

        colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        colImage.setCellFactory(col -> {
            TableCell<Game, String> cell = new TableCell<>();
            cell.itemProperty().addListener((observableValue, o, newValue) -> {
                if (newValue != null) {
                    Node graphic = createImageGraphic(newValue);
                    cell.graphicProperty().bind(Bindings.when(cell.emptyProperty()).then((Node) null).otherwise(graphic));
                }
            });
            return cell;
        });
        
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPlatforms.setCellValueFactory(new PropertyValueFactory<>("platforms"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        
        tableGames.setItems(observableList);

    }
    
    private Node createImageGraphic(String url){
        HBox graphicContainer = new HBox();
        graphicContainer.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView(new Image(url));
        imageView.setFitHeight(25);
        imageView.setPreserveRatio(true);
        graphicContainer.getChildren().add(imageView);
        
        return graphicContainer;
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

    @FXML
    private void handleSubmit(ActionEvent event) throws Exception {
        Game select = tableGames.selectionModelProperty().getValue().getSelectedItem();

        try {
            GameDaoJdbc dao = DaoFactory.newGameDao();
            Game input = new Game(select.getName(), select.getImage(), select.getGender(), select.getRating(), select.getPlatforms(), select.isFavorite(), select.getDescription(), select.getCreatedAt());
       
            dao.create(input);
            
        } catch (IOException e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {
            select = null;
            App.setRoot("create_game");
        }
    }

}
