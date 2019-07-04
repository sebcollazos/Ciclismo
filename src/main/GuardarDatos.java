package main;
import logic.ciclistas.Ciclista;
import logic.ciclistas.Registro;
import logic.tablaspuntuaciones.Tabla;
import logic.tiempo.Tiempo;
import logic.tour.Organizador;
import logic.tour.Tour;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class GuardarDatos {



    public GuardarDatos(){

    }



    public Tour iniciarRegistroDatos(Tour evento, BufferedReader br){
        int cantidadEtapas = evento.getEtapas().size();
        int cantidadRegistros = evento.getGeneral().getTabla().size();
        System.out.println("Iniciado sistema de registro registro de datos");
        for (int i = 0; i < cantidadEtapas; i++){
            int n = i + 1;
            System.out.println("Registrando datos de la etapa "+ n + ":");
            for (int j = 0; j < cantidadRegistros; j++){
                String nombre = evento.getGeneral().getTabla().get(i).getCiclista().getNombre();
                Boolean salir  = Boolean.FALSE;
                while (salir.equals(false)) {
                    try {
                        System.out.println("Digite las horas que le tomo llegar a " + nombre + " en la etapa " + n + ":");
                        String horastmp = br.readLine();
                        int horas;
                        horas = Integer.parseInt(horastmp);
                        System.out.println("Digite los minutos que le tomo llegar a " + nombre + " en la etapa " + n + ":");
                        String minutostmp = br.readLine();
                        int minutos = Integer.parseInt(minutostmp);
                        System.out.println("Digite los segundos que le tomo llegar a " + nombre + " en la etapa " + n + ":");
                        String segundostmp = br.readLine();
                        int segundos = Integer.parseInt(segundostmp);
                        if((horas > 0 ) && (minutos > 0 && minutos < 60) && (segundos > 0 && segundos < 60)) {
                            Tiempo t = new Tiempo();
                            t.setHoras(horas);
                            t.setMinutos(minutos);
                            t.setSegundos(segundos);
                            Registro r = new Registro();
                            r.setTiempo(t);
                            r.setPuntos(0.0);
                            r.setCiclista(evento.getGeneral().getTabla().get(i).getCiclista());
                            evento.getEtapas().get(i).getLista().addRegistro(r);
                            System.out.println("Desea modificar los datos? [1]Si [2]No");
                            String op = br.readLine();
                            Boolean salir2 = Boolean.FALSE;
                            while(salir2.equals(false)){
                                switch (op){
                                    case "1":
                                        salir2 = Boolean.TRUE;
                                    break;
                                    case "2":
                                        salir2 = Boolean.TRUE;
                                        salir = Boolean.TRUE;
                                    break;
                                    default:
                                        System.out.println("Opcion no valida");
                                    break;
                                }
                            }
                        }
                        else{
                            System.out.println("Digite valores validos");
                        }
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Dato no valido");
                        //e.printStackTrace();
                    }
                }
            }
        }
        return evento;
    }



    public void registrarPuntos(Tour evento){
        Organizador organizador = new Organizador();
        for (int i = 0; i < evento.getEtapas().size(); i++){
            ArrayList<Double> puntos = organizador.calcularPuntosMontania(evento.getEtapas().get(i));
            organizador.sumarPuntosEtapa(evento.getEtapas().get(i), puntos);
        }

    }



    public void crearFichero(Tour evento){
        FileWriter wr = null;
        String x = evento.getNombre();
        String d = "C:\\Users\\User\\Desktop\\Ciclismo\\"+x;
        File directorio = new File(d);
        directorio.mkdirs();
        for (int i = 0; i < evento.getEtapas().size(); i++){
            try {
                int n = i + 1;
                String q = d + "participantes.txt";
                wr = new FileWriter(q);
                BufferedWriter bfwrt = new BufferedWriter(wr);
                String equipo = null;
                for (int j = 0; j < evento.getGeneral().getTabla().size(); j++){
                    Ciclista c = evento.getGeneral().getTabla().get(j).getCiclista();
                    for (int k = 0; k < evento.getEquipos().size(); k++){
                        for (int l = 0; l < evento.getEquipos().get(k).getCicistas().size(); l++){
                            String nom = evento.getEquipos().get(k).getCicistas().get(l).getNombre();
                            if (c.getNombre().equals(nom)){
                                equipo = evento.getEquipos().get(k).getNombre();
                            }
                        }
                    }
                    bfwrt.write(equipo+"/"+c.getNombre()+"/"+c.getNacionalidad()+"/"
                            +c.getEdad()+"/"+c.getPeso()+"/"+c.getEstatura());
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
