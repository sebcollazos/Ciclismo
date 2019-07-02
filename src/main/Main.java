package main;

import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour\\texo.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            String[] parrafo= null;

            ArrayList<Equipo> equipos= new ArrayList<>();

            ArrayList<Ciclista> ciclistas= new ArrayList<>();

            Equipo e= null;


            while((linea=br.readLine())!=null ) {

                parrafo = linea.split(" ");

                Ciclista c= null;



                c= crearCiclisita(parrafo, c);

                if(parrafo.length >= 7){

                    agregarCiclista(c, ciclistas);

                }

                e= new Equipo();

                crearequipo(e, parrafo, ciclistas);

                agregarEquipo(e, equipos);

            }

            if(equipos != null){

                for(int i=0; i< equipos.get(0).getCicistas().size(); i++){

                    System.out.println(e.getNombre());

                    System.out.println(e.getCicistas().get(i).getNombre()+" "+e.getCicistas().get(i).getNacionalidad());

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

        if(ciclista.length >= 7){

            String nombre= ciclista[1]+ " " +ciclista[2];

            String nacionalidad= ciclista[3];

            int edad= Integer.parseInt(ciclista[4]) ;

            Double peso= Double.parseDouble(ciclista[5]);

            Double estatura= Double.parseDouble(ciclista[6]);

            c = new Ciclista(nombre, nacionalidad, edad, peso, estatura);

        }

        return c;

    }

    public static void agregarCiclista(Ciclista c, ArrayList<Ciclista> ciclistas){

        int contador= 0;

        for(int i= 0; i < ciclistas.size(); i++){

            if(ciclistas.get(i).getNombre().equals(c.getNombre()) && c!= null){

                contador++;

            }

        }

        if(contador == 0){

            ciclistas.add(c);

        }

    }

    public static void crearequipo(Equipo e, String[] p, ArrayList<Ciclista> c){

        e.setNombre(p[0]);

        e.setCicistas(c);

    }

    public static void agregarEquipo(Equipo e, ArrayList<Equipo> equipos){

        int contador= 0;

        for(int i= 0; i < equipos.size(); i++){

            if(equipos.get(i).getNombre().equals(e.getNombre()) && e != null){

                contador++;

            }
            else{

                equipos.add(e);

            }

        }



    }

}
