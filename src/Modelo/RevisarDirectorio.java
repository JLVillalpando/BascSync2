package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RevisarDirectorio {

    public String revisar(String ruta, String directorioBKP) throws IOException {

        File directorio = new File(ruta);
        String[] lista = null;
        lista = directorio.list();
        if (directorio.exists()) {
            if (lista.length >= 1) {
                return revisando(lista,ruta,directorioBKP);
            } else {
                return null;
            }
        } else {
            //JOptionPane.showInternalInputDialog(parentComponent, "");
            return "dir";
        }

    }

    private String revisando(String[] arch, String directorio, String directorioBKP) throws IOException {
        String linea = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(directorio+"/"+ arch[0]);
            //Hacemos el respaldo del archivo
            Backup b=new Backup();
            b.CrearBakcup(archivo,arch[0],directorioBKP);
            //
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
