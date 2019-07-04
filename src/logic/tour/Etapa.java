package logic.tour;
import  logic.ciclistas.Ciclista;
import logic.ciclistas.Registro;
import logic.tablaspuntuaciones.Tabla;
import logic.tiempo.Tiempo;
import java.util.ArrayList;



public class Etapa {



    private Double alturaInicial;
    private Double alturaFinal;
    private Double Kilometros;
    private Tabla lista;



    public Etapa(){
        this.lista = new Tabla();
    }
    public Etapa(Double alturaInicial, Double alturaFinal, Double kilometros,
                 ArrayList<Ciclista> ciclistas) {
        this.alturaInicial = alturaInicial;
        this.alturaFinal = alturaFinal;
        Kilometros = kilometros;
        Tiempo tmp1 = new Tiempo(0, 0, 0);
        Tabla tmp2 = new Tabla();
        for (int i = 0; i < ciclistas.size()-1 ; i++){
            Registro tmp3 = new Registro(ciclistas.get(i), tmp1, 0.0);
            tmp2.addRegistro(tmp3);
        }
        this.lista = tmp2;
    }



    public Double getAlturaInicial() { return this.alturaInicial; }
    public void setAlturaInicial(Double alturaInicial) { this.alturaInicial = alturaInicial; }
    public Double getAlturaFinal() { return this.alturaFinal; }
    public void setAlturaFinal(Double alturaFinal) { this.alturaFinal = alturaFinal; }
    public Double getKilometros() { return this.Kilometros; }
    public void setKilometros(Double kilometros) { Kilometros = kilometros; }
    public Tabla getLista() { return this.lista; }
    public void setLista(Tabla lista) { this.lista = lista; }

}
