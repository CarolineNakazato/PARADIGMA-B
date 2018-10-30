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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 17164260
 */
public class VisualizaContaFrame extends JFrame {
    private JLabel lbInformacao;
    private JLabel lbNumero;
    private JTextField txtNumero;
    private JButton btnVisualizar;
    
    public VisualizaContaFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        setLayout(null);
        
        lbNumero = new JLabel("Numero: ");
        lbNumero.setToolTipText("Digite o numero da conta.");
        add(lbNumero);
        
        Dimension sizeNome = lbNumero.getPreferredSize();
        lbNumero.setBounds(10, 10, sizeNome.width, sizeNome.height);
        
        lbInformacao = new JLabel("Informacao");
        lbInformacao.setToolTipText("informacao da conta.");
        add(lbInformacao);
        
        //Dimension sizeSenha = lbInformacao.getPreferredSize();
        lbInformacao.setBounds(10, 30, 150, 150);
        
        txtNumero = new JTextField(10);
        add(txtNumero);
        
        Dimension sizeTxtNome = txtNumero.getPreferredSize();
        txtNumero.setBounds(60, 10, sizeTxtNome.width, sizeTxtNome.height);
               
        btnVisualizar = new JButton("Visualizar");
        add(btnVisualizar);
        
        Dimension sizeBtnLogin = btnVisualizar.getPreferredSize();
        btnVisualizar.setBounds(50, 200, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnVisualizar.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{
        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           ContaFacade cf = ContaFacade.getInstance();
            try {
                lbInformacao.setText(cf.visualizaInformacao(Integer.parseInt(txtNumero.getText())));
            } catch (Exception ex) {
                lbInformacao.setText("Numero Invalido!");
                //lbInformacao.setText(ex.getMessage());
                //Logger.getLogger(VisualizaContaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}