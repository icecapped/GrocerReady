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
		ArrayList<Ingredient> ingredient = null;
		if(url != null) 
		{
			try 
			{	
				// open the next recipe
				for(int i = 0; i < url.size() - 1; i++)
				{
					ArrayList<Ingredient> temp = WebReader.getIngredients(url.get(i));
					// add the ingredients from the list at this url
					for (int j = 0; j < temp.size() - 1; j++)
					{
						ingredient.add(temp.get(j));
					}
					// add together ingredients from different recipes.
				} // end of for(int i = 0; i < url.size() - 1; i++)
			}
			
			catch (IOException e)
			{
				return new String[] {"ERROR (1)"};
			}
			
			if (ingredient == null)
			{
				return new String [] {"ERROR (2)"};
			}
			
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
			return new String[] {"Please enter a valid url."};
		} // end of if url is valid
	}
} // end of public InputProcessor(String url)
	

