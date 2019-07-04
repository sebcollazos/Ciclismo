package main;

import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;
import logic.tour.Tour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File directorio= null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            directorio= new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia");
            archivo = new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia\\participantes.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            String nombreTour= directorio.getName();

            ArrayList<Tour> tours= new ArrayList<Tour>();

            ArrayList<Equipo> equipos= new ArrayList<>();

            while((linea=br.readLine())!=null ) {

                String[] parrafo= null;

                parrafo = linea.split("/");

                Ciclista c= null;

                Equipo e= null;

                c= crearCiclisita(parrafo, c);

                System.out.println(c.getNombre()+"\n");

                if(parrafo.length >= 6){

                    e= crearequipo(e, parrafo);

                    agregarCiclista(c, e, parrafo);

                    agregarEquipo(e, equipos);

                }

            }



            if(equipos != null){

                for(int i=0; i< equipos.size(); i++){

                    System.out.println(equipos.get(i).getNombre());
                    System.out.println(equipos.get(i).getCodigo());

                    for(int j=0; j< equipos.get(i).getCicistas().size(); j++){

                        System.out.println(equipos.get(i).getCicistas().get(j).getNombre());

                    }

                    System.out.println("\n");

                }

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }


    }

    public static Ciclista crearCiclisita(String[] ciclista, Ciclista c){

        if(ciclista.length >= 6){

            String nombre= ciclista[1];

            String nacionalidad= ciclista[2];

            int edad= Integer.parseInt(ciclista[3]) ;

            Double peso= Double.parseDouble(ciclista[4]);

            Double estatura= Double.parseDouble(ciclista[5]);

            c = new Ciclista(nombre, nacionalidad, edad, peso, estatura);

        }

        return c;

    }

    public static Equipo crearequipo(Equipo e, String[] p){

        ArrayList<Ciclista> c = new ArrayList<>();

        Equipo equipo= new Equipo(c, p[0]);

        equipo.generarCodigo();

        return equipo;

    }

    public static void agregarCiclista(Ciclista c, Equipo e, String[] p){

        if( e.getNombre().equals(p[0]) ){

            e.addCiclista(c);

        }

    }

    public static void agregarEquipo(Equipo e, ArrayList<Equipo> equipos){

        int contador= 0;

        for(int i= 0; i < equipos.size(); i++){

            if( ( equipos.get(i).getNombre().equals(e.getNombre()) ) ){

                int cont2= 0;

                for(int j= 0; j<e.getCicistas().size(); j++){

                    for(int k=0; k< equipos.get(i).getCicistas().size(); k++){

                        if(equipos.get(i).getCicistas().get(k).getNombre().equals(e.getCicistas().get(j).getNombre())){

                            cont2 ++;

                        }

                    }

                    if(cont2 == 0){

                        equipos.get(i).getCicistas().add(e.getCicistas().get(j));

                    }

                }

                contador++;

            }

        }

        if(contador == 0){

            equipos.add(e);

        }

    }

    public static void crearTour(ArrayList<Equipo> e, String nombre){



    }

}
