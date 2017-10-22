package main;
import java.io.IOException;
import java.util.ArrayList;
import net.WebReader;
/**
 * @author admin
 * Gets ingredients from a given website.
 *
 */
public class InputProcessor {
	
	String url;
	
	
	public InputProcessor()
	{
		url = "";
		
	}
	/**
	 * Gets an ingredient list from the GUI and formats then returns it as an array
	 * @param url
	 * @return the ingredients represented by strings
	 */
	public String[] getIngredients(ArrayList<String> url)
	{
		ArrayList<Ingredient> ingredient;
		if(url != null) 
		{
			try 
			{
				for(int i = 0; i < url.size() - 1; i++)
				{
					ingredient.add(WebReader.getIngredients(url[i]));
					// add together ingredients from different recipes.
				} // end of for(int i = 0; i < url.size() - 1; i++)
			}
			catch (IOException e)
			{
				
				return new String[] {"ERROR (2)"};
			}
			// consolidate the ingredients.
			ingredient = IngredientCollector.processedList(ingredient);
			// convert the ingredients into a array of string ingredient representations
			String[] finalIngredient = new String[ingredient.size()];
			for (int i = 0; i < finalIngredient.length - 1; i++)
			{
				finalIngredient[i] = ingredient.get(i).toString();
			} // end of for for (int i = 0; i < finalIngredient.length - 1, i++)
			
			// return an array of string ingredient representations.
			return finalIngredient;
			 
		} // end of if url is valid
		else
		{
			String[] finalIngredient = new String[1];
			finalIngredient[0] = "Please enter a valid url.";
			return finalIngredient;
		}
	}
	
	
} // end of public InputProcessor(String url)
	

