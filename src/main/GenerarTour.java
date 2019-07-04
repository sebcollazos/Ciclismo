package main;
import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;
import logic.tour.Etapa;
import logic.tour.Tour;
import java.io.*;
import java.util.ArrayList;


public class GenerarTour {


    public GenerarTour(){

    }


    public Tour iniciarCrearTour() {
        System.out.println("Bienvenido al sistema de registro");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre del tour: ");
        String nombreTour = null;
        try {
            nombreTour = br.readLine();

        } catch (IOException e) {
            //e.printStackTrace();
        }
        Tour evento = new Tour();
        evento.setNombre(nombreTour);
        Boolean salir = Boolean.FALSE;
        int cantidadCiclistas = 0;
        while (salir.equals(false)) {
            try {

                System.out.println("Digite la cantidad de paticipantes de "+nombreTour);
                String cantidadCiclistastmp = br.readLine();
                cantidadCiclistas = Integer.parseInt(cantidadCiclistastmp);
                if(cantidadCiclistas > 0){
                    salir = Boolean.TRUE;
                }
                else {
                    System.out.println("Dato no valido");
                }
            }
            catch (IOException | NumberFormatException e) {
                System.out.println("No valido");
            }
        }
        ArrayList<Ciclista>  ciclistas = new ArrayList<>();
        ciclistas = registrarCiclistas(br, cantidadCiclistas);
        ArrayList<Equipo> equipos = new ArrayList<>();
        evento = registrarTour(br, ciclistas, evento);
        int cantidadEtapas = generarEtapas(br);
        evento = llenarEtapas(br, evento, cantidadEtapas, ciclistas);
        try {
            br.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return evento;
    }



    public ArrayList<Ciclista> registrarCiclistas(BufferedReader br, int cantidadCiclistas) {

        System.out.println("Registro de participantes: ");
        ArrayList<Ciclista>  ciclistas = new ArrayList<>();
        for(int i = 0; i < cantidadCiclistas; i++){
            Boolean salir = Boolean.FALSE;
            //nombre, nacionalidad, edad, peso, estatura
            while (salir.equals(false)){
                try{
                    int n = i + 1;
                    System.out.println("Digite el nombre del ciclista " + n +":" );
                    String nombretmp = br.readLine();
                    System.out.println("Digite la nacionalidad del ciclista " + n +":" );
                    String nacionalidadtmp = br.readLine();
                    System.out.print("Digite la edad del ciclista " + n +":" );
                    String stredadtmp = br.readLine();
                    int edadtmp = Integer.parseInt(stredadtmp);
                    System.out.print("Digite el peso del ciclista " + n +":" );
                    String strpesotmp = br.readLine();
                    Double pesotmp = Double.parseDouble(stredadtmp);
                    System.out.print("Digite la estatura del ciclista " + n +":" );
                    String strestaturatmp = br.readLine();
                    Double estaturatmp = Double.parseDouble(stredadtmp);
                    if ((edadtmp > 0) && (pesotmp > 0.0) && (estaturatmp > 0.0)){
                        if (i == 0){
                            Ciclista tmp = new Ciclista(nombretmp, nacionalidadtmp, edadtmp, pesotmp, estaturatmp);
                            ciclistas.add(tmp);
                            salir = Boolean.TRUE;
                        }
                        else{
                            Boolean registrado = Boolean.FALSE;
                            int a = 0;
                            while(a < ciclistas.size() && registrado.equals(false)){
                                String nombre = ciclistas.get(a).getNombre();
                                if (nombre.equals(nombretmp)){
                                    System.out.println("Ciclista ya registrado");
                                    registrado = Boolean.TRUE;
                                }
                                a = a + 1;
                            }
                            if (registrado.equals(false)){
                                Ciclista tmp = new Ciclista(nombretmp, nacionalidadtmp, edadtmp, pesotmp, estaturatmp);
                                ciclistas.add(tmp);
                                salir = Boolean.TRUE;
                            }
                        }
                    }
                    else {
                        System.out.println("Algun dato no valido\n");
                    }
                }
                catch (IOException | NumberFormatException e){
                    System.out.println("Dato no valido\n");
                }
            }
        }
        return ciclistas;
    }



    public Tour registrarTour(BufferedReader br, ArrayList<Ciclista> ciclistas, Tour evento) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        System.out.println("Registro de equipos: ");
        for (int i = 0; i < ciclistas.size(); i++){
            Boolean salir = Boolean.FALSE;
            while (salir.equals(false)){
                Ciclista ciclistatmp = ciclistas.get(i);
                String nombre = ciclistatmp.getNombre();
                System.out.println("A que equipo pertenece el ciclista "+ nombre + ":");
                String nombretmp = null;
                try {
                    nombretmp = br.readLine();
                }
                catch (IOException e) {
                    //e.printStackTrace();
                }
                Equipo tmp = new Equipo();
                tmp.setNombre(nombretmp);
                tmp.addCiclista(ciclistatmp);
                Boolean agregado;
                agregado = evento.addEquipo(tmp);
                if (agregado.equals(true)){
                    System.out.println("El equipo no existe, desea registrarlo [1]Si [2]No");
                    String op;
                    try {
                        op = br.readLine();
                        Boolean salir2 = Boolean.FALSE;
                        while (salir2.equals(false)){
                            switch (op){
                                case "1":
                                    System.out.println("El equipo "+ nombretmp +" fue creado");
                                    salir = Boolean.TRUE;
                                    salir2 = Boolean.TRUE;
                                break;
                                case "2":
                                    evento.removeEquipo(nombretmp);
                                    System.out.println("Digite bien los datos");
                                    salir2 = Boolean.TRUE;
                                break;
                                default:
                                    System.out.println("Opcion no valida");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
                else {
                    for (int j = 0; j < evento.getEquipos().size(); j++){
                        if (evento.getEquipos().get(j).getNombre().equals(nombretmp)){
                            evento.getEquipos().get(j).addCiclista(ciclistatmp);
                            salir = Boolean.TRUE;
                        }
                    }
                }
            }
        }
        return evento;
    }



    public int generarEtapas(BufferedReader br){
        Boolean salir = Boolean.FALSE;
        int cantidadEtapas = 0;
        while (salir.equals(false)){
            try {
                System.out.println("Digite la cantidad de etapas del tour");
                String cantidadEtapastmp = br.readLine();
                cantidadEtapas = Integer.parseInt(cantidadEtapastmp);
                if(cantidadEtapas > 0){
                    salir = Boolean.TRUE;
                }
                else{
                    System.out.println("Cantidad no valida");
                }
            } catch (IOException | NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Dato no valido");
            }
        }
        return cantidadEtapas;
    }



    public Tour llenarEtapas(BufferedReader br, Tour evento, int cantidadEtapas, ArrayList<Ciclista> ciclistas){
        for (int i = 0; i < cantidadEtapas; i++) {
            Boolean salir = Boolean.FALSE;
            while (salir.equals(false)) {
                try {
                    int n = i + 1;
                    System.out.println("Digite la altura inicial de la etapa " + n + ":");
                    String alturaInicialtmp = br.readLine();
                    Double alturaInicial = Double.parseDouble(alturaInicialtmp);
                    System.out.println("Digite la altura final de la etapa " + n +":");
                    String alturaFinaltmp = br.readLine();
                    Double alturaFinal = Double.parseDouble(alturaFinaltmp);
                    System.out.println("Digite los kilometros a recorrer en la etapa "+ n +":");
                    String kilometrostmp = br.readLine();
                    Double kilometros = Double.parseDouble(kilometrostmp);
                    Etapa tmp = new Etapa(alturaInicial, alturaFinal, kilometros, ciclistas);
                    Boolean agregar = evento.addEtapa(tmp);
                    if (agregar.equals(true)){
                        salir = Boolean.TRUE;
                    }
                    else{
                        System.out.println("Alguno de los datos no es valido");
                    }
                } catch (IOException | NumberFormatException e) {
                    //e.printStackTrace();
                    System.out.println("Dato no valido");
                }
            }
        }
        return evento;
    }
}
