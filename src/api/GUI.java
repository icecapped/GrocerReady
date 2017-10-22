package api;

import main.*;
import javafx.application.Application;
import java.util.ArrayList;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;

public class GUI extends Application {

	public void init(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	Button addURL;
    	Button submitURLs;
    	Text title;
    	Font titleFont;
    	BorderPane border;
    	HBox titleAndURL;
    	Scene scene;
    	
        titleAndURL = new HBox();
        border = new BorderPane();
        border.setTop(titleAndURL);
    	
    	primaryStage.setTitle("Grocer Ready");     
        
        title = new Text("Grocery Ready");
        title.setFont(titleFont);
        
        scene = new Scene(border, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    
    public void showIngredients(Stage finalStage, ArrayList<Ingredient> allIngredients) throws Exception {
        finalStage.setTitle("Grocer Ready");

    }
    
}
