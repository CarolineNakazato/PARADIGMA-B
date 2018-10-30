/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatest;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.io.*;
/**
 *
 * @author PC
 */
public class ImprimirFrame extends JFrame{
    private JLabel lbInformacao;
    private JButton btnProx;
    private JButton btnAnt;
    private int i;
    public ImprimirFrame(){
        super("Conta Bancaria");
        setLayout(null);
        
        i = 0;
        
        lbInformacao = new JLabel("Informacao");
        lbInformacao.setToolTipText("informacao da conta.");
        add(lbInformacao);
        
        lbInformacao.setBounds(10, 50, 150, 150);
          
        btnProx = new JButton(">");
        add(btnProx);
                       
        Dimension sizeBtnLogin = btnProx.getPreferredSize();
        btnProx.setBounds(60, 10, sizeBtnLogin.width, sizeBtnLogin.height);
        
        btnAnt = new JButton("<");
        add(btnAnt);
                       
        Dimension sizeBtnAnt = btnAnt.getPreferredSize();
        btnAnt.setBounds(10, 10, sizeBtnAnt.width, sizeBtnAnt.height);
        
        
        ButtonHandler handler = new ButtonHandler();
        btnProx.addActionListener(handler);
        btnAnt.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{
        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource() == btnProx){
                i++;
            }
            else if(e.getSource() == btnAnt){
                i--;
            }
           ContaFacade cf = ContaFacade.getInstance();
           lbInformacao.setText(cf.informacoes(i));
        }
    }
}