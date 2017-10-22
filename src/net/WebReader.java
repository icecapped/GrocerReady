package net;
import java.net.*;
import java.util.*;
import main.Ingredient;

import java.io.*;

public class WebReader {

	/*
	 * TODO, make a method to seperate into quantity/unit/description
	 */
	
	private static Ingredient stringToIngredient(String s){
		Ingredient ing = new Ingredient(0, s, "");
		
		if(s.indexOf(' ') < s.indexOf('/')){ // processing whole number/mixed fraction
			ing.quantity = Integer.parseInt(s.substring(0, s.indexOf(' ')));
			s = s.substring(s.indexOf(' ') + 1);

		}
		if(s.indexOf(0) >= 48 && s.indexOf(0) <= 57){ //fraction
			int num = Integer.parseInt(s.substring(0, s.indexOf('/')));
			
		}
		
		//checking if has a unit
		String word = s.substring(0, s.indexOf(' '));
		if(Ingredient.unitListFull.toString().contains(word) || Ingredient.unitListFullConverted.toString().contains(word)){
			ing.unit = word;
			s = s.substring(s.indexOf(' ' + 1));
		}
		ing.description = s;
	}
	
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