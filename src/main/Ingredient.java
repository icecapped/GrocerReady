package main;

public class Ingredient {
	
	public static final String[] unitListFull = {"pound", "pounds", "kilogram", 
			"kilograms", "litre", "litres","liter","liters","cups", "cup", "pint", "pints", "millilitre", "millilitres", "milliliter","milliliters","tablespoon", 
			"tablespoons", "teaspoon", "teaspoons", "ounce", "ounces", "inch", "inches",
			"centimeters", "centimetres", "centimetre", "centimeter", "foot", "feet"};
	
	public static final String[] unitListFullConverted = {"lb", "lb", "kg", "kg", "L", "L", "L","L", "cp", "cp", "p", "p",
		"mL", "mL", "mL", "mL", "tbsp", "tbsp", "tsp", "tsp", "oz", "oz", "in", "in", "cm", "cm",
		"cm", "cm", "ft", "ft"};
	
	public String description;
	public double quantity;
	public String unit;
	
	private static final double OUNCE_TO_GRAMS= 28.34952;
	private static final double POUNDS_TO_KILOGRAMS= 0.453592;
	private static final double TABLESPOONS_TO_MILLILITRES= 14.7868;
	private static final double TEASPOONS_TO_MILLILITRES= 4.92892;
	private static final double INCHES_TO_CENTIMETRES= 2.54;
	private static final double FEET_TO_CENTIMETRES= 30.48;
	private static final double CUPS_TO_LITRES= 0.24;
	private static final double PINTS_TO_LITRES= 0.473176;	
	
	
	public Ingredient()
	{
		quantity = 0;
		unit = "";
		description = "";
		
	}// end of constructor Ingredient()
	public Ingredient (double quantity, String description, String unit)
	{
		this.quantity = quantity;
		this.description = description;	
		unit = unit.toLowerCase();
		
		for (int i = 0; i < unitListFull.length; i++) {
			if (unitListFull[i].equals(unit)) this.unit = unitListFullConverted[i];
		}//end of for (int i=0; i< unitListFull.length; i++)
		
	}//end of public Ingredient(double quantity, String description, String unit)
	public String toString()
	{
		System.out.println(unit);
		if(unit == null)
		{
			return quantity + " " + description;
		}
		else
		{
			return quantity + unit + " " + description;
		} // end of quantity checking 
	} // end of method return
	
	public void convertUnits() {
		
		
		if (unit== "oz") {
			quantity = quantity * OUNCE_TO_GRAMS;
			unit="gr";
		}//end of initial if
		else if (unit=="L") {
			quantity= quantity* 1000;
			unit="mL";
		}
		
		else if (unit=="lb") {
			quantity= quantity * POUNDS_TO_KILOGRAMS*1000;
			unit= "gr";
		}//end of else if 1
		else if (unit=="tbsp") {
			quantity= quantity * TABLESPOONS_TO_MILLILITRES;
			unit= "mL";
		}//end of else if 2
		else if (unit=="tsp") {
			quantity= quantity * TEASPOONS_TO_MILLILITRES;
			unit="mL";
		}//end of else if 3
		else if (unit=="in") {
			quantity= quantity* INCHES_TO_CENTIMETRES;
			unit="cm";
		}// end of else if 4
		else if (unit=="ft") {
			quantity= quantity* FEET_TO_CENTIMETRES;
			unit= "cm";
		}// end of else if 5
		else if (unit=="cp") {
			quantity=quantity* CUPS_TO_LITRES*1000;
			unit="mL";
		}//end of else if 6
		else if (unit== "p") {
			quantity= quantity* PINTS_TO_LITRES*1000;
			unit="mL";
		}//end of else if 7
		//end of public void convertUnits()//end of public class Ingredient

	}
	
	//variable methods
	
}//end of public class Ingredient

