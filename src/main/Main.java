package main;

import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;
import logic.ciclistas.Registro;
import logic.tablaspuntuaciones.Tabla;
import logic.tiempo.Tiempo;
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

        ArrayList<Registro> tabla= new ArrayList<>();

        Tabla tablaDatos= new Tabla(tabla);


        directorio= new File ("C:\\Users\\Usuario\\Desktop\\Ciclismo-master\\Tour de francia");

        String nombreTour= directorio.getName();


        leerParticipantes(archivo, fr, br, equipos);

        tabla= crearTablaRegsitros(tabla, equipos);

        leerEtapas(etapa, fr, br, etapas, tablaDatos);

        for(int i=0; i< etapas.size(); i++){

            if(etapas.get(i) != null){

                System.out.println(etapas.get(i).getAlturaInicial()+" "+etapas.get(i).getAlturaFinal()+" "+etapas.get(i).getKilometros()+"\n");

            }

            for(int j=0; j< etapas.get(i).getLista().getTabla().size(); j++){

                System.out.println(etapas.get(i).getLista().getTabla().get(j).getCiclista().getNombre()+" "
                                    +etapas.get(i).getLista().getTabla().get(j).getTiempo().getHoras()+" "
                                    +etapas.get(i).getLista().getTabla().get(j).getTiempo().getMinutos()+" "
                                    +etapas.get(i).getLista().getTabla().get(j).getTiempo().getSegundos()+" "
                                    +etapas.get(i).getLista().getTabla().get(j).getPuntos()+"\n");

            }

        }

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

    public static void leerEtapas(File etapas, FileReader fr, BufferedReader br, ArrayList<Etapa> e, Tabla Lista){

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

                Etapa etapa= new Etapa();

                String etapaPrueba= etapas.getName();

                //System.out.println(etapaPrueba);

                while( (linea= br.readLine()) != null){

                    String[] parrafo= null;

                    parrafo = linea.split("/");

                    etapa= new Etapa();



                    if(parrafo.length == 3){

                        etapa= crearEtapa(parrafo, etapa);

                        e.add(etapa);

                    }

                    if(parrafo.length == 5){

                        Lista= llenarTabla(parrafo, Lista);

                        e.get(i-1).setLista(Lista);

                    }

                }



                i++;

                if(etapas.length() == 0){

                    salir= Boolean.TRUE;

                }

            }


        }catch(Exception a){
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

    public static Tabla llenarTabla(String[] p, Tabla tabla){

        if(p.length == 5){

            for(int j=0; j< tabla.getTabla().size(); j++){

                if(tabla.getTabla().get(j).getCiclista().getNombre().equals(p[0])){

                    Tiempo t= new Tiempo(Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]));

                    Double puntos= Double.parseDouble(p[4]);

                    tabla.getTabla().get(j).setTiempo(t);
                    tabla.getTabla().get(j).setPuntos(puntos);

                    return tabla;

                }

            }

        }

        return tabla;

    }

    public static ArrayList<Registro> crearTablaRegsitros(ArrayList<Registro> tabla, ArrayList<Equipo> equipos){

        for(int j=0; j< equipos.size(); j++){

            for(int k=0; k< equipos.get(j).getCicistas().size(); k++){

                Tiempo t= new Tiempo(0,0,0);

                Registro r= new Registro(equipos.get(j).getCicistas().get(k), t, 0.0);

                tabla.add(r);

            }

        }

        return tabla;

    }



}
