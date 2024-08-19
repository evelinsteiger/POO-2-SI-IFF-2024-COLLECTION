/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableView<?> tblGames;
    @FXML
    private TableColumn<?, ?> tblColImage;
    @FXML
    private TableColumn<?, ?> tblColTitle;
    @FXML
    private TableColumn<?, ?> tblColPlatform;
    @FXML
    private TableColumn<?, ?> tblColDate;
    @FXML
    private TableColumn<?, ?> tblColActions;
    @FXML
    private Button btnLogout;
    @FXML
    private Button btnAccount;
    @FXML
    private Button btnNavigateMain;
    @FXML
    private Button btnNavigateLibrary;
    @FXML
    private Button btnNavigateFavorite;
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void goBack(ActionEvent event) {
        
    }

    @FXML
    private void onSearch(ActionEvent event) {
        
    }

    @FXML
    private void onLogout(ActionEvent event) {
        
    }

    @FXML
    private void handleNavigate(ActionEvent event) {
        
    }
    
}
