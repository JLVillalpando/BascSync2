package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class RevisarDirectorio {

    public String revisar(String ruta) throws IOException {

        File directorio = new File(ruta);
        String[] lista = null;
        lista = directorio.list();
        if (directorio.exists()) {
            if (lista.length >= 1) {
                return revisando(lista);
            } else {
                return null;
            }
        } else {
            //JOptionPane.showInternalInputDialog(parentComponent, "");
            return "dir";
        }

    }

    private String revisando(String[] arch) throws IOException {
        String linea = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("./Archivos/" + arch[0]);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            linea = br.readLine();
            fr.close();
            archivo.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fr.close();

        }
        return linea;
    }

}
