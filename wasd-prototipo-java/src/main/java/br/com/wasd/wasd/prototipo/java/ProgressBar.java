/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author elize
 */
public class ProgressBar extends Thread {

    private JDialog dialog = null;

    @Override
    public void run() {
        super.run();                
        JProgressBar bar = new JProgressBar();
        bar.setBackground(Color.black);
        bar.setForeground(Color.blue);
        bar.setIndeterminate(true);
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setSize(new Dimension(250, 40));
        dialog.setLocationRelativeTo(null);
        dialog.setUndecorated(true);
        dialog.add(bar);
        dialog.setVisible(true);
    }

    public void iniciaBar() {
        start();
    }

    public void paraBar() {
        dialog.setVisible(false);
        dialog.dispose();
    }
}
//admin@gmail.com
