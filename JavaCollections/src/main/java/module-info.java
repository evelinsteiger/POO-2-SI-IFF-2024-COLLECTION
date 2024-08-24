module start {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    requires com.gluonhq.charm.glisten;
    requires com.gluonhq.attach.util;
    requires com.gluonhq.attach.display;
    requires com.google.gson;
    
    opens model to javafx.fxml,com.google.gson;
    exports model;

    opens start to javafx.fxml;
    exports start;
    
    opens controller to javafx.fxml;
    exports controller;   
    requires jackson.databind;
    requires jackson.annotations;
    requires jackson.core;
    
    exports model.dao;
}
