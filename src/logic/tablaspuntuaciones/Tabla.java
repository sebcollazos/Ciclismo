package logic.tablaspuntuaciones;
import logic.ciclistas.Registro;
import java.util.ArrayList;



public class Tabla {



    private ArrayList<Registro> tabla;



    public Tabla(){
        this.tabla = new ArrayList<>();
    }
    public Tabla(ArrayList<Registro> tabla) {
        this.tabla = tabla;
    }



    public ArrayList<Registro> getTabla() { return this.tabla; }
    public void setTabla(ArrayList<Registro> reg) { this.tabla = reg; }



    public void addRegistro(Registro r){
        tabla.add(r);
    }



    public void organizar(){

        for (int i = 0; i< this.tabla.size() - 1; i++){
            Registro tmp1 = this.tabla.get(i);
            int num1 = tmp1.getTiempo().getSegundos() +
                    (tmp1.getTiempo().getMinutos() * 60) +
                    (tmp1.getTiempo().getHoras() * 60 * 60);
            for (int k = i; k < this.tabla.size() - 1; k++){
                Registro tmp2 = this.tabla.get(k+1);
                int num2 = tmp2.getTiempo().getSegundos() +
                        (tmp2.getTiempo().getMinutos() * 60) +
                        (tmp2.getTiempo().getHoras() * 60 * 60);
                if (num2 < num1){

                    this.tabla.set(i, tmp2);
                    this.tabla.set(k+1, tmp1);

                }
            }
        }

    }
}
