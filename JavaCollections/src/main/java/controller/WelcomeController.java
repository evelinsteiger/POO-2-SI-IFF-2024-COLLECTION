package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import start.App;

/**
 * FXML Controller class
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button btnStart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onStart(ActionEvent event) throws IOException {
        App.setRoot("main");
    }
    
}
