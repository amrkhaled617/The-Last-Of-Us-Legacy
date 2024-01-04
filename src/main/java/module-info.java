module milestone3.milestone3final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires  javafx.media;

    opens GUI to javafx.fxml;
    exports GUI;
}