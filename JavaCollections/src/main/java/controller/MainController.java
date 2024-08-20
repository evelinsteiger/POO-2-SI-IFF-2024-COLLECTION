package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import start.App;

public class MainController {

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
