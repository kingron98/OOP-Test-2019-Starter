package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{	
	ArrayList<Colour> colours = new ArrayList<Colour>();

	ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	// public void separate(int value)
	// {
	// 	int hundreds = (value / 100);
	// 	int tens = (value - (hundreds * 100)) / 10;
	// 	int ones = value - ((hundreds * 100)  + (tens * 10));
	// 	print(hundreds + ",");
	// 	print(tens + ",");
	// 	println(ones);
	// }

	public void settings()
	{
		size(500, 800);
		
		// separate(381);
		// separate(1);
		// separate(92);
	}

	public void setup() 
	{
		loadColours();
		printColours();
		loadResistor();
		printResistor();
	}

	public void loadColours()
	{
		Table t = loadTable("colours.csv", "header");
		for(TableRow tr : t.rows())
		{
			Colour c = new Colour(tr);
			colours.add(c);
		}
	}

	public void printColours()
	{
		for(Colour c : colours)
		{
			println(c);
		}
	}
	
	public Colour findColour(int value)
	{
		for(Colour c : colours)
		{
			if(c.value == value)
			{
				return c;
			}
		}
		return null;
	}

	public void loadResistor()
	{
		Table t = loadTable("resistors.csv");
		for(TableRow tr : t.rows())
		{
			Resistor r = new Resistor(this, tr.getInt(0));
			resistors.add(r);
		}
	}

	public void printResistor()
	{
		for(Resistor r : resistors)
		{
			println(r.value + "," + r.hundreds + "," + r.tens + "," + r.ones);
		}
	}

	public void draw()
	{		
		for(int i = 0; i < resistors.size(); i++)
		{
			float y = map(i, 0, resistors.size(), 100, height - 100);
			resistors.get(i).render(width / 2, y);
		}
	}
}
