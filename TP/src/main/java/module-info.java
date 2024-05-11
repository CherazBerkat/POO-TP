module com.example.tp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp to javafx.fxml;
    exports com.example.tp;
}