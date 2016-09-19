/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class CrearXML 
{
    
    public static void crear(String nombre,String xml)
    {
        CrearXML(nombre,xml);
    }
    private static void CrearXML(String nombre,String xml)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./XML/" + nombre + ".xml");
            pw = new PrintWriter(fichero);
            pw.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    
}