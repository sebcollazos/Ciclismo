package logic.tablaspuntuaciones;
import logic.ciclistas.Registro;
import java.util.ArrayList;



public class Tabla {



    private ArrayList<Registro> tabla;



    public Tabla(){

    }
    public Tabla(ArrayList<Registro> tabla) {
        this.tabla = tabla;
    }



    public ArrayList<Registro> getTabla() {
        return this.tabla;
    }
    public void setTabla(ArrayList<Registro> reg) {
        this.tabla = reg;
    }



    public void addRegistro(Registro r){
        tabla.add(r);
    }
}
