package api;

import main.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import java.lang.Object.*;

public class GUI extends Application {

	public void init(String[] args) {
        launch(args);
    }
	
	Button addURL;
	Button submitURLs;
	Text title;
	Text finalTitle;
	BorderPane border;
	BorderPane finalBorder;
	HBox titleAndURL;
	HBox finalTitleAndURL;
	Scene scene;
	TextField URLField;
	TextArea URLDisplay;
	TextArea IngredientsDisplay;
	String URLs = "";
	Stage secondStage;
	Scene finalScene;
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	
    	//URL Field
    	URLField = new TextField();
    	URLField.setText("Enter Recipe URL here...");
    	URLField.setPrefSize(650, 60);
    	URLField.setFont(Font.font("Segoe IU Light", FontWeight.LIGHT, 30));
    	//GridPane for top margin for URL Field
    	GridPane URLFieldGrid = new GridPane();
    	URLFieldGrid.setPadding(new Insets(25,0,0,0));
    	URLFieldGrid.add(URLField, 0, 0);
    	
    	//addURL Button
    	addURL = new Button();
    	addURL.setText("Add URL");
    	addURL.setPrefSize(90, 60);
//    	addURL.setStyle("fx-background-color: #000000");
    	//GridPane for top margin for addURL Button
    	GridPane addURLGrid = new GridPane();
    	addURLGrid.setPadding(new Insets(25,0,0,0));
    	addURLGrid.add(addURL, 0, 0);
    	//Button Action
    	addURL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Check for errors
                ArrayList<String> arrToTestURL = new ArrayList<>();
                Boolean errorOrNo = false;
                arrToTestURL.add(URLField.getText());
                
                //Invalid URL Error
                if (InputProcessor.getIngredients(arrToTestURL)[0].equals("ERROR")) {
                	URLField.setText("Invalid URL");                	
                	errorOrNo = true;
                }
            	
                if (errorOrNo) {
                	//Update URL String/Log
                	URLs = URLs + "Invalid URL.\n";
                	//remember to filter out "Invalid URL.\n" before passing on
                }
                else {
                	URLs = URLs + URLField.getText() + "\n";
                }
                URLField.setText("Enter next URL... or click submit.");
                URLDisplay.setText(URLs);
            }
        });
    	
    	//Submit URLs Button
    	submitURLs = new Button();
    	submitURLs.setText("Submit links");
    	submitURLs.setPrefSize(200, 60);
    	//GridPane
    	GridPane submitURLsGrid = new GridPane();
    	submitURLsGrid.setPadding(new Insets(0,0,30,1000));
    	submitURLsGrid.add(submitURLs, 0, 0);
    	//Button Action
    	submitURLs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	ArrayList<String> totalURLs = new ArrayList<>();
            	
            	String filteredURLs = URLs;
            	filteredURLs = filteredURLs.replaceAll("Invalid URL.\n", "");
            	
            	String[] arr = filteredURLs.split("\n");
            	
            	for (int i = 0; i < arr.length; i++) {
            		totalURLs.add(arr[i]);
            	}
            	
            	String[] finalOutput = InputProcessor.getIngredients(totalURLs);
            	//Test output
//            	for (int i = 0; i < finalOutput.length; i++) {
//            		System.out.println(finalOutput[i]);
//            	}
            	         	
            	secondStage = new Stage();
            	finalBorder = new BorderPane();
            	
                
            	//horizontal box for title, URL field and addURL button
                finalTitleAndURL = new HBox();
            	
                //set window title
            	secondStage.setTitle("Grocer Ready - Ingredients List");     
                
            	//main title
            	finalTitle = new Text("Grocer Ready - Ingredients List");
            	finalTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
            	finalTitle.setFill(Color.WHITE);
//            	finalTitle.setOpacity(0);
                
                //initialize horizontal box
                finalTitleAndURL.getChildren().add(finalTitle);
                finalTitleAndURL.setPadding(new Insets(0, 10, 10, 20));
                finalTitleAndURL.setSpacing(30);
                finalTitleAndURL.setStyle("-fx-background-color: #72A329;");
                
                //bottom text box
                IngredientsDisplay = new TextArea();
                IngredientsDisplay.setPrefSize(1205, 500);
                IngredientsDisplay.setEditable(false);
//                IngredientsDisplay.setStyle("-fx-background-color: green");
                
                String finalDisplayOutput = "";
                
                for (int i = 0; i < finalOutput.length; i++) {
                	finalDisplayOutput += finalOutput[i] + "\n";
                }
                
//                System.out.println();
                
                IngredientsDisplay.setText(finalDisplayOutput);
                //grid to add padding to text box
                GridPane IngredientsDisplayGrid = new GridPane();
                IngredientsDisplayGrid.setPadding(new Insets(30,35,30,35));
                IngredientsDisplayGrid.add(IngredientsDisplay, 0, 0);
                IngredientsDisplay.setFont(Font.font("Segoe UI Light", 20));
//                
                finalBorder.setTop(finalTitleAndURL);
                finalBorder.setCenter(IngredientsDisplayGrid);
                
                finalScene = new Scene(finalBorder, 1280, 720);
                secondStage.setScene(finalScene);
                secondStage.show();
                
            }
        });
    	
    	//horizontal box for title, URL field and addURL button
        titleAndURL = new HBox();
    	
        //set window title
    	primaryStage.setTitle("Grocer Ready - Recipe Input");     
        
    	//main title
        title = new Text("Grocer Ready");
        title.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
        title.setFill(Color.WHITE);
        title.setOpacity(0.9);
        
        //initialize horizontal box
        titleAndURL.getChildren().add(title);
        titleAndURL.getChildren().add(URLFieldGrid);
        titleAndURL.getChildren().add(addURLGrid);
        titleAndURL.setPadding(new Insets(0, 10, 10, 20));
        titleAndURL.setSpacing(30);
        titleAndURL.setStyle("-fx-background-color: #72A329;");
        
        //bottom text box
        URLDisplay = new TextArea();
        URLDisplay.setPrefSize(1205, 500);
        URLDisplay.setText(URLs);
        URLDisplay.setEditable(false);
        URLDisplay.setStyle("-fx-background-color: green");
        //grid to add padding to text box
        GridPane URLListGrid = new GridPane();
        URLListGrid.setPadding(new Insets(30,35,30,35));
        URLListGrid.add(URLDisplay, 0, 0);
        URLDisplay.setFont(Font.font("Segoe UI Light", 20));
        
        //main body border pane
        border = new BorderPane();
        border.setTop(titleAndURL);
        border.setCenter(URLListGrid);
        border.setBottom(submitURLsGrid);
        
        //reveal scene
        scene = new Scene(border, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
