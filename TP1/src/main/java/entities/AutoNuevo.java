
package entities;


public class AutoNuevo extends Vehiculo{
    private String GPS;

    public AutoNuevo(String GPS, String color, String marca, int modelo, String radio, int precio) {
        super(color, marca, modelo, radio, precio);
        this.GPS = GPS;
        
    }

    public AutoNuevo(String GPS, String color, String marca, int modelo, String radio) {
        super(color, marca, modelo, radio);
        this.GPS = GPS;
    }

    @Override
    public String toString() {
        return "AutoNuevo{" + "GPS=" + GPS +" , " + super.toString()+'}';
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    
    
}
