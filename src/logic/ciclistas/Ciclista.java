package logic.ciclistas;

public class Ciclista {


    private String nombre;
    private String nacionalidad;
    private int edad;
    private Double peso;
    private Double estatura;


    public Ciclista(String nombre, String s, int nacionalidad) {

    }

    public Ciclista(String nombre, String nacionalidad, int edad, Double peso, Double estatura) {
        this.nombre = nombre;
        this.nacionalidad=nacionalidad;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getEstatura() {
        return estatura;
    }
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }


}
