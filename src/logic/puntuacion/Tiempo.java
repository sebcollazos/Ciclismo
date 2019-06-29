package logic.puntuacion;



public class Tiempo {



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
        return this.horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public int getMinutos() {
        return this.minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public int getSegundos() {
        return this.segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }




    public Tiempo calcularPuntos(Tiempo t, String op){
        if(op.equals("+")){
            int tmp1 = t.getSegundos() + this.segundos;
            if (tmp1 >= 60){
                this.segundos = tmp1 - 60;
                this.minutos = this.minutos + 1;
            }
            else{
                this.segundos = tmp1;
            }
            int tmp2 = minutos + this.minutos;
            if (tmp2 >= 60){
                this.minutos = tmp2 - 60;
                this.horas = this.horas + 1;
            }
            else{
                this.minutos = tmp2;
            }
            this.horas = this.horas + horas;
        }
    }

}
