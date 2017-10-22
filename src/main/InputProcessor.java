package main;
import java.util.ArrayList;
import net.WebReader;
/**
 * @author admin
 * Gets ingredients from a given website.
 *
 */
public class InputProcessor {
	
	String url;
	ArrayList<Ingredient> ingredient;
	
	public InputProcessor()
	{
		url = "";
		ingredient = null;
	}
	public InputProcessor(String url)
	{
		if(url != null) 
		{
			try 
			{
				ingredient = WebReader.getIngredients(url);
			}
			catch (IOException e)
			{
				// 
			}
		} // end of if url is valid
	} // end of public InputProcessor(String url)
	
}
