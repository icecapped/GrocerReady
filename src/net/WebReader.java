package net;
import java.net.*;
import java.util.*;
import main.Ingredient;

import java.io.*;

public class WebReader {

	public static ArrayList<Ingredient> getIngredients(String link) throws IOException{
		URL url = new URL(link);
		URLConnection website = url.openConnection();
		BufferedReader html = new BufferedReader(new InputStreamReader(website.getInputStream()));
		
		if(link.length() < 22){ //too short, prevents errors
			return null;
		}
		if(link.substring(0, 23).equals("allrecipes.com")){
			return fetchAR(html);
		}
		
		return null;
	}
	
	private static ArrayList<Ingredient> fetchAR(BufferedReader html) throws IOException{ //Allrecipes
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		
		String s;
		while((s = html.readLine()) != null){
			if(s.contains("itemprop=\"ingredients\"")){
				
			}
		}
		return null;
	}
}
