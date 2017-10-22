package main;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import net.WebReader;
/**
 * @author admin
 * Gets ingredients from a given website.
 *
 */
public class InputProcessor {
	
	/**
	 * Gets an ingredient list from the GUI and formats then returns it as an array
	 * @param url
	 * @return the ingredients represented by strings
	 */
	public static String[] getIngredients(ArrayList<String> url)
	{
		ArrayList<Ingredient> ingredient = new ArrayList<Ingredient>();
		if(url != null) 
		{
			try 
			{	
				// open the next recipe
				for(int i = 0; i < url.size(); i++)
				{
					ArrayList<Ingredient> temp = WebReader.getIngredients(url.get(i));
					// add the ingredients from the list at this url
					
					ingredient.addAll(temp);
					
					// add together ingredients from different recipes.
				} // end of for(int i = 0; i < url.size() - 1; i++)
			}
			catch (IOException e)
			{
				return new String[] {"ERROR"};
			}
			
			if (ingredient.size() == 0)
			{
				// WebReader said that url was too short.
				return new String [] {"ERROR"};
			}
			// only passed this point if not returned already
			// consolidate the ingredients.

			ingredient = IngredientsCollector.consolidateIngredients(ingredient);
			// convert the ingredients into a array of string ingredient representations
			String[] finalIngredient = new String[ingredient.size()];
			for (int i = 0; i < finalIngredient.length - 1; i++)
			{
				finalIngredient[i] = ingredient.get(i).toString();
			} // end of for for (int i = 0; i < finalIngredient.length - 1, i++)
			
			// return an array of string ingredient representations.
			return finalIngredient;	 
			
		} 
		else
		{	
			return new String[] {"ERROR"};
		} // end of if url is valid
	}
} // end of public InputProcessor(String url)
	

