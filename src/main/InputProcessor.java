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
			ingredient = WebReader.getIngredients(url);
		} // end of if url is valid
	} // end of public InputProcessor(String url)
	
}
