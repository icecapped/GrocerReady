package net;

import javafx.application.Application;
import api.GUI;

public class main {
	
	public static void main(String[] args) {

		GUI GrocerShoppingGUI;
		GrocerShoppingGUI= new GUI();
		
		String[] emptyStringArray = new String[0];
		
		GrocerShoppingGUI.init(emptyStringArray);

	}
}
