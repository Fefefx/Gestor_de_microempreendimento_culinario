/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import Control.encomendaControl;
import UI.visualizarEncomendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class notificacao {

    public static void main(String[] args) throws AWTException, MalformedURLException {
        if (SystemTray.isSupported()) {
            notificacao not = new notificacao();
            not.displayTray("João");
        } else {
            System.err.println("Recurso System tray não supotado!");
        }
    }

    public void displayTray(String user) throws AWTException, MalformedURLException {
        String location;
        //Realiza uma instância do objeto SystemTray
        SystemTray tray = SystemTray.getSystemTray();
        //Se o icone é um arquivo
        Image image = Toolkit.getDefaultToolkit().createImage("icon-gastronomia.png");
        //Alternativo(Caso o icone seja uma classe):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Se necessário redimensiona a imagem do sistema
        trayIcon.setImageAutoSize(true);
        trayIcon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Você clicou");
            }
            
        });
        //Coloca texto no icone da barra de tarefas
        trayIcon.setToolTip("GMEC executando");
        int valor = new encomendaControl().qtdEncomendas();
        if (valor == 0) {
            System.out.println("Nenhuma encomenda encontrada");
        } else {
            tray.add(trayIcon);
            if(valor==1)
                trayIcon.displayMessage("Bem vindo "+user, "Você possui "+valor+" encomenda", MessageType.INFO);
            else
               trayIcon.displayMessage("Bem vindo "+user, "Você possui "+valor+" encomendas", MessageType.INFO); 
        }
    }

}
