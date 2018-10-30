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
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author 17164260
 */
public class JurosFrame extends JFrame {
    private JLabel lbNumero;
    private JTextField txtNumero;
    private JButton btnCobrar;
    
    public JurosFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        setLayout(null);
        
        lbNumero = new JLabel("Valor: ");
        lbNumero.setToolTipText("Digite o valor do juros.");
        add(lbNumero);
        
        Dimension sizeNome = lbNumero.getPreferredSize();
        lbNumero.setBounds(10, 10, sizeNome.width, sizeNome.height);
     
        txtNumero = new JTextField(10);
        add(txtNumero);
        
        Dimension sizeTxtNome = txtNumero.getPreferredSize();
        txtNumero.setBounds(60, 10, sizeTxtNome.width, sizeTxtNome.height);
               
        btnCobrar = new JButton("Cobrar");
        add(btnCobrar);
        
        Dimension sizeBtnLogin = btnCobrar.getPreferredSize();
        btnCobrar.setBounds(60, 40, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnCobrar.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{
        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           ContaFacade cf = ContaFacade.getInstance();
           String msg;
            try {
                msg = cf.cobrarJuros(Double.parseDouble(txtNumero.getText()));
            } catch (Exception ex) {
                msg = "Numero Invalido! Digite novamente.";
                //Logger.getLogger(JurosFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, msg, "Mensagem", JOptionPane.PLAIN_MESSAGE);
        }
    }
}