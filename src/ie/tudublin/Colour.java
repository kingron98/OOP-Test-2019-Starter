package ie.tudublin;


import processing.core.PApplet;
import processing.data.TableRow;

public class Colour 
{
    private String colour;
    public int r;
    public int g;
    public int b;
    public int value;

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String getColour()
    {
        return this.colour;
    }

    public void setR(int r)
    {
        this.r = r;
    }

    public int getR()
    {
        return this.r;
    }

    public void setG(int g)
    {
        this.g = g;
    }

    public int getG()
    {
        return this.g;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    public int getB()
    {
        return this.b;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
    
    public String toString()
    {
        return colour + "\t" + r + "\t" 
            + g + "\t" + b + "\t" + value;
    }

    public Colour(String colour, int r, int g, int b, int value)
    {
        this.colour = colour;
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }

    public Colour()
    {
        this("", 0, 0, 0, 0);
    }

    public Colour(TableRow tr)
    {
        this(
            tr.getString("colour")
            , tr.getInt("r")
            , tr.getInt("g")
            , tr.getInt("r")
            , tr.getInt("value")
        );
    }

}