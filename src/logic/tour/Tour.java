package logic.tour;
import logic.ciclistas.Equipo;
import logic.tablaspuntuaciones.Tabla;

import java.util.ArrayList;

public class Tour {

    private String nombre;
    private ArrayList<Equipo> equipos;
    private ArrayList<Etapa> etapas;
    private Tabla general;

    public Tour(String nombre, ArrayList<Equipo> equipos, ArrayList<Etapa> etapas, Tabla general) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.etapas= etapas;
        this.general = general;
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
