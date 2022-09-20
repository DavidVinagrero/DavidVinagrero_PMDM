package model;

public class Coche {
    //Propiedades
    private String marca, modelo, bastidor;
    private int cv, velocidad, km;
    private double cc;

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Coche(){

    }

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche(String marca, String modelo, String bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
    }

    public Coche(String marca, String modelo, String bastidor, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.cv = cv;
    }

    public Coche(String marca, String modelo, String bastidor, int cv, int velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.cv = cv;
        this.velocidad = velocidad;
    }

    public Coche(String marca, String modelo, String bastidor, int cv, int velocidad, int km) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.cv = cv;
        this.velocidad = velocidad;
        this.km = km;
    }

    public Coche(String marca, String modelo, String bastidor, int cv, int velocidad, int km, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.cv = cv;
        this.velocidad = velocidad;
        this.km = km;
        this.cc = cc;
    }// </editor-fold>

    //Métodos
    public void acelerarCoche(int velocidad){
        //Si los cv son superiores a 150, incrementar en un 20% la velocidad
        if(this.cv>150){
            this.velocidad= this.velocidad+velocidad+(int)(velocidad*0.2);
        } else {
            this.velocidad+=velocidad;
        }
    }

    public boolean decelerarCoche(int velocidad){
        //Si pasan una vel mayor de la actual pongo 0 y resto false
        //en caso contrario hago la operacion y retorno true.
        if(this.velocidad<velocidad){
            this.velocidad=0;
            return false;
        } else {
            this.velocidad-=velocidad;
            return true;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCv() {
        return cv;
    }

    public double getCc() {
        return cc;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getKm() {
        return km;
    }// </editor-fold>

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", bastidor='" + bastidor + '\'' +
                ", cv=" + cv +
                ", velocidad=" + velocidad +
                ", km=" + km +
                ", cc=" + cc +
                '}';
    }
}
