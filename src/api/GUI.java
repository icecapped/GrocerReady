package api;

import main.*;
import javafx.application.Application;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

	public void init(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	Button addURL;
    	Button submitURLs;
    	Text title;
    	BorderPane border;
    	HBox titleAndURL;
    	Scene scene;
    	TextField URLField = new TextField();
    	URLField.setText("Enter Recipe URL here...");
    	URLField.setPrefSize(650, 60);
    	URLField.setFont(Font.font("Segoe IU Light", FontWeight.LIGHT, 30));
    	GridPane URLFieldGrid = new GridPane();
    	URLFieldGrid.setPadding(new Insets(25,0,0,0));
    	URLFieldGrid.add(URLField, 0, 0);
//    	URLField.applyCss();
    	
        titleAndURL = new HBox();
        border = new BorderPane();
        border.setTop(titleAndURL);
    	
    	primaryStage.setTitle("Grocer Ready");     
        
        title = new Text("Grocer Ready");
        title.setFont(Font.font("Segoe UI Light", FontWeight.BOLD, 75));
        title.setFill(Color.WHITE);
        
        titleAndURL.getChildren().add(title);
        titleAndURL.getChildren().add(URLFieldGrid);
        titleAndURL.setPadding(new Insets(0, 10, 10, 20));
        titleAndURL.setSpacing(40);
        titleAndURL.setStyle("-fx-background-color: #72A329;");
        
        scene = new Scene(border, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    
    public void showIngredients(Stage finalStage, ArrayList<Ingredient> allIngredients) throws Exception {
        finalStage.setTitle("Grocer Ready");

    }
}
