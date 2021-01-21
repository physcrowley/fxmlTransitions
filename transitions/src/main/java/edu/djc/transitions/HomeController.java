package edu.djc.transitions;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void switchToTransitions() throws IOException {
        App.setRoot("transitions");
    }
}
