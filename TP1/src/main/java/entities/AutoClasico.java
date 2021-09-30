
package entities;


public class AutoClasico extends Vehiculo{
    private String tipoDeNeumatico;

    public AutoClasico(String tipoDeNeumatico, String color, String marca, int modelo, String radio, int precio) {
        super(color, marca, modelo, radio, precio);
        this.tipoDeNeumatico = tipoDeNeumatico;
    }

    public AutoClasico(String tipoDeNeumatico, String color, String marca, int modelo, int precio) {
        super(color, marca, modelo, precio);
        this.tipoDeNeumatico = tipoDeNeumatico;
    }

    @Override
    public String toString() {
        return "AutoClasico{" + "tipoDeNeumatico=" + tipoDeNeumatico +" , "+ super.toString()+ '}';
    }

    public String getTipoDeNeumatico() {
        return tipoDeNeumatico;
    }

    public void setTipoDeNeumatico(String tipoDeNeumatico) {
        this.tipoDeNeumatico = tipoDeNeumatico;
    }
    

    
}
