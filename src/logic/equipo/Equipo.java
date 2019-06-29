package logic.equipo;
import logic.ciclista.Ciclista;
import java.util.ArrayList;

public class Equipo {
    private ArrayList<Ciclista> cicistas;
    private String nombre;
    private String codigo;

    public Equipo() {

    }

    public Equipo(ArrayList<Ciclista> cicistas, String nombre, String codigo) {
        this.cicistas = cicistas;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public ArrayList<Ciclista> getCicistas() {
        return cicistas;
    }
    public void setCicistas(ArrayList<Ciclista> cicistas) {
        this.cicistas = cicistas;
    }
    public String getCodigo() {
        return codigo;
    }
    public void generarCodigo() {
        this.codigo = this.nombre.charAt(0) + this.nombre.charAt(1) + this.nombre.charAt(2);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean addCiclista(Ciclista c) {
	for (int i = 0; i<= this.ciclistas.size(); i++) {
	    if (this.ciclistas.get(i).getNombre().equals(c.getNombre())){
		return false;
	    }
	}
	this.ciclistas.add(c);
	return true;
    }
    public boolean removeCiclista(String n){
	for (int i = 0; i <= this.ciclistas.size(); i++){
	    if (this.ciclistas.get(i).getNombre().equals(n)){
		this.ciclistas.remove(i);
		return true;
	    }
	}
	return false;
    }
}

