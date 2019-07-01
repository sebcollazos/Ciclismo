package logic.xxxxxxxx;
import logic.ciclistas.Registro;

import java.util.ArrayList;


public class TablaTiempos extends Tablav1 {



    public ArrayList<Registro> getTabla() {
        return super.getTabla();
    }
    public void setTabla(ArrayList<Registro> tabla) {
        super.setTabla(tabla);
    }



    public TablaTiempos() {
        super();
    }
    public TablaTiempos(ArrayList<Registro> tabla) {
        super(tabla);
    }


    @Override
    public void ordenar() {
        for (int i = 0; i< super.getTabla().size() - 1; i++){
            Registro tmp1 = super.getTabla().get(i);
            int num1 = tmp1.getTiempo().getSegundos() +
                       (tmp1.getTiempo().getMinutos() * 60) +
                       (tmp1.getTiempo().getHoras() * 60 * 60);
            for (int k = i; k < super.getTabla().size() - 2; k++){
                Registro tmp2 = super.getTabla().get(k+1);
                int num2 = tmp2.getTiempo().getSegundos() +
                           (tmp2.getTiempo().getMinutos() * 60) +
                           (tmp2.getTiempo().getHoras() * 60 * 60);
                if (num2 > num1){
                    super.cambiar(i, tmp2, k+1, tmp1);
                }
            }
        }
    }
}
