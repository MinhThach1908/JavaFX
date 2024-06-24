module org.example.javafx_demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.javafx_demo to javafx.graphics, javafx.fxml;
    opens org.example.javafx_demo.controller to javafx.graphics, javafx.fxml;
    exports org.example.javafx_demo;
    exports org.example.javafx_demo.entity;
    exports demo;
}