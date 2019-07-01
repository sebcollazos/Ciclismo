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
}
