package logic.tour;

import logic.ciclistas.Registro;

import java.util.ArrayList;

public class Etapa {

    private Double alturaInicial;
    private Double alturaFinal;
    private Double Kilometros;

    private ArrayList<Registro> ordenLlegada;

    public Etapa(Double alturaInicial, Double alturaFinal, Double kilometros) {
        this.alturaInicial = alturaInicial;
        this.alturaFinal = alturaFinal;
        Kilometros = kilometros;
    }

    public Double getAlturaInicial() {
        return alturaInicial;
    }

    public void setAlturaInicial(Double alturaInicial) {
        this.alturaInicial = alturaInicial;
    }

    public Double getAlturaFinal() {
        return alturaFinal;
    }

    public void setAlturaFinal(Double alturaFinal) {
        this.alturaFinal = alturaFinal;
    }

    public Double getKilometros() {
        return Kilometros;
    }

    public void setKilometros(Double kilometros) {
        Kilometros = kilometros;
    }



}
