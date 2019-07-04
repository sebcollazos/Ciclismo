package logic.tour;
import logic.ciclistas.Equipo;
import logic.tablaspuntuaciones.Tabla;

import java.util.ArrayList;



public class Tour {



    private String nombre;
    private ArrayList<Equipo> equipos;
    private ArrayList<Etapa> etapas;
    private Tabla general;



    public Tour (){
        this.equipos = new ArrayList<>();
        this.etapas = new ArrayList<>();
        this.general = new Tabla();
    }
    public Tour(String nombre, ArrayList<Equipo> equipos, ArrayList<Etapa> etapas, Tabla general) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.etapas= etapas;
        this.general = general;
    }



    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Equipo> getEquipos() { return equipos; }
    public void setEquipos(ArrayList<Equipo> equipos) { this.equipos = equipos; }
    public ArrayList<Etapa> getEtapas() { return this.etapas; }
    public void setEtapas(ArrayList<Etapa> etapas) { this.etapas = etapas; }
    public Tabla getGeneral() { return general; }
    public void setGeneral(Tabla general) { this.general = general; }



    public Boolean addEquipo(Equipo e){
        for (int i = 0; i< this.equipos.size(); i++) {
            if (this.equipos.get(i).getNombre().equals(e.getNombre())){
                return Boolean.FALSE;
            }
        }
        this.equipos.add(e);
        return Boolean.TRUE;
    }



    public boolean removeEquipo(String n){
        for (int i = 0; i <= this.equipos.size(); i++){
            if (this.equipos.get(i).getNombre().equals(n)){
                this.equipos.remove(i);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }



    public boolean addEtapa(Etapa etapa){
        if (etapa.getAlturaInicial() >= 0 && etapa.getAlturaFinal() >= 0 && etapa.getKilometros() > 0){
            this.etapas.add(etapa);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }



    public boolean removeEtapa(int i){
        if(i > 0){
            this.etapas.remove(i-1);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
