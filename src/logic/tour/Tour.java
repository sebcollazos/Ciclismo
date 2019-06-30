package logic.tour;
import logic.ciclistas.Equipo;
import java.util.ArrayList;

public class Tour {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Tour(String nombre, ArrayList<Equipo> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
}
