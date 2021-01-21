module edu.djc.transitions {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens edu.djc.transitions to javafx.fxml;
    exports edu.djc.transitions;
}