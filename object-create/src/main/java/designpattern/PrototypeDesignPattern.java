package designpattern;

import java.util.HashMap;
import java.util.Map;

abstract  class Colour implements Cloneable{
    protected String colourName;
    abstract void addColour();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

class BlueColour extends Colour{
    public BlueColour(){
        this.colourName = "Blue";
    }

    @Override
    void addColour() {
        System.out.println("Blue colour saved");
    }
}

class RedColour extends Colour{
    public RedColour(){
        this.colourName = "Red";
    }

    @Override
    void addColour() {
        System.out.println("Red colour saved");
    }
}

class colourStore {
    private static Map<String, Colour> nameAndColours = new HashMap<>();

    static{
        nameAndColours.put("Blue", new BlueColour());
        nameAndColours.put("Red", new RedColour());
    }

    public static getColour()
}

public class PrototypeDesignPattern {

    public static void main(String[] args) {

    }
}
