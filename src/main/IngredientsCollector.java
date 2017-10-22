package main;
import java.util.ArrayList;

public class IngredientsCollector {

	/* evaluating*/
	
	public static ArrayList<Ingredient> consolidateIngredients(ArrayList<Ingredient>  ingredientsArray) {
		for (int index=0; index<ingredientsArray.size(); index++) {
			for (int j=index+1; j< ingredientsArray.size(); j++) {
				if (ingredientsArray.get(index).description.equals(ingredientsArray.get(j).description) && ingredientsArray.get(index).unit==ingredientsArray.get(j).unit) {
					ingredientsArray.get(index).description= ingredientsArray.get(index).description;
					ingredientsArray.get(index).quantity += ingredientsArray.get(j).quantity;
					ingredientsArray.get(index).unit= ingredientsArray.get(index).unit;
					ingredientsArray.remove(j);
				}//end of if
			}//end of for (j) statement
		}//end of for consolidateIngredients i statement
		for (int index=0; index<ingredientsArray.size(); index++) {
			if (ingredientsArray.get(index).unit=="mL" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity= ingredientsArray.get(index).quantity / 1000;
				ingredientsArray.get(index).unit="L";
			}
			else if (ingredientsArray.get(index).unit=="gr" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity= ingredientsArray.get(index).quantity / 1000;
				ingredientsArray.get(index).unit="kg";
			}
			else if (ingredientsArray.get(index).unit=="cm" && ingredientsArray.get(index).quantity>=1000) {
				ingredientsArray.get(index).quantity= ingredientsArray.get(index).quantity /1000;
				ingredientsArray.get(index).unit= "km";
			}
			else if (ingredientsArray.get(index).unit=="cm" && ingredientsArray.get(index).quantity>=100) {
				ingredientsArray.get(index).quantity= ingredientsArray.get(index).quantity /100;
				ingredientsArray.get(index).unit="km";
			}
		}
			return ingredientsArray;
	}
}

