module com.example.trabalhofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jasperreports;
    requires java.desktop;

    opens com.example.trabalhofinal to javafx.fxml;
    exports com.example.trabalhofinal;
    opens com.example.trabalhofinal.model to javafx.fxml;
    exports com.example.trabalhofinal.model;
    opens com.example.trabalhofinal.auxiliares to javafx.fxml;
    exports com.example.trabalhofinal.auxiliares;
    opens com.example.trabalhofinal.jasper to javafx.fxml;
    exports com.example.trabalhofinal.jasper;
}