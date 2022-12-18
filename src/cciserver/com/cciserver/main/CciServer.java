package cciserver.com.cciserver.main;

import cciserver.com.cciserver.util.AbrirFileChooser;
import java.io.IOException;

/**
 *
 * @author joseluiz
 */
public class CciServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        new AbrirFileChooser().carregar();
    }

}
