module com.example.caesercipherprogect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.caesercipherprogect to javafx.fxml;
    exports com.example.caesercipherprogect;
}