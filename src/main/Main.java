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

            ArrayList<Equipo> equipos= new ArrayList<>();

            ArrayList<Ciclista> ciclistas= new ArrayList<>();




            while((linea=br.readLine())!=null ) {

                String[] parrafo= null;

                parrafo = linea.split("/");

                Ciclista c= null;

                Equipo e= null;

                c= crearCiclisita(parrafo, c);

                if(parrafo.length >= 6){

                    agregarCiclista(c, ciclistas);

                }

                e= crearequipo(e, parrafo);

                agregarEquipo(e, equipos);

            }

            if(equipos != null){

                for(int i=0; i< equipos.size(); i++){

                    System.out.println(equipos.get(i).getNombre());

                }

            }

            if(ciclistas != null){

                for(int i= 0; i < ciclistas.size(); i++){

                    System.out.println(ciclistas.get(i).getNombre()+" "+ciclistas.get(i).getNacionalidad());

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

    public static Equipo crearequipo(Equipo e, String[] p){

        ArrayList<Ciclista> c = new ArrayList<>();

        Equipo equipo= new Equipo(c, p[0]);

        return equipo;

    }

    public static void agregarEquipo(Equipo e, ArrayList<Equipo> equipos){

        int contador= 0;

        for(int i= 0; i < equipos.size(); i++){

            if( ( equipos == null ) ){

                equipos.add(e);

            }else if( ( equipos.get(i).getNombre().equals(e.getNombre()) ) ){

                contador++;

            }



        }

        if(contador == 0){

            equipos.add(e);

        }

    }

}
