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

	/* Class fields that can be passed to the class methods 
	 * without passing parameters. These fields are named in
	 * the FXML file (the variable name needs to be the same here).
	 * 
	 * Having class fields is necessary since no parameters can 
	 * be passed from FXML method calls.
	 */
	
	@FXML
    private Rectangle r;
    
    @FXML
    private Button run, restart;
    
    // local
    private ParallelTransition transition;
    
    
    /*
     * Methods referenced in the linked FXML file
     */
    
    @FXML
    private void runAnimation() {
    	/* This prevents launching the infinite animation more than 
		 * once, which produces weird results.
		 */
    	run.setDisable(true);
    	restart.setDisable(false);
    	
		/*
		 * This animation is adapted from the non-FXML example on
		 * this site: http://mrbool.com/a-complete-guide-to-javafx/33010
		 */
        //Translate transition
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
        transition = new ParallelTransition
        		(r, translate, fill, rotate, scale); 
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true); 
        transition.play();
    }
    
    @FXML
    private void restart()
    {
    	// back to the top
    	r.setTranslateX(0);
    	r.setTranslateY(0);
    	r.setRotate(0);
    	r.setFill(Color.PINK);
    	r.setScaleX(1);
    	r.setScaleY(1);
    	
    	transition.playFromStart();
    }
}