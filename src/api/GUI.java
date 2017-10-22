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
//import javafx.geometry.Insets;

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
    	
        titleAndURL = new HBox();
        border = new BorderPane();
        border.setTop(titleAndURL);
    	
    	primaryStage.setTitle("Grocer Ready");     
        
        title = new Text("Grocer Ready");
        title.setFont(Font.font("Segoe UI Light", 80));
        title.setFill(Color.WHITE);
        
        titleAndURL.getChildren().add(title);
        titleAndURL.setPadding(new Insets(0, 10, 10, 200));
        titleAndURL.setSpacing(10);
        titleAndURL.setStyle("-fx-background-color: #72A329;");
        
        scene = new Scene(border, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    
    public void showIngredients(Stage finalStage, ArrayList<Ingredient> allIngredients) throws Exception {
        finalStage.setTitle("Grocer Ready");

    }
}
