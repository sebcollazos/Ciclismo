package logic.tour;
import logic.ciclistas.Registro;
import logic.tablaspuntuaciones.Tabla;
import logic.tiempo.Tiempo;

import java.util.ArrayList;



public class Organizador {



    private String nombre;



    public Organizador(String nombre) {
        this.nombre = nombre;
    }



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public ArrayList<Double> calcularPuntosMontania(Etapa etapa){

        Double aF= etapa.getAlturaFinal();
        Double aI= etapa.getAlturaInicial();
        Double Km= etapa.getKilometros();

        Double gradoMontania= ((aF-aI)/Km) *  100;
        ArrayList<Double> categoria= new ArrayList<>();

        if(gradoMontania >= 140 && gradoMontania <250){

            Double p= 20.0;

            for(int i=0 ; i < 6; i++){
                if(p> 4){
                    categoria.add(i, p);
                    p= p-4;
                }else{
                    categoria.add(i, 2.0);
                }
            }

        }else if(gradoMontania >= 80 && gradoMontania <140){

            Double p= 10.0;

            for(int i=0 ; i < 6; i++){
                if(p> 4){
                    categoria.add(i, p);
                    p= p-2;
                }else{
                    categoria.add(i, 1.0);
                }
            }

        }else if(gradoMontania >= 50 && gradoMontania <80){
            Double p= 5.0;
            Double b= 1.0;

            for(int i=0 ; i < 6; i++){
                b= b + 1.0;
                categoria.add(i, p);
                p= p-b;
            }
        }else if(gradoMontania >= 30 && gradoMontania <50){
            Double p= 2.0;

            for(int i=0 ; i < 1; i++){
                categoria.add(i, p);
                p= p-1.0;
            }
        }else if(gradoMontania >= 20 && gradoMontania <30){

            categoria.add(0, 1.0);

        }else {

            for(int i=0; i< categoria.size(); i++){
                categoria.add(i, 0.0);
            }

        }



        return categoria;

    }

    public Tabla actualizarTablaTiempos(Tour tour){


        Tabla tablaGeneral= tour.getEtapas().get(0).getLista();




        for(int i=1; i < tablaGeneral.getTabla().size() ; i++){

            for(int j= 1; j < tour.getEtapas().size() ; j++){

                String nombreTablaGeneral= tablaGeneral.getTabla().get(i).getCiclista().getNombre();
                String nombreEtapa= tour.getEtapas().get(j).getLista().getTabla().get(j).getCiclista().getNombre();

                Tiempo tiempoTablaGeneral= tablaGeneral.getTabla().get(i).getTiempo();
                Tiempo tiempoTablaEtapa= tour.getEtapas().get(i).getLista().getTabla().get(i).getTiempo();

                if(nombreTablaGeneral.equals(nombreEtapa)){

                    tiempoTablaGeneral.calcularTiempo( tiempoTablaEtapa , "+" );

                }

            }

        }

        tablaGeneral.organizar();

        return tablaGeneral;

    }

    public Tabla actualizarTablaPuntos(Tour tour){

        ArrayList<Double> puntos;


        Tabla tablaPuntos= tour.getEtapas().get(0).getLista();

        for(int i=0; i < tablaPuntos.getTabla().size(); i++){

            for(int j= 1; j < tour.getEtapas().size(); j++){

                puntos= this.calcularPuntosMontania(tour.getEtapas().get(j));

                sumarPuntosEtapa(tour.getEtapas().get(j), puntos);

                String nombreTablaGeneral= tablaPuntos.getTabla().get(i).getCiclista().getNombre();
                String nombreEtapa= tour.getEtapas().get(j).getLista().getTabla().get(j).getCiclista().getNombre();

                Double PuntosTotales= tour.getEtapas().get(j).getLista().getTabla().get(j).getPuntos() + tablaPuntos.getTabla().get(i).getPuntos();

                if(nombreTablaGeneral.equals(nombreEtapa)){

                    tablaPuntos.getTabla().get(i).setPuntos(PuntosTotales);

                }

            }

        }

        return tablaPuntos;

    }

    public void sumarPuntosEtapa(Etapa etapa, ArrayList<Double> puntos){

        etapa.getLista().organizar();

        for (int i = 0; i < puntos.size(); i++){
            etapa.getLista().getTabla().get(i).setPuntos(
                etapa.getLista().getTabla().get(i).getPuntos() + puntos.get(i));
        }

    }

}
