package Funciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Villa
 */
public class Func2 {

    //private static volatile int MY_INT = 0;
    public static String getXML(String path, String C01, String C02, String C04, String THora, String TFecha, String TReferencia) {
        try {
            Utils.PropertiesLoader settings = new Utils.PropertiesLoader(path);
            
            int contador = Integer.parseInt(settings.get("Consecutivo")) + 1;
            
            String stringXML = "<IDOC>\n"
                    + "<RC Archivo=\"" + settings.get("Centro") + Utils.padL(String.valueOf(contador), 12, '0') + "_" + settings.get("Canal") + "_" + TFecha + "_" + THora + "\" Canal=\"" + settings.get("Canal") + "\" Centro=\"" + settings.get("Centro") + "\" Destinatario=\"" + settings.get("Destinatario") + "\" Fecha=\"" + TFecha + "\" Hora=\"" + THora + "\" Mandante=\"" + settings.get("Mandante") + "\" Release=\"" + settings.get("Release") + "\" Remitente=\"" + settings.get("Remitente") + "\" TBase=\"" + settings.get("TBase") + "\" TMensaje=\"" + settings.get("TMensaje") + "\" />\n"
                    + "<RD>\n"
                    + "<Transaccion TOrganizacion=\"" + settings.get("TOrganizacion") + "\" TCentro=\"" + settings.get("Centro") + "\" TAlmacen=\"" + settings.get("TAlmacen") + "\" TReferencia=\"" + TReferencia + "\" TFecha=\"" + TFecha + "\" THora=\"" + THora + "\">\n"
                    + "<Detalle C01=\"" + C01 + "\" C02=\"" + C02 + "\" C03=\"" + settings.get("C03") + "\" C04=\"" + C04 + "\" />\n"
                    + "</Transaccion>\n"
                    + "</RD>\n"
                    + "</IDOC>";

            settings.set(path, "Consecutivo", String.valueOf(contador));
            
            return stringXML;
        } catch (Exception e) {
            return null;
        }
    }

}
