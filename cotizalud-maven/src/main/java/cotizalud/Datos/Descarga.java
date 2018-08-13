/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Datos;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * Descarga archivo excel
 */
public class Descarga {

    private URL url;
    private String file;
    private File dir;

    /**
     * Constructor de la clase Descarga
     *
     * @throws IOException
     */
    public Descarga() throws IOException {
        this.url = new URL("https://www.sernac.cl/wp-content/themes/gobCL-sitios-1.0/sip/apiSIP.php?mercado=medicamentos&tipo=10");
        this.file = "descargas/medicamentos.html";
        this.dir = new File(file);
        descargar();
    }

    /**
     * Descarga archivo de la página del SIP
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    private void descargar() throws MalformedURLException, IOException {
        FileUtils.copyURLToFile(url, dir);
    }

}
