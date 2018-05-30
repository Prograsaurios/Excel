/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Datos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Descarga archivo excel
 */
public class Descarga {
    private String url;
    private String folder;
    private String name;
    private File dir;

    /**
     * Constructor de la clase Descarga
     * @throws IOException
     */
    public Descarga() throws IOException {
        this.url = "https://www.sernac.cl/wp-content/themes/gobCL-sitios-1.0/sip/apiSIP.php?mercado=medicamentos&tipo=10";
        this.folder = "descargas/";
        this.name = "medicamentos.xls";
        this.dir = new File(folder);
        crearCarpeta();
        descargar();
    }

    /**
     * Crea carpeta si no existe
     */
    public void crearCarpeta(){
            if (!dir.exists()) {
            if (!dir.mkdir()) {
                return; // no se pudo crear la carpeta de destino
            }
        }}

    /**
     * Descarga archivo de la página del SIP
     * @throws MalformedURLException
     * @throws IOException
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public void descargar() throws MalformedURLException, IOException {
        File file = new File(folder + name);
        URLConnection conn = new URL(url).openConnection();
        conn.connect();
        System.out.println("\nempezando descarga: \n");
        InputStream in = conn.getInputStream();
        OutputStream out = new FileOutputStream(file);
        int b = 0;
        while (b != -1) {
            b = in.read();
            if (b != -1) {
                out.write(b);
            }
        }
        out.close();
        in.close();

    }
}
