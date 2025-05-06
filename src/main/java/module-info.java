module com.example.calculadorakz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires java.desktop;

    opens com.example.calculadorakz to javafx.fxml;
    exports com.example.calculadorakz;
}