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
import java.util.InputMismatchException;
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
public class CadastrarContaSimplesFrame extends JFrame {
    private JLabel lbNome;
    private JLabel lbNumero;
    private JTextField txtNome;
    private JTextField txtNumero;
    private JButton btnCriar;
    
    public CadastrarContaSimplesFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        setLayout(null);
    
        lbNome = new JLabel("Nome: ");
        lbNome.setToolTipText("Digite um nome conta.");
        add(lbNome);
        
        Dimension sizeNome = lbNome.getPreferredSize();
        lbNome.setBounds(10, 10, sizeNome.width, sizeNome.height);
        
        lbNumero = new JLabel("Numero: ");
        lbNumero.setToolTipText("Digite o numero da conta.");
        add(lbNumero);
        
        Dimension sizeSenha = lbNumero.getPreferredSize();
        lbNumero.setBounds(10, 40, sizeSenha.width, sizeSenha.height);
        
        txtNome = new JTextField(10);
        add(txtNome);
        
        Dimension sizeTxtNome = txtNome.getPreferredSize();
        txtNome.setBounds(60, 10, sizeTxtNome.width, sizeTxtNome.height);
        
        txtNumero = new JTextField(10);
        add(txtNumero);
        
        Dimension sizeTxtSenha = txtNumero.getPreferredSize();
        txtNumero.setBounds(60, 40, sizeTxtSenha.width, sizeTxtSenha.height);
        
        btnCriar = new JButton("Criar");
        add(btnCriar);
        
        Dimension sizeBtnLogin = btnCriar.getPreferredSize();
        btnCriar.setBounds(50, 80, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnCriar.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{
        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           //verifica se o cliente existe
           ContaFacade cf = ContaFacade.getInstance();
           String msg;
            try {
                msg = cf.novaContaSimples(txtNome.getText(), Integer.parseInt(txtNumero.getText()));
            } catch (Exception ex) {
                msg = "Numero Invalido! Digite novamente.";
                //Logger.getLogger(CadastrarContaSimplesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, msg, "Mensagem", JOptionPane.PLAIN_MESSAGE);
           
        }
    }
}