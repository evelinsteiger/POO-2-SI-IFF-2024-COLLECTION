module start.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens start.mavenproject1 to javafx.fxml;
    exports start.mavenproject1;
}
