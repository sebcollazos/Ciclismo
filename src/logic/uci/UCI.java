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

    public ArrayList<Double> calcularPuntosMontania(Double aF, Double aI, Double Km){

        Double gradoMontaña= ((aF-aI)/Km) *  100;
        ArrayList<Double> categoria= new ArrayList<>();

        if(gradoMontaña >= 140 && gradoMontaña <250){

            Double p= 20.0;

            for(int i=0 ; i < 6; i++){
                if(p> 4){
                    categoria.add(i, p);
                    p= p-4;
                }else{
                    categoria.add(i, 2.0);
                }
            }

        }else if(gradoMontaña >= 80 && gradoMontaña <140){

            Double p= 10.0;

            for(int i=0 ; i < 6; i++){
                if(p> 4){
                    categoria.add(i, p);
                    p= p-2;
                }else{
                    categoria.add(i, 1.0);
                }
            }

        }else if(gradoMontaña >= 50 && gradoMontaña <80){
            Double p= 5.0;
            Double b= 1.0;

            for(int i=0 ; i < 6; i++){
                b= b + 1.0;
                categoria.add(i, p);
                p= p-b;
            }
        }else if(gradoMontaña >= 30 && gradoMontaña <50){
            Double p= 2.0;

            for(int i=0 ; i < 1; i++){
                categoria.add(i, p);
                p= p-1.0;
            }
        }else if(gradoMontaña >= 20 && gradoMontaña <30){
            categoria.add(0, 1.0);
        }



        return categoria;

    }
}
