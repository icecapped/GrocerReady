package main;
import java.util.ArrayList;

/**
 * Consolidates the ingredients and condenses array if like terms are seen
 * @author Lokeesan Kaneshwaran, Michael Shi, Dave Singh, Ana Han
 * @version 1.0
 *
 */

public class IngredientsCollector {

	/* evaluating*/
	/**
	 * Consolidates the array if it finds like terms
	 * @param ingredientsArray the array list of all ingredients (with its knowing responsibilities of description, units, and quantities) 
	 * @return ingredientsArray the condensed ArrayList after like terms have been found
	 */
	public static ArrayList<Ingredient> consolidateIngredients(ArrayList<Ingredient>  ingredientsArray) {
		for (int index=0; index<ingredientsArray.size()+1; index++) {
			for (int j=index+1; j< ingredientsArray.size(); j++) {
				if (ingredientsArray.get(index).description.equals(ingredientsArray.get(j).description) && ingredientsArray.get(index).unit==ingredientsArray.get(j).unit) {
					ingredientsArray.get(index).quantity += ingredientsArray.get(j).quantity;
					ingredientsArray.remove(j);
				}//end of if
			}//end of for (j) statement
		}//end of for consolidateIngredients i statement
		if (ingredientsArray.get(ingredientsArray.size()).description== ingredientsArray.get(ingredientsArray.size()-1).description) {
			if (ingredientsArray.get(ingredientsArray.size()).unit== ingredientsArray.get(ingredientsArray.size()-1).unit) {
				ingredientsArray.get(ingredientsArray.size()-1).quantity += ingredientsArray.get(ingredientsArray.size()).quantity;
				ingredientsArray.remove(ingredientsArray.remove(ingredientsArray.size()));
			}//end of if the unit is the same
		}//end of if description is the same
		for (int index=0; index<ingredientsArray.size(); index++) {
			if (ingredientsArray.get(index).unit=="mL" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity/= 1000;
				ingredientsArray.get(index).unit="L";
			}//end of if
			else if (ingredientsArray.get(index).unit=="gr" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity/=  1000;
				ingredientsArray.get(index).unit="kg";
			}//end of else if 1 
			else if (ingredientsArray.get(index).unit=="cm" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity/= 1000;
				ingredientsArray.get(index).unit= "km";
			}//end of else if 2
			else if (ingredientsArray.get(index).unit=="cm" && ingredientsArray.get(index).quantity>=100) {
				ingredientsArray.get(index).quantity/=100;
				ingredientsArray.get(index).unit="m";
			}//end of else if 3
		}//end of for (int index=0; index< ingredientsArray.size(); index++)
			return ingredientsArray;
	}//end of method ArrayList consolidateIngredients
}//end of class IngredientsCollector


