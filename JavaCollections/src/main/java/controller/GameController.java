/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    private TableView<?> tableResults;
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
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    @FXML
    private void onSearch(ActionEvent event) {
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        App.setRoot("welcome");
    }

    @FXML
    private void handleNavigateDashboard(ActionEvent event) throws IOException {
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
