package net;
import java.net.*;
import java.util.*;
import main.Ingredient;

import java.io.*;

public class WebReader {

	/*
	 * TODO, make a method to seperate into quantity/unit/description
	 */
	
	public static ArrayList<String> /*ArrayList<String>*/ getIngredients(String link) throws IOException{
		URL url = new URL(link);
		URLConnection website = url.openConnection();
		BufferedReader html = new BufferedReader(new InputStreamReader(website.getInputStream()));
		
		if(link.length() < 22){ //too short, prevents errors
			return null;
		}
		if(link.substring(0, 29).equals("http://allrecipes.com/recipe/")){
			return fetchAR(html);
		}
		
			return null;
	}
	
	private static ArrayList<String> fetchAR(BufferedReader html) throws IOException{ //Allrecipes
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();

		String s;
		while((s = html.readLine()) != null){
			if(s.contains("itemprop=\"ingredients\"")){ // fetching ingredients
				String ingredientString;
				int left = s.indexOf("itemprop=\"ingredients\"");
				String temp = s.substring(left);
				int right =	temp.indexOf('<');
				ingredientString = temp.substring(23, right);
				System.out.println(ingredientString);
				list.add(new Ingredient());
			}
		}
		return null;
	}
}
