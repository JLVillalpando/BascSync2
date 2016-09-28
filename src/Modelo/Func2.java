package Modelo;

public class Func2 {

    //private static volatile int MY_INT = 0;
    public static boolean getXML(String path, String C01, String C02, String C04, String THora, String TFecha, String TReferencia) {
        try {
            Utils.PropertiesLoader settings = new Utils.PropertiesLoader(path);
            
            int contador = Integer.parseInt(settings.get("Consecutivo")) + 1;
            String name = settings.get("Centro") + Utils.padL(String.valueOf(contador), 12, '0') + "_" + settings.get("Canal") + "_" + TFecha + "_" + THora;
            
            String stringXML = "<IDOC>\n"
                    + "<RC Archivo=\"" + name  + "\" Canal=\"" + settings.get("Canal") + "\" Centro=\"" + settings.get("Centro") + "\" Destinatario=\"" + settings.get("Destinatario") + "\" Fecha=\"" + TFecha + "\" Hora=\"" + THora + "\" Mandante=\"" + settings.get("Mandante") + "\" Release=\"" + settings.get("Release") + "\" Remitente=\"" + settings.get("Remitente") + "\" TBase=\"" + settings.get("TBase") + "\" TMensaje=\"" + settings.get("TMensaje") + "\" />"
                    + "<RD>\n"
                    + "<Transaccion TOrganizacion=\"" + settings.get("TOrganizacion") + "\" TCentro=\"" + settings.get("Centro") + "\" TAlmacen=\"" + settings.get("TAlmacen") + "\" TReferencia=\"" + TReferencia + "\" TFecha=\"" + TFecha + "\" THora=\"" + THora + "\">\n"
                    + "<Detalle C01=\"" + C01 + "\" C02=\"" + C02 + "\" C03=\"" + settings.get("C03") + "\" C04=\"" + C04 + "\" />\n"
                    + "</Transaccion>\n"
                    + "</RD>\n"
                    + "</IDOC>";

            CrearXML.crear(name, stringXML);
            settings.set(path, "Consecutivo", String.valueOf(contador));
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
