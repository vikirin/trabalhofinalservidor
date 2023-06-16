module com.example.trabalhors2 {
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
    exports auxiliares;
    opens auxiliares to javafx.fxml;
    exports jasper;
    opens jasper to javafx.fxml;
}