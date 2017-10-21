package main;

public class Ingredient {

	private static final String[] unitList = {"lb", "kg", "L", "tbsp", "tsp", "oz", 
				"in", "cm", "ft", "nu"};
	
	private static final String[] unitListFull = {"pound", "pounds", "kilogram", 
			"kilograms", "litre", "litres", "mililitre", "mililitres", "tablespoon", 
			"tablespoons", "teaspoon", "teaspoons", "ounce", "ounces", "inch", "inches",
			"centimeters", "centimetres", "centimetre", "centimeter", "foot", "feet", 
			""};
	
private static final String[] unitListFullConverted = {"lb", "lb", "kg", "kg", "L", "L",
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
		
	}
	public Ingredient (double quantity, String description, String unit)
	{
		this.quantity = quantity;
		this.description = description;	
		unit = unit.toLowerCase();
		
		for (int i = 0; i < unitListFull.length; i++) {
			if (unitListFull[i].equals(description)) this.description = unitListFull[i];
		}
		
		switch(unit)
		{
		case "pound":
		case "pounds":
			unit = "lb";
			break;
		case "kilogram":
		case "kilograms":
			unit = "kg";
			break;
		case "litre":
		case "litres":
			unit = "L";
			break;
		case "mililitre":
		case "mililitres":
			unit = "mL";
			break;
		case "tablespoon":
		case "tablespoons":
			unit = "tbsp";
			break;
		case "teaspoon":
		case "teaspoons":
			unit = "tsp";
			break;
		case "ounce":
		case "ounces":
			unit = "oz";
<<<<<<< HEAD
			break;
		case "inch":
		case "inches":
			unit = "in";
			break;
		case "centimetre":
		case "centimetres":
			unit = "cm";
			break;
		case "foot":
		case "feet":
			unit = "ft";
			break;
		case "":
			unit = "nu"
			break;			
		} // end of unit type conversion
=======
		} // end of unit collection
		
		
>>>>>>> 002ed294d8938a76c6780bc3eb491a57377f1322
	}
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
		
}

