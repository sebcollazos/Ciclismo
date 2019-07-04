package main;

import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;
import logic.tablaspuntuaciones.Tabla;
import logic.tour.Etapa;
import logic.tour.Tour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File directorio= null;
        File archivo = null;
        File etapa= null;
        FileReader fr = null;
        BufferedReader br = null;



        ArrayList<Tour> tours= new ArrayList<>();

        ArrayList<Equipo> equipos= new ArrayList<>();

        ArrayList<Etapa> etapas = new ArrayList<>();


        directorio= new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia");

        String nombreTour= directorio.getName();


        leerParticipantes(archivo, fr, br, equipos);

        leerEtapas(etapa, fr, br, etapas);

    }

    public static void leerParticipantes(File archivo, FileReader fr, BufferedReader br, ArrayList<Equipo> equipos){

        try {

            archivo = new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia\\participantes.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);





            // Lectura del fichero participantes
            String linea;




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

        }catch(Exception e){
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

    public static void leerEtapas(File etapas, FileReader fr, BufferedReader br, ArrayList<Etapa> e){

        try{

            Boolean salir= false;

            int i= 1;


            while(salir.equals(false)){

                String nombre= "etapa ";

                String linea;

                String direccionEtapa= "C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia\\"+nombre+i+".txt";

                etapas = new File (direccionEtapa);
                fr = new FileReader (etapas);
                br = new BufferedReader(fr);



                String etapaPrueba= etapas.getName();

                System.out.println(etapaPrueba);

                while( (linea= br.readLine()) != null){

                    String[] parrafo= null;

                    parrafo = linea.split("/");

                    Etapa etapa= null;

                    etapa= crearEtapa(parrafo, etapa);

                    System.out.println(etapa.getAlturaInicial()+" "+etapa.getAlturaFinal()+" "+etapa.getKilometros());

                }

                i++;

                if(etapas.length() == 0){

                    salir= Boolean.TRUE;

                }

            }

        }catch(Exception e){
            //e.printStackTrace();
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

    public static Etapa crearEtapa( String[] p, Etapa etapa){

        if(p.length == 3){

            Double alturaInicial= Double.parseDouble(p[0]);
            Double alturaFinal=Double.parseDouble(p[1]);
            Double Kilometros= Double.parseDouble(p[2]);

            ArrayList<Ciclista> lista= new ArrayList<>();

            etapa= new Etapa(alturaInicial, alturaFinal, Kilometros, lista);

        }

        return etapa;

    }

    public static void agregarEtapas(Etapa etapa, ArrayList<Etapa> e){


    }

}
