package logic.ciclistas;
import logic.tiempo.Tiempo;



public class Registro {



    private Ciclista ciclista;
    private Tiempo tiempo;
    private Double puntos;



    public Registro(){

    }
    public Registro(Ciclista ciclista, Tiempo tiempo, Double puntos) {
        this.ciclista = ciclista;
        this.tiempo = tiempo;
        this.puntos = puntos;
    }



    public Ciclista getCiclista() {
        return ciclista;
    }
    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }
    public Tiempo getTiempo() {
        return tiempo;
    }
    public void setTiempo(Tiempo tiempo) {
        this.tiempo = tiempo;
    }
    public Double getPuntos() {
        return puntos;
    }
    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }
}
