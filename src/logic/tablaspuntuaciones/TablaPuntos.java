package logic.tablaspuntuaciones;
import logic.ciclistas.Registro;
import java.util.ArrayList;



public class TablaPuntos extends Tabla {



    public ArrayList<Registro> getTabla() {
        return super.getTabla();
    }
    public void setTabla(ArrayList<Registro> tabla) {
        super.setTabla(tabla);
    }



    public TablaPuntos() {
        super();
    }
    public TablaPuntos(ArrayList<Registro> tabla) {
        super(tabla);
    }



    @Override
    public void ordenar() {
        for (int i = 0; i< super.getTabla().size() - 1; i++){
            Registro tmp1 = super.getTabla().get(i);
            Double num1 = tmp1.getPuntos();
            for (int k = i; k < super.getTabla().size() - 2; k++){
                Registro tmp2 = super.getTabla().get(k+1);
                Double num2 = tmp2.getPuntos();
                if (num2 > num1){
                    super.cambiar(i, tmp2, k+1, tmp1);
                }
            }
        }
    }
}
