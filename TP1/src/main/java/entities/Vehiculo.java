package entities;

public class Vehiculo {
    private String color;
    private String marca;
    private int modelo;
    private Radio radio;
    private int precio;

    public Vehiculo(String color, String marca, int modelo, String radio, int precio) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.radio = new Radio(radio);
        this.precio = precio;
    }

    public Vehiculo(String color, String marca, int modelo, String radio) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.radio = new Radio(radio);
    }

    public Vehiculo(String color, String marca, int modelo, int precio) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.radio = new Radio("sin radio");
    }

    public void agregarRadio(String radio){
        this.radio=new Radio(radio);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", radio=" + radio + ", precio=" + precio + '}';
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public Radio getRadio() {
        return radio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void cambiarRadio(String radio) {
        this.radio=new Radio(radio);
    }

 
    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
