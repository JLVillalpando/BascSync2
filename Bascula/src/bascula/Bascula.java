/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bascula;

import Funciones.Func2;

/**
 *
 * @author Villa
 */
public class Bascula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = Func2.getXML("C:\\Users\\Villa\\Documents\\NetBeansProjects\\Bascula\\app.config.properties", "2", "0.125", "13.75", "101458", "20160726", "01");
        System.out.println(s);            
    }
    
}
