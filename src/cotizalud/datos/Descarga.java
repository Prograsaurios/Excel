/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.datos;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
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
     * Realiza la descarga desde la base de datos del Sernac
     */
    public boolean descargar() throws MalformedURLException, IOException {
       try{
        FileUtils.copyURLToFile(url, dir);
        
    }catch(Exception e){
           JOptionPane.showMessageDialog(null, "La pagina web esta caída, intente más tarde");
        return false;
    }
       return true;
    }

}
