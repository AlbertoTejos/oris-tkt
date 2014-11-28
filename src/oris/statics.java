/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oris;

import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import oris.directorio.Directorio;

/**
 *
 * @author Felipe
 */
public class statics {

    public static String getFecha() {
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String annio = Integer.toString(c1.get(Calendar.YEAR));
        return annio.substring(2) + dia + mes;
    }

    public static String definirDirectorio(JFrame frame) {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = file.showOpenDialog(frame);

        switch (result) {
            case JFileChooser.CANCEL_OPTION:
                return "";

            case JFileChooser.APPROVE_OPTION:
                return file.getSelectedFile().getAbsolutePath();

            case JFileChooser.ERROR_OPTION:
                return "";
        }
        return "";
    }
}
