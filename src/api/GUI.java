package api;

import main.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.util.ArrayList;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

	public void init(String[] args) {
        launch(args);
    }
	
	//Recipe Input Declarations
	Button addURL;
	Button submitURLs;
	Text recipeInputTitle;
	BorderPane ingredientBorderPane;
	HBox recipeInputTitleAndURL;
	Scene scene;
	TextField URLField;
	TextArea URLDisplay;
	String URLs = "";
	Text pleaseWait;
	Text blankTitle;
	
	
	//Ingredients Display Declarations
	Text ingredientsTitle;
	BorderPane ingredientsBorderPane;
	HBox ingredientsTitleAndURL;
	TextArea ingredientsDisplay;
	Stage ingredientsStage;
	Scene ingredientsScene;
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	//URL Field
    	URLField = new TextField();
    	URLField.setText("Enter Recipe URL here...");
    	URLField.setPrefSize(650, 60);
    	URLField.setFont(Font.font("Segoe IU Light", FontWeight.LIGHT, 30));
    	//Grid Pane for URL Field
    	GridPane URLFieldGrid = new GridPane();
    	URLFieldGrid.setPadding(new Insets(25,0,0,0));
    	URLFieldGrid.add(URLField, 0, 0);
    	
    	//Add URL Button
    	addURL = new Button();
    	addURL.setText("Add URL");
    	addURL.setPrefSize(90, 60);
    	//Grid Pane for Add URL Button
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
                }
                else {
                	URLs = URLs + URLField.getText() + "\n";
                }
                URLField.setText("Enter next URL... or click submit.");
                URLDisplay.setText(URLs);
            }
        });
    	
    	//please wait
    	pleaseWait = new Text("Please wait...");
    	pleaseWait.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 25));
    	pleaseWait.setFill(Color.web("#f4f4f4"));
    	
    	//blank text
    	blankTitle = new Text("NOTHING");
    	blankTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 25));
    	blankTitle.setFill(Color.web("#f4f4f4"));
    	
    	//Submit URLs Button
    	submitURLs = new Button();
    	submitURLs.setText("Submit links");
    	submitURLs.setPrefSize(200, 60);
    	//GridPane
    	GridPane submitURLsGrid = new GridPane();
    	submitURLsGrid.setPadding(new Insets(0,0,30,800));
    	submitURLsGrid.add(pleaseWait, 0, 0);
    	submitURLsGrid.add(blankTitle, 1, 0);
    	submitURLsGrid.add(submitURLs, 2, 0);
    	
    	//Button Action
    	submitURLs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pleaseWait.setFill(Color.BLACK);
            	ArrayList<String> totalURLs = new ArrayList<>();
            	
            	String filteredURLs = URLs;
            	filteredURLs = filteredURLs.replaceAll("Invalid URL.\n", "");
            	
            	String[] arr = filteredURLs.split("\n");
            	
            	for (int i = 0; i < arr.length; i++) {
            		totalURLs.add(arr[i]);
            	}
            	
            	String[] finalOutput = InputProcessor.getIngredients(totalURLs);
            	         	
            	ingredientsStage = new Stage();
            	ingredientsBorderPane = new BorderPane();
            	
                
            	//horizontal box for title, URL field and addURL button
                ingredientsTitleAndURL = new HBox();
            	
                //set window title
            	ingredientsStage.setTitle("Grocer Ready - Ingredients List");     
                
            	//main title
            	ingredientsTitle = new Text("Grocer Ready - Ingredients List");
            	ingredientsTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
            	ingredientsTitle.setFill(Color.web("#f4f4f4"));
            	
            	
            	
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
                
                //Grid to add padding to text box
                GridPane ingredientsDisplayGrid = new GridPane();
                ingredientsDisplayGrid.setPadding(new Insets(30,35,30,35));
                ingredientsDisplayGrid.add(ingredientsDisplay, 0, 0);
                ingredientsDisplay.setFont(Font.font("Segoe UI Light", 20));             
                ingredientsBorderPane.setTop(ingredientsTitleAndURL);
                ingredientsBorderPane.setCenter(ingredientsDisplayGrid);
                
                ingredientsScene = new Scene(ingredientsBorderPane, 1280, 720);
                ingredientsStage.setScene(ingredientsScene);
                ingredientsStage.show();
                
                pleaseWait.setFill(Color.web("#f4f4f4"));
                
            }
        });
    	
    	//horizontal box for title, URL field and addURL button
        recipeInputTitleAndURL = new HBox();
    	
        //set window title
    	primaryStage.setTitle("Grocer Ready - Recipe Input");     
        
    	//main title
    	recipeInputTitle = new Text("Grocer Ready");
    	recipeInputTitle.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
    	recipeInputTitle.setFill(Color.WHITE);
    	recipeInputTitle.setOpacity(0.9);
        
        //initialize horizontal box
        recipeInputTitleAndURL.getChildren().add(recipeInputTitle);
        recipeInputTitleAndURL.getChildren().add(URLFieldGrid);
        recipeInputTitleAndURL.getChildren().add(addURLGrid);
        recipeInputTitleAndURL.setPadding(new Insets(0, 10, 10, 20));
        recipeInputTitleAndURL.setSpacing(30);
        recipeInputTitleAndURL.setStyle("-fx-background-color: #72A329;");
        
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
        ingredientBorderPane.setTop(recipeInputTitleAndURL);
        ingredientBorderPane.setCenter(URLListGrid);
        ingredientBorderPane.setBottom(submitURLsGrid);
        
        //reveal scene
        scene = new Scene(ingredientBorderPane, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
