package main;

public class Ingredient {


	
	private static final String[] unitListFull = {"pound", "pounds", "kilogram", 
			"kilograms", "litre", "litres","liter","liters","cups", "cup", "pint", "pints", "millilitre", "millilitres", "milliliter","milliliters","tablespoon", 
			"tablespoons", "teaspoon", "teaspoons", "ounce", "ounces", "inch", "inches",
			"centimeters", "centimetres", "centimetre", "centimeter", "foot", "feet", 
			""};
	
	private static final String[] unitListFullConverted = {"lb", "lb", "kg", "kg", "L", "L", "cp", "cp", "p", "p",
		"mL", "mL", "tbsp", "tbsp", "tsp", "tsp", "oz", "oz", "in", "in", "cm", "cm",
		"cm", "cm", "ft", "ft"};
	
	private String description;
	private double quantity;
	private String unit;
	
	
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
			if (unitListFull[i].equals(description)) this.description = unitListFullConverted[i];
		}//end of for (int i=0; i< unitListFull.length; i++)
		
	}//end of public Ingredient(double quantity, String description, String unit)
	public String toString()
	{
		if (unit.equals("nu"))
		{
			return quantity + " " + description;
		}
		else
		{
			return quantity + unit + " " + description;
		} // end of quantity checking 
	} // end of method return
		
}//end of public class Ingredient

