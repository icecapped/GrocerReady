package main;
import java.util.ArrayList;

public class IngredientsCollector {

	/* evaluating*/
	
	public static void consolidateIngredients(ArrayList<Ingredient>  ingredientsArray) {
		for (int index=0; index<ingredientsArray.size(); index++) {
			for (int j=index+1; j< ingredientsArray.size(); j++) {
				if (ingredientsArray.get(index).description).equals(ingredientsArray.get(j).description)) {
			}
		
		}//end of for statement in consolidateIngredients
	
	}

}//end of public class IngredientsCollector
