/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Descarga archivo excel
 */
class Descarga {

    private URL url;
    private File dir;

    /**
     * Constructor de la clase Descarga
     *
     * @throws IOException
     */
    public Descarga() throws IOException {
        this.url = new URL("https://www.sernac.cl/wp-content/themes/gobCL-sitios-1.0/sip/apiSIP.php?mercado=medicamentos&tipo=10");
        String file = "descargas/medicamentos.html";
        this.dir = new File(file);
    }

    /**
     * Descarga archivo de la página del SIP
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void descargar() throws IOException {
        FileUtils.copyURLToFile(url, dir);
    }

}
