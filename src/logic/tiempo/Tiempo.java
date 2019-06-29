package logic.tiempo;



public class Tiempo {



    private int horas;
    private int minutos;
    private int segundos;



    public Tiempo() {

    }
    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }



    public int getHoras() { return horas; }
    public void setHoras(int horas) { this.horas = horas; }
    public int getMinutos() { return minutos; }
    public void setMinutos(int minutos) { this.minutos = minutos; }
    public int getSegundos() { return segundos; }
    public void setSegundos(int segundos) { this.segundos = segundos; }



    public Tiempo calcularTiempo(Tiempo t, String op) {
        Tiempo tm = new Tiempo(this.getHoras(), this.getMinutos(), this.getSegundos());
        if (op.equals("+")) {
            int tmp1 = t.getSegundos() + tm.getSegundos();
            if (tmp1 >= 60) {
                tm.setSegundos(tmp1 - 60);
                tm.setMinutos(tm.getMinutos() + 1);
            }
            else {
                tm.setSegundos(tmp1);
            }
            int tmp2 = t.getMinutos() + tm.getSegundos();
            if (tmp2 >= 60) {
                tm.setMinutos(tmp2 - 60);
                tm.setHoras(tm.getHoras() + 1);
            }
            else {
                tm.setMinutos(tmp2);
            }
            tm.setHoras(tm.getHoras() + horas);
        }
        return tm;
    }
}
