module com.matheus.leite {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.matheus.leite to javafx.fxml;
    exports com.matheus.leite;
}
