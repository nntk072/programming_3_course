

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xblong
 */
public class ValueNode extends Node{
    private final Object value;

    public ValueNode() {
        this.value = null;
        /*this.string = null;
        this.number = null;
        this.truth = null;*/
    }
    public ValueNode(double value) {
        this.value = value;
    }
    public ValueNode(String value) {
        this.value = value;
    }
    public ValueNode(boolean value) {
        this.value = value;
    }

    

    public boolean isNumber() {
        return value instanceof Double;
    }
    public boolean isBoolean() {
        return value instanceof Boolean;
    }
    public boolean isString() {
        return value instanceof String;
    }
    public boolean isNull() {
        return value == null;
    }
    public String getString() {
        return (String) value;
    }
    public double getNumber() {
        return (double) value;
    }
    public Object getNull() {
        return value;
    }
    public boolean getBoolean() {
        return (boolean) value;
    }
}
