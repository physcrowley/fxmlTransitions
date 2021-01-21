package edu.djc.transitions;

import java.io.IOException;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TransitionsController {

    private boolean clicked = false;
	
	@FXML
    private Rectangle r;
    
    @FXML
    private Button run;
    
    @FXML
    private void toHome() throws IOException {
    	App.setRoot("home");
    }
    
    @FXML
    private void runAnimation() {
    	if (clicked) run.setText("deactivated");
    	
    	else
    	{
    		clicked = true;
    		
	    	r.setFill(Color.PINK);
	    	
	    	TranslateTransition translate = 
	        new TranslateTransition(Duration.millis(850)); 
	        translate.setToX(400); 
	        translate.setToY(400); 
	       
	        //Filling transition
	        FillTransition fill = new FillTransition(Duration.millis(425)); 
	        fill.setToValue(Color.YELLOW); 
	       
	        //Setting rotation time
	        RotateTransition rotate = new RotateTransition(Duration.millis(850)); 
	        rotate.setToAngle(350); 
	             
	        //Scaling transition
	        ScaleTransition scale = new ScaleTransition(Duration.millis(850)); 
	        scale.setToX(0.2); 
	        scale.setToY(0.2); 
	             
	        //Setting parallel transition
	        ParallelTransition transition = new ParallelTransition(r, 
	        translate, fill, rotate, scale); 
	        transition.setCycleCount(Timeline.INDEFINITE);
	        transition.setAutoReverse(true); 
	        transition.play();
    	}
    }
}