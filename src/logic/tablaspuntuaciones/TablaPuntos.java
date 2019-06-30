package logic.tablaspuntuaciones;
import java.util.ArrayList;



public class TablaPuntos extends Tabla {


    //Preguntar
    private ArrayList<Double> tabla;



    public ArrayList<Double> getTabla() {
        return tabla;
    }
    public void setTabla(ArrayList<Double> tabla) {
        this.tabla = tabla;
    }



    public TablaPuntos() {

    }
    public TablaPuntos(ArrayList<Double> tabla) {
        this.tabla = tabla;
    }


    @Override
    public void ordenar(){
        for (int i = 0; i< this.tabla.size() - 1; i++){
            Double tmp1 = this.tabla.get(i);
            Double num1 = tmp1;
            for (int k = i; k < this.tabla.size() - 2; k++){
                Double tmp2 = this.tabla.get(k+1);
                Double num2 = tmp2;
                if (num2 > num1){
                    this.tabla.set(i, tmp2);
                    this.tabla.set(k+1, tmp1);
                }
            }
        }
    }
}
