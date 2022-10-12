module com.calculadora {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.model.calculadora to javafx.fxml;
    exports com.model.calculadora;
}
