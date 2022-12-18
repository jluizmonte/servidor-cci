package cciserver.com.cciserver.util;

import cciserver.com.cciserver.view.Principal;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author joseluiz
 */
public class AbrirFileChooser {

    public void carregar() throws IOException {
        Principal principal = new Principal();
        //   File f = new File("\\\\servidor2\\servidor2");
        File f = new File("");
        FileSystemView fsv = FileSystemView.getFileSystemView();
        f = fsv.getParentDirectory(f);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(f);
        int result = fileChooser.showOpenDialog(principal);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileChooser.getSelectedFile().setExecutable(true);
            Desktop.getDesktop().open(selectedFile);
            System.exit(0);
        } else {
            System.exit(0);
        }
    }
}
