package main;
import logic.ciclistas.Registro;
import logic.tiempo.Tiempo;
import logic.tour.Tour;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuardarDatos {



    public GuardarDatos(){

    }



    public Tour iniciarRegistroDatos(Tour evento){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cantidadEtapas = evento.getEtapas().size();
        int cantidadRegistros = evento.getEtapas().get(0).getLista().getTabla().size();
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
                        int horas = Integer.parseInt(horastmp);
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
                            r.setCiclista(evento.getGeneral().getTabla().get(i).getCiclista());
                            evento.getEtapas().get(i).getLista().addRegistro(r);
                            salir = Boolean.TRUE;
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
}
