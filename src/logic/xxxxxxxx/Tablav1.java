package logic.xxxxxxxx;

import logic.ciclistas.Registro;

import java.util.ArrayList;


abstract class Tablav1 {



    private ArrayList<Registro> tabla;


    public Tablav1(){

    }
    public Tablav1(ArrayList<Registro> tabla) {
        this.tabla = tabla;
    }



    public ArrayList<Registro> getTabla() {
        return this.tabla;
    }
    public void setTabla(ArrayList<Registro> reg) {
        this.tabla = reg;
    }



    public void cambiar(int i, Registro tmp2, int k, Registro tmp1){
        this.tabla.set(i, tmp2);
        this.tabla.set(k, tmp1);
    }



    public abstract void ordenar();
}
