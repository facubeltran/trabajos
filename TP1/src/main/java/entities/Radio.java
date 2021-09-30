package entities;


public class Radio {
    private String marcaRadio;

    public Radio(String marcaRadio) {
        this.marcaRadio = marcaRadio;
    }


    @Override
    public String toString() {
        return "Radio{" + "marcaRadio=" + marcaRadio + '}';
    }

    public String getMarcaRadio() {
        return marcaRadio;
    }


}
