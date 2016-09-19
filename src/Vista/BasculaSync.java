/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controller;
import java.io.IOException;

/**
 *
 * @author Alex
 */
public class BasculaSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        
//        Controller c=new Controller("./Archivos/",4000);
//        c.BuscarArchivo();
        (new Controller("./Archivos/",4000)).start();
                
    }
    
}
