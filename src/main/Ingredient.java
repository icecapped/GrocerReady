package main;

public class Ingredient {

	private static final String[] unitList = {"lb", "kg", "L", "tbsp", "tsp", "oz", 
				"in", "cm", "ft", "nu"};
	
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
		} // end of unit conversion
		
		
	}
	
}

