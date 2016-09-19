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
public class Functions {

    private static volatile int MY_INT = 0;

    static class getXML extends Thread {

        private String C01;
        private String C02;
        //private String C03;
        private String C04;
        private String THora;
        private String TFecha;
        private String TReferencia;

        public getXML(String C01, String C02, String C04, String THora, String TFecha, String TReferencia) {
            this.C01 = C01;
            this.C02 = C02;
            //this.C03 = C03;
            this.C04 = C04;
            this.THora = THora;
            this.TFecha = TFecha;
            this.TReferencia = TReferencia;
        }

        @Override
        public void run() {
            try {
                Utils.PropertiesLoader settings = new Utils.PropertiesLoader("app.config.properties");
                String stringXML = "<IDOC>\n"
                        + "<RC Archivo=\"" + settings.get("Centro") + Utils.padL(String.valueOf(MY_INT), 12, '0') + "_" + settings.get("Canal") + "_" + TFecha + "_" + THora + "\" Canal=\"" + settings.get("Canal") + "\" Centro=\"" + settings.get("Centro") + "\" Destinatario=\"" + settings.get("Destinatario") + "\" Fecha=\"" + TFecha + "\" Hora=\"" + THora + "\" Mandante=\"" + settings.get("Mandante") + "\" Release=\"" + settings.get("Release") + "\" Remitente=\"" + settings.get("Remitente") + "\" TBase=\"" + settings.get("TBase") + "\" TMensaje=\"" + settings.get("TMensaje") + "\" />\n"
                        + "<RD>\n"
                        + "<Transaccion TOrganizacion=\"" + settings.get("TOrganizacion") + "\" TCentro=\"" + settings.get("Centro") + "\" TAlmacen=\"" + settings.get("Almacen") + "\" TReferencia=\"" + TReferencia + "\" TFecha=\"" + TFecha + "\" THora=\"" + THora + "\">\n"
                        + "<Detalle C01=\"" + C01 + "\" C02=\"" + C02 + "\" C03=\"" + settings.get("C03") + "\" C04=\"" + C04 + "\" />\n"
                        + "</Transaccion>\n"
                        + "</RD>\n"
                        + "</IDOC>";
                
                System.out.println(stringXML);
                MY_INT++;
            } catch (Exception e) {

            }
        }
    }
}
