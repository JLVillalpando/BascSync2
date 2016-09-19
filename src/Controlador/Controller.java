package Controlador;

import Modelo.Func2;
import Modelo.RevisarDirectorio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controller extends Thread {

    private String directorio;
    private int tiempo;

    public Controller(String dir, int tie) {
        directorio = dir;
        tiempo = tie;

    }

    @Override
    public void run() {
        try {
            BuscarArchivo();
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void BuscarArchivo() throws InterruptedException, IOException {
        try {

            while (!Thread.currentThread().isInterrupted()) {
                RevisarDirectorio RD = new RevisarDirectorio();
                String info = RD.revisar(directorio);
                if (info != null) {
                    if(info == "dir"){
                        JOptionPane.showInternalInputDialog(null, "irrr");
                    }else{
                        ObtenerDatos(info);
                    }
                }
                Thread.sleep(tiempo);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }

    }

    private void ObtenerDatos(String info) {
        String[] SeparacionDatos = info.split(";");
        String codigoPLU, Peso, Monto, Hora, Fecha, Referencia;
        codigoPLU = SeparacionDatos[1];
        Peso = SeparacionDatos[3];
        Monto = SeparacionDatos[4];
        Hora = SeparacionDatos[5].replace(":", "");
        Fecha = SeparacionDatos[8].replace("/", "");
        Referencia = SeparacionDatos[9];
        //directorio,C01,C02,C04,Hora,Fecha, Referencia
        Func2.getXML("./app.config.properties", codigoPLU, Peso, Monto, Hora, Fecha, Referencia);
    }

    public void kill() {
        interrupt();
    }

}
