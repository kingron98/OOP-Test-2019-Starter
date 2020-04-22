package ie.tudublin;


import processing.core.PApplet;
import processing.data.TableRow;

public class Resistor 
{
    public int value;
    UI ui;
    public int ones;
    public int tens;
    public int hundreds;
    Colour h;
    Colour t;
    Colour o;

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setOnes(int ones)
    {
        this.ones = ones;
    }

    public int getOnes()
    {
        return this.ones;
    }

    public void setTens(int tens)
    {
        this.tens = tens;
    }

    public int getTens()
    {
        return this.tens;
    }

    public void setHundreds(int hundreds)
    {
        this.hundreds = hundreds;
    }

    public int getHundreds()
    {
        return this.hundreds;
    }

    public Resistor(UI ui, int value)
    {
        this.ui = ui;
        this.value = value;
        int hundreds = (value / 100);
        int tens = (value - (hundreds * 100)) / 10;
        int ones = value - ((hundreds * 100)  + (tens * 10));
        this.hundreds = hundreds;
        this.tens = tens;
        this.ones = ones;
        h = ui.findColour(hundreds);
        t = ui.findColour(tens);
        o = ui.findColour(ones);
    }

    public void render(float x, float y)
    {
        ui.pushMatrix();
        ui.translate(x, y);

        ui.stroke(0);
        ui.line(-50, -50, 50, -50);
        ui.line(50, -50, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, -50);

        ui.noStroke();
        ui.fill(h.r, h.g, h.b);
        ui.rect(-49, -50, 10, 100);

        ui.noStroke();
        ui.fill(t.r, t.g, t.b);
        ui.rect(-38, -50, 10, 100);

        ui.noStroke();
        ui.fill(o.r, o.g, o.b);
        ui.rect(-27, -50, 10, 100);
        ui.popMatrix();
    }
}