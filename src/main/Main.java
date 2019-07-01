package main;

import logic.ciclistas.Ciclista;

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





            while((linea=br.readLine())!=null ) {

                String[] ciclista = linea.split(" ");

                Ciclista c= new Ciclista("np", "np", 0);

                if(ciclista.length >= 6){

                    String nombre= ciclista[0]+" "+ciclista[1];

                    String nacionalidad= ciclista[2];

                    int edad= Integer.parseInt(ciclista[3]) ;

                    Double peso= Double.parseDouble(ciclista[4]);

                    Double estatura= Double.parseDouble(ciclista[5]);

                    c = new Ciclista(nombre, nacionalidad, edad, peso, estatura);

                }

                System.out.println(c.getNombre()+" "+c.getNacionalidad());

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

    public static Ciclista (String[] ciclista, Ciclista c){

        return

    }
}
