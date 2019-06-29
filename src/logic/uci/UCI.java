package logic.uci;
import logic.tour.Tour;
import java.util.ArrayList;

public class UCI {
    private String nombre;
    private ArrayList<Tour> tours;

    public UCI(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean addTour(Tour t){
        for(int i=0; i< this.tours.size(); i++){
            if (this.tours.get(i).getNombre().equals(t.getNombre())){
                return false;
            }
        }

        this.tours.add(t);
        return true;

    }

    public ArrayList<Double> calcularPuntosMontaña(Double aF, DOuble aI, Double Km){

        Double gradoMontaña= ((aF-aI)/Km) *  100;
        String categoria= " ";

        if(gradoMontaña >= 140 && gradoMontaña <250){
            categoria= "Especial";
        }else if(gradoMontaña >= 80 && gradoMontaña <140){
            categoria= "1ra";
        }else if(gradoMontaña >= 50 && gradoMontaña <80){
            categoria= "2da";
        }else if(gradoMontaña >= 30 && gradoMontaña <50){
            categoria= "3ra";
        }else if(gradoMontaña >= 20 && gradoMontaña <30){
            categoria= "4ta";
        }

        return null;

    }
}
