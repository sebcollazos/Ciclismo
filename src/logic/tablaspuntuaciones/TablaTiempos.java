package logic.tablaspuntuaciones;
import logic.tiempo.Tiempo;
import java.util.ArrayList;


public class TablaTiempos implements Tabla {



    private ArrayList<Tiempo> tabla;



    public ArrayList<Tiempo> getTabla() {
        return tabla;
    }
    public void setTabla(ArrayList<Tiempo> tabla) {
        this.tabla = tabla;
    }



    public TablaTiempos() {

    }
    public TablaTiempos(ArrayList<Tiempo> tabla) {
        this.tabla = tabla;
    }


    @Override
    public void ordenar(){
        for (int i = 0; i< this.tabla.size() - 1; i++){
            Tiempo tmp1 = this.tabla.get(i);
            int num1 = tmp1.getSegundos() + (tmp1.getMinutos()*60) +
                       (tmp1.getHoras()*60*60);
            for (int k = i; k < this.tabla.size() - 2; k++){
                Tiempo tmp2 = this.tabla.get(k+1);
                int num2 = tmp2.getSegundos() + (tmp2.getMinutos()*60) +
                           (tmp2.getHoras()*60*60);
                if (num2 > num1){
                    this.tabla.set(i, tmp2);
                    this.tabla.set(k+1, tmp1);
                }
            }
        }
    }
}
