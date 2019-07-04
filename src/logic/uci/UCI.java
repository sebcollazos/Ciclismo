package logic.uci;
import logic.tour.Tour;
import java.util.ArrayList;

public class UCI {

    private String nombre;
    private ArrayList<Tour> tours;
    private ControlDatos controlDatos;
    private ControlTour controlTour;
    private Organizador organizador;

    public UCI(){
        this.tours = new ArrayList<>();
        this.controlDatos = new ControlDatos();
        this.controlTour = new ControlTour();
        this.organizador = new Organizador();
    }
    public UCI(String nombre){
        this.nombre = nombre;
        this.tours = new ArrayList<>();
        this.controlDatos = new ControlDatos();
        this.controlTour = new ControlTour();
        this.organizador = new Organizador();
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Tour> getTours() { return tours; }
    public void setTours(ArrayList<Tour> tours) { this.tours = tours; }
    public ControlDatos getControlDatos() { return controlDatos; }
    public void setControlDatos(ControlDatos controlDatos) { this.controlDatos = controlDatos; }
    public ControlTour getControlTour() { return controlTour; }
    public void setControlTour(ControlTour controlTour) { this.controlTour = controlTour; }
    public Organizador getOrganizador() { return organizador; }
    public void setOrganizador(Organizador organizador) { this.organizador = organizador; }


    public boolean addTour(Tour t){
        for(int i=0; i< this.tours.size(); i++){
            if (this.tours.get(i).getNombre().equals(t.getNombre())){
                return false;
            }
        }

        this.tours.add(t);
        return true;
    }

    public boolean removeTour(String nombre){
        for (int i = 0; i <= this.tours.size(); i++){
            if (this.tours.get(i).getNombre().equals(nombre)){
                this.tours.remove(i);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;

    }
}
