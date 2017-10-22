package main;

public class IngredientsCollector {
	
	/* initializing the constants*/
	private static final double OUNCE_TO_GRAMS= 28.34952;
	private static final double POUNDS_TO_KILOGRAMS= 0.453592;
	private static final double TABLESPOONS_TO_MILLILITRES= 14.7868;
	private static final double TEASPOONS_TO_MILLILITRES= 4.92892;
	private static final double INCHES_TO_CENTIMETRES= 2.54;
	private static final double FEET_TO_CENTIMETRES= 30.48;
	private static final double CUPS_TO_LITRES= 0.24;
	private static final double PINTS_TO_LITRES= 0.473176;	
	
	private double numberOfKilograms;
	private double numberOfMillilitres;
	private double numberOfLitres;
	private double numberOfCentimetres;
	private double numberOfGrams;
	
	/* evaluating*/
	
	public static double toGrams(double quantity, String units) {
		double converted = 0;
		if (units=="oz") {
			quantity= OUNCE_TO_GRAMS * quantity;
			units="gr";
		}//end of if
		else {
			converted= quantity;
			units= "gr";
		}// end of else
		return converted;
	}
	
	public IngredientsCollector(double quantity, String description, String units) {
		
	}


}//end of public class IngredientsCollector
