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
	
	//Recipe Input Declarations
	Button addURL;
	Button submitURLs;
	Text recipeInputTitle;
	BorderPane ingredientBorderPane;
	HBox titleAndURL;
	Scene scene;
	TextField URLField;
	TextArea URLDisplay;
	String URLs = "";
	
	//Ingredients Display Declarations
	Text ingredientsTitle;
	BorderPane ingredientsBorderPane;
	HBox ingredientsTitleAndURL;
	TextArea ingredientsDisplay;
	Stage ingredientStage;
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
            	         	
            	ingredientStage = new Stage();
            	ingredientsBorderPane = new BorderPane();
            	
                
            	//horizontal box for title, URL field and addURL button
                ingredientsTitleAndURL = new HBox();
            	
                //set window title
            	ingredientStage.setTitle("Grocer Ready - Ingredients List");     
                
            	//main title
            	ingredientsTitle = new Text("Grocer Ready - Ingredients List");
            	ingredientsTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
            	ingredientsTitle.setFill(Color.WHITE);
//            	ingredientsTitle.setOpacity(0);
                
                //initialize horizontal box
                ingredientsTitleAndURL.getChildren().add(ingredientsTitle);
                ingredientsTitleAndURL.setPadding(new Insets(0, 10, 10, 20));
                ingredientsTitleAndURL.setSpacing(30);
                ingredientsTitleAndURL.setStyle("-fx-background-color: #72A329;");
                
                //bottom text box
                ingredientsDisplay = new TextArea();
                ingredientsDisplay.setPrefSize(1205, 500);
                ingredientsDisplay.setEditable(false);
                
                String finalDisplayOutput = "";
                
                for (int i = 0; i < finalOutput.length; i++) {
                	finalDisplayOutput += finalOutput[i] + "\n";
                }
                
                ingredientsDisplay.setText(finalDisplayOutput);
                //grid to add padding to text box
                GridPane ingredientsDisplayGrid = new GridPane();
                ingredientsDisplayGrid.setPadding(new Insets(30,35,30,35));
                ingredientsDisplayGrid.add(ingredientsDisplay, 0, 0);
                ingredientsDisplay.setFont(Font.font("Segoe UI Light", 20));             
                ingredientsBorderPane.setTop(ingredientsTitleAndURL);
                ingredientsBorderPane.setCenter(ingredientsDisplayGrid);
                
                finalScene = new Scene(ingredientsBorderPane, 1280, 720);
                ingredientStage.setScene(finalScene);
                ingredientStage.show();
                
            }
        });
    	
    	//horizontal box for title, URL field and addURL button
        titleAndURL = new HBox();
    	
        //set window title
    	primaryStage.setTitle("Grocer Ready - Recipe Input");     
        
    	//main title
    	recipeInputTitle = new Text("Grocer Ready");
    	recipeInputTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
    	recipeInputTitle.setFill(Color.WHITE);
    	recipeInputTitle.setOpacity(0.9);
        
        //initialize horizontal box
        titleAndURL.getChildren().add(recipeInputTitle);
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
        
        //main body ingredientBorderPane pane
        ingredientBorderPane = new BorderPane();
        ingredientBorderPane.setTop(titleAndURL);
        ingredientBorderPane.setCenter(URLListGrid);
        ingredientBorderPane.setBottom(submitURLsGrid);
        
        //reveal scene
        scene = new Scene(ingredientBorderPane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
