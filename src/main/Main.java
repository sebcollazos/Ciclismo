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

            ArrayList<Ciclista> ciclistas= new ArrayList<>();

            while((linea=br.readLine())!=null ) {

                String[] parrafo = linea.split(" ");

                Ciclista c= null;

                //Equipo e= null;

                c= crearCiclisita(parrafo, c);


                agregarCiclista(c, ciclistas);



                System.out.println(c.getNombre()+" "+c.getNacionalidad());

            }

            if(ciclistas != null){

                for(int i=0; i< ciclistas.size(); i++){

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

    public static Equipo crearEquipo(String[] parrafo, Equipo E){

        if(parrafo.length >= 3 && parrafo.length <= 4){



        }


        return null;
    }
}
