package main;
import logic.ciclistas.Ciclista;
import logic.ciclistas.Equipo;

import java.io.*;
import java.util.ArrayList;


public class RegistrarDatos {



    private String organizador;
    private int cantidadCiclistas;
    private ArrayList<Ciclista> participantes;
    private ArrayList<Equipo> equipos;



    public RegistrarDatos() {
        participantes = new ArrayList<>();
        equipos = new ArrayList<>();
    }



    public String getOrganizador() {
        return organizador;
    }
    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
    public int getCantidadCiclistas() {
        return cantidadCiclistas;
    }
    public void setCantidadCiclistas(int cantidadCiclistas) {
        this.cantidadCiclistas = cantidadCiclistas;
    }
    public ArrayList<Ciclista> getParticipantes() {
        return participantes;
    }
    public void setParticipantes(ArrayList<Ciclista> participantes) {
        this.participantes = participantes;
    }
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }



    public void crearTour() {

        System.out.println("Bienvenido al sistema de registro");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nombre del organizador del tour: ");
        this.setOrganizador(br.readLine());
        System.out.println("Nombre del tour: ");
        String nombreTour = br.readLine();

        Boolean salir = false;

        while (salir.equals(false)) {
            try {

                System.out.println("Digite la cantidad de paticipantes de "+nombreTour);
                String cantidadCiclistastmp = br.readLine();
                setCantidadCiclistas(Integer.parseInt(cantidadCiclistastmp));
                if(this.cantidadCiclistas > 0){
                    salir = true;
                }
                else {
                    System.out.println("Dato no valido");
                }

            }
            catch (IOException | NumberFormatException e) {

                System.out.println("No valido");

            }
        }
        registrarCiclistas();
    }



    public void registrarCiclistas() {

        System.out.println("Registro de participantes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < this.getCantidadCiclistas(); i++){

            Boolean salir = false;

            //nombre, nacionalidad, edad, peso, estatura
            while (salir.equals(false)){
                try{
                    System.out.println("Digite el nombre del ciclista " + i +":" );
                    String nombretmp = br.readLine();
                    System.out.println("Digite la nacionalidad del ciclista " + i +":" );
                    String nacionalidadtmp = br.readLine();
                    System.out.print("Digite la edad del ciclista " + i +":" );
                    String stredadtmp = br.readLine();
                    int edadtmp = Integer.parseInt(stredadtmp);
                    System.out.print("Digite el peso del ciclista " + i +":" );
                    String strpesotmp = br.readLine();
                    Double pesotmp = Double.parseDouble(stredadtmp);
                    System.out.print("Digite la estatura del ciclista " + i +":" );
                    String strestaturatmp = br.readLine();
                    Double estaturatmp = Double.parseDouble(stredadtmp);
                    if ((edadtmp > 0) && (pesotmp > 0.0) && (estaturatmp > 0.0)){
                        if (i == 0){
                            Ciclista tmp = new Ciclista(nombretmp, nacionalidadtmp, edadtmp, pesotmp, estaturatmp);
                            this.participantes.add(tmp);
                            salir = true;
                        }
                        else{
                            Boolean registrado = false;
                            int a = 0;
                            while(a < this.participantes.size() && registrado.equals(false)){
                                String nombre = this.participantes.get(a).getNombre();
                                if (nombre.equals(nombretmp)){
                                    System.out.println("Ciclista ya registrado");
                                    registrado = true;
                                }
                                a = a + 1;
                            }
                            if (registrado.equals(false)){
                                Ciclista tmp = new Ciclista(nombretmp, nacionalidadtmp, edadtmp, pesotmp, estaturatmp);
                                this.participantes.add(tmp);
                                salir = true;
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
        registrarEquipos();
    }



    public void registrarEquipos(){

        System.out.println("Registro de participantes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < this.participantes.size(); i++){

            Boolean salir = false;
            while (salir.equals(false)){
                Ciclista ciclistatmp = this.getParticipantes().get(i);
                String nombre = ciclistatmp.getNombre();
                System.out.println("A que equipo pertenece el ciclista "+ nombre + ":");
                String nombretmp = br.readLine();
                if (i == 0){
                    Equipo equipotmp = new Equipo();
                    equipotmp.setNombre(nombretmp);
                    equipotmp.addCiclista(ciclistatmp);
                    this.equipos.add(equipotmp);
                    salir = true;
                }
                else{
                    Boolean existente = false;
                    int a = 0;
                    while (a < this.equipos.size() && existente.equals(false)){
                        if (this.getEquipos().get(a).getNombre().equals(nombretmp)){
                            this.equipos.get(a).addCiclista(ciclistatmp);
                            existente = true;
                            salir = true;
                        }
                        a = a + 1;
                    }
                    if (existente.equals(false)){
                        System.out.println("El equipo no existe, desea registrarlo [1]Si [2]No :");
                        try {
                            String optmp = br.readLine();
                            int op = Integer.parseInt(optmp);
                            switch (op){
                                case 1:
                                    Equipo equipotmp = new Equipo();
                                    equipotmp.setNombre(nombretmp);
                                    equipotmp.addCiclista(ciclistatmp);
                                    this.equipos.add(equipotmp);
                                    salir = true;
                                break;

                                case 2:
                                    System.out.println("Digite bien el nombre");
                                break;

                                default:
                                    System.out.println("Opcion no valida, escriba nuevamente los datos");
                                break;
                            }
                        }
                        catch (IOException | NumberFormatException e) {
                            System.out.println("Opcion no valida");
                        }
                    }
                }
            }
        }
    }
}
