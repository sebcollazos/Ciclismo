package logic.ciclistas;
import java.util.ArrayList;

public class Equipo {

    private ArrayList<Ciclista> ciclistas;
    private String nombre;
    private String codigo;

    public Equipo() {

    }

    public Equipo(ArrayList<Ciclista> cicistas, String nombre) {
        this.ciclistas = cicistas;
        this.nombre = nombre;
        generarCodigo();
    }

    public ArrayList<Ciclista> getCicistas() {
        return ciclistas;
    }

    public void setCicistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void generarCodigo() {

        String a= this.nombre;

        String[] c = a.split("");

        this.codigo= c[0] + c[1] + c[2];

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

