package net;

import main.Ingredient;
import main.IngredientsCollector;
import java.io.*;
import java.net.*;
import java.util.*;

public class WebReader {

	/*
	 * TODO, make a method to seperate into quantity/unit/description
	 */
	
	private static Ingredient stringToIngredient(String s){
		Ingredient ing = new Ingredient(0, s, "");
		String numbers = "0123456789";
		
		if((s.indexOf(' ') != -1 && (s.indexOf('/') == -1 || s.indexOf(' ') < s.indexOf('/'))) && numbers.contains(s.substring(0, 1))){ // processing whole number/mixed fraction
			ing.quantity = Integer.parseInt(s.substring(0, s.indexOf(' ')));
			s = s.substring(s.indexOf(' ') + 1);

		}
		if(s.charAt(0) >= 48 && s.charAt(0) <= 57){ //fraction
			int num = Integer.parseInt(s.substring(0, s.indexOf('/')));
			s = s.substring(s.indexOf('/') + 1);
			int denom = Integer.parseInt(s.substring(0, s.indexOf(' ')));
			ing.quantity = (double)num / denom;
			s = s.substring(s.indexOf(' ') + 1);
		}
		
		//checking if has a unit
		if(s.indexOf(' ') != -1){
			String word = s.substring(0, s.indexOf(' '));
			System.out.println(ing.unit);
			if(Arrays.toString(Ingredient.unitListFull).contains(word) || Arrays.toString(Ingredient.unitListFullConverted).contains(word)){ //
				ing = new Ingredient(ing.quantity, ing.description, s.substring(0, s.indexOf(' '))); //because constructor groups units
				System.out.println(s.substring(0, s.indexOf(' ')));
				s = s.substring(s.indexOf(' ') + 1);
			}
		}
		ing.description = s;
		ing.convertUnits();
		return ing;
	}
	
	public static ArrayList<Ingredient> /*ArrayList<String>*/ getIngredients(String link) throws IOException{
		URL url = new URL(link);
		URLConnection website = url.openConnection();
		BufferedReader html = new BufferedReader(new InputStreamReader(website.getInputStream()));
		
		if(link.length() < 22){ //too short, prevents errors
			return null;
		}
		if(link.substring(0, 29).equals("http://allrecipes.com/recipe/")){
			ArrayList<Ingredient> al = new ArrayList<Ingredient>();
			ArrayList<String> as = fetchAR(html); //converting as into al
			for(int i = 0; i < as.size(); i++){
				al.add(WebReader.stringToIngredient(as.get(i)));
			}
			return al;
		}
		
		return null;
	}
	
	private static ArrayList<String> fetchAR(BufferedReader html) throws IOException{ //Allrecipes
		ArrayList<String> list = new ArrayList<String>();

		String s;
		while((s = html.readLine()) != null){
			if(s.contains("itemprop=\"ingredients\"")){ // fetching ingredients
				String ingredientString;
				int left = s.indexOf("itemprop=\"ingredients\"");
				String temp = s.substring(left);
				int right =	temp.indexOf('<');
				ingredientString = temp.substring(23, right);
				list.add(ingredientString);
			}
		}
		return list;
	}
	
	public static void main(String[] args) throws IOException{
		ArrayList<Ingredient> two = WebReader.getIngredients("http://allrecipes.com/recipe/73021/summer-squash-chicken-alfredo/?internalSource=hub%20recipe&referringContentType=search%20results&clickId=cardslot%204");
		two.addAll(WebReader.getIngredients("http://allrecipes.com/recipe/73021/summer-squash-chicken-alfredo/?internalSource=hub%20recipe&referringContentType=search%20results&clickId=cardslot%204"));
		ArrayList<Ingredient> al = IngredientsCollector.consolidateIngredients(two);
		for(int i = 0; i < al.size(); i++){
			System.out.println(al.get(i).quantity + " : " + al.get(i).unit + " : " + al.get(i).description);
		}
	}
}