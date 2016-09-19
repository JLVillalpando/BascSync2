/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Villa
 */
public class Utils {

    public static class PropertiesLoader {

        Properties prop = new Properties();

        public PropertiesLoader(String file) throws FileNotFoundException {
            FileInputStream f = new FileInputStream(file);
            try {
                prop.load(f);
                f.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public void set(String file,String key, String value) throws FileNotFoundException, IOException {
            FileOutputStream out = new FileOutputStream(file);
            prop.setProperty(key, value);
            prop.store(out, null);
            out.close();
        }

        public String get(String key) {
            return prop.getProperty(key);
        }

        public boolean exists(String key) {
            return prop.getProperty(key) != null;
        }
    }

    public static String padL(String str, int size, char padChar) {
        //System.out.println("STR:" + str);
        StringBuilder padded = new StringBuilder(str);
        padded.reverse();
        //padded.append(str);
        while (padded.length() < size) {
            padded.append(padChar);
        }
        return padded.reverse().toString();
    }

}
