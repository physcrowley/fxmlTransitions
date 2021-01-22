package edu.djc.transitions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application 
{
    @Override
    public void start(Stage stage) throws IOException 
    {
    	FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("transitions.fxml"));
    	var scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.setTitle("JavaFX Scene Graph Demo with FXML"); 
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch();
    }

}