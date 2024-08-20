module start {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.util;
    requires com.gluonhq.attach.display;
    
    opens model to javafx.fxml;
    exports model;

    opens start to javafx.fxml;
    exports start;
    
    opens controller to javafx.fxml;
    exports controller;   
}
