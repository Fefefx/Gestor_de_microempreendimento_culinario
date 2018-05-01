/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

/**
 *
 * @author felipe
 */
public class notificacao {

    public static void main(String[] args) throws AWTException, MalformedURLException {
        if (SystemTray.isSupported()) {
            notificacao not = new notificacao();
            not.displayTray();
        } else {
            System.err.println("Recurso System tray não supotado!");
        }
    }

    public void displayTray() throws AWTException, MalformedURLException {
        //Realiza uma instância do objeto SystemTray
        SystemTray tray = SystemTray.getSystemTray();
        //Se o icone é um arquivo
        Image image = Toolkit.getDefaultToolkit().createImage("icon-gastronomia.png");
        //Alternativo(Caso o icone seja uma classe):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Se necessário redimensiona a imagem do sistema
        trayIcon.setImageAutoSize(true);
        //Coloca texto no icone da barra de tarefas
        trayIcon.setToolTip("GMEC executando");
        tray.add(trayIcon);
        trayIcon.displayMessage("Bem vindo José", "Você possui 3 encomendas", MessageType.INFO);
    }
    
    public int buscarEncomendas(){
        data time = new data();
        
        return -1;
    }
    
}
