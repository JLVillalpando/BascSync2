package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Backup 
{
    public void CrearBakcup(File origen,String nombre) throws FileNotFoundException, IOException
    {
        Backup(origen,nombre);
    }
    private void Backup(File Origen, String nombre) throws FileNotFoundException, IOException
    {
        try
        {
            File destino = new File("./bkp/"+nombre);
            InputStream in = new FileInputStream(Origen);
            OutputStream out = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) 
            {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        }
        catch(Exception NoBkp)
        {
            System.err.println("No se pudo crear el respaldo");
        }
        
        
    }
    
}
