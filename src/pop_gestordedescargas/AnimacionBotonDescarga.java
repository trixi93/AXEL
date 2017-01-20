/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_gestordedescargas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author strike
 */
public class AnimacionBotonDescarga implements Runnable {

    private int posicionAnim = 1;
    private final JButton bDescargar;
    private boolean descargando = true;
    private final Thread hilo;

    public AnimacionBotonDescarga(JButton bDescargar) {
        this.bDescargar = bDescargar;
        hilo = new Thread(this);
        hilo.start();
    }
    

    
    
    public void terminarAnimacion(){
        descargando = false;
    }

    @Override
    public void run() {
        while (descargando) {
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimacionBotonDescarga.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (posicionAnim) {
                case 1:
                    bDescargar.setText("Descargando.");
                    break;
                case 2:
                    bDescargar.setText("Descargando..");
                    break;
                case 3:
                    bDescargar.setText("Descargando...");
                    break;
                case 4:
                    bDescargar.setText("Descargando....");
                    break;
            }
            posicionAnim++;
            if (posicionAnim == 5) {
                posicionAnim = 1;
            }
        }
        bDescargar.setText("Descargar");
    }

}
