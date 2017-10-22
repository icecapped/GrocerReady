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
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

	public void init(String[] args) {
        launch(args);
    }
	
	public void testWait(){
	    final long INTERVAL = 2000;
	    long start = System.nanoTime();
	    long end=0;
	    do{
	        end = System.nanoTime();
	    }while(start + INTERVAL >= end);
	    System.out.println(end - start);
	}
	
	Button addURL;
	Button submitURLs;
	Text title;
	BorderPane border;
	HBox titleAndURL;
	Scene scene;
	TextField URLField;
	TextArea URLDisplay;
	String URLs = "";
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//Initialize GUI Objects
    	
    	
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
    	addURL.setStyle("fx-background-color: #000000");
    	//GridPane for top margin for addURL Button
    	GridPane addURLGrid = new GridPane();
    	addURLGrid.setPadding(new Insets(25,0,0,0));
    	addURLGrid.add(addURL, 0, 0);
    	addURL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Check for errors
            	InputProcessor testURL = new InputProcessor();
                ArrayList<String> arrToTestURL = new ArrayList<>();
                Boolean errorOrNo = false;
                arrToTestURL.add(URLField.getText());
                
                //Invalid URL Error
                String [] Error = {"ERROR"};
                if (testURL.getIngredients(arrToTestURL)[0].equals((Error)[0])) {
                	URLField.setText("Invalid URL");
//                	testWait();
                	errorOrNo = true;
                }
            	
                if (!errorOrNo) {
                	//Update URL String/Log
                	URLs = URLs + URLField.getText() + "\n" + " ";
                }
                URLField.setText("Enter next URL... or click submit.");
                URLDisplay.setText(URLs);
            }
        });
    	
    	//horizontal box for title, URL field and addURL button
        titleAndURL = new HBox();
    	
        //set window title
    	primaryStage.setTitle("Grocer Ready");     
        
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
        //grid to add padding to text box
        GridPane URLListGrid = new GridPane();
        URLListGrid.setPadding(new Insets(30,35,30,35));
        URLListGrid.add(URLDisplay, 0, 0);
        URLDisplay.setFont(Font.font("Segoe UI Light", 20));
        
        //main body border pane
        border = new BorderPane();
        border.setTop(titleAndURL);
        border.setCenter(URLListGrid);
        
        //reveal scene
        scene = new Scene(border, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    
    public void showIngredients(Stage finalStage, ArrayList<Ingredient> allIngredients) throws Exception {
        finalStage.setTitle("Grocer Ready");

    }
}
