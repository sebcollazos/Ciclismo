package logic.puntuacion;



public class Tiempo{



    private int horas;
    private int minutos;
    private int segundos;



    public Tiempo(){

    }
    public Tiempo(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }



    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }



    @Override
    public Puntaje calcularPuntos(Tiempo t, String op){
        Tiempo tmp = new Tiempo(this.getHoras(), this.getMinutos(),
                                this.getSegundos());
        if (op.equals("+")){



        }
        else if (op.){



        }
        return null;
    }
}