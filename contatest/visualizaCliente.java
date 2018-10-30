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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 17164260
 */
public class visualizaCliente extends JFrame {
    private JLabel lbNumero;
    private JTextField txtNumero;
    private JButton btnVisualizar;
    private JLabel lbSenha;
    private JPasswordField txtSenha;
    private JLabel lbInformacao;
    
    public visualizaCliente(){
        super("Conta Bancaria");
        setLayout(null);
       
        lbNumero = new JLabel("Numero: ");
        lbNumero.setToolTipText("Digite o numero da conta.");
        add(lbNumero);
        
        Dimension sizeNome = lbNumero.getPreferredSize();
        lbNumero.setBounds(10, 10, sizeNome.width, sizeNome.height);
        
        txtNumero = new JTextField(10);
        add(txtNumero);
        
        Dimension sizeTxtNome = txtNumero.getPreferredSize();
        txtNumero.setBounds(60, 10, sizeTxtNome.width, sizeTxtNome.height);
        
        lbSenha = new JLabel("Senha: ");
        lbSenha.setToolTipText("Digite a senha da conta.");
        add(lbSenha);
        
        Dimension sizeSenha = lbSenha.getPreferredSize();
        lbSenha.setBounds(10, 35, sizeSenha.width, sizeSenha.height);
        
        txtSenha = new JPasswordField("Hidden text");
        //txtSenha = new JTextField(10);
        add(txtSenha);
        
        Dimension sizeTxtSenha = txtSenha.getPreferredSize();
        txtSenha.setBounds(60, 35, sizeTxtSenha.width, sizeTxtSenha.height);
        
        lbInformacao = new JLabel("Informacao");
        lbInformacao.setToolTipText("informacao da conta.");
        add(lbInformacao);
        
        lbInformacao.setBounds(10, 45, 150, 150);
         
        btnVisualizar = new JButton("Visualizar");
        add(btnVisualizar);
                       
        Dimension sizeBtnLogin = btnVisualizar.getPreferredSize();
        btnVisualizar.setBounds(60, 200, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnVisualizar.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{
        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           //verifica se o cliente existe
           ContaFacade cf = ContaFacade.getInstance();
            try {
                lbInformacao.setText(cf.imprime(Integer.parseInt(txtNumero.getText()), txtSenha.getText()));
            } catch (Exception ex) {
                lbInformacao.setText("Numero Invalido.");
                //Logger.getLogger(visualizaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}