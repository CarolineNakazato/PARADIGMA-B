/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatest;
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
 * @author 17164260
 */
public class MenuFrame extends JFrame {
    private JButton btnGerente;
    private JButton btnCliente;
    
    public MenuFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        //setLayout(null);
        
        
        btnGerente = new JButton("Gerente");
        add(btnGerente);
        btnCliente = new JButton("Cliente");
        add(btnCliente);
        
        ButtonHandler handler = new ButtonHandler();
        btnGerente.addActionListener(handler);
        btnCliente.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnGerente){
                //chama o MenuGerenteFrame
                MenuGerenteFrame menuGerenteFrame = new MenuGerenteFrame();
                menuGerenteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuGerenteFrame.setSize(260, 200);
                menuGerenteFrame.setVisible(true);
            }
            else if(e.getSource() == btnCliente){
                //chama o ClienteFrame
                MenuClienteFrame contaFrame = new MenuClienteFrame();
                contaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                contaFrame.setSize(260, 180);
                contaFrame.setVisible(true);
            }
        }
    }
}