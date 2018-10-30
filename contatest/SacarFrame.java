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
public class SacarFrame extends JFrame {
    private JLabel lbNome;
    private JLabel lbNumero;
    private JLabel lbTaxaRendimento;
    private JTextField txtTaxaRendimento;
    private JTextField txtNome;
    private JPasswordField txtNumero;
    private JButton btnCriar;
    
    public SacarFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        setLayout(null);
        
        lbNome = new JLabel("Numero: ");
        lbNome.setToolTipText("Digite um numero.");
        add(lbNome);
        
        Dimension sizeNome = lbNome.getPreferredSize();
        lbNome.setBounds(10, 10, sizeNome.width, sizeNome.height);
        
        lbNumero = new JLabel("Senha: ");
        lbNumero.setToolTipText("Digite a senha da conta.");
        add(lbNumero);
        
        Dimension sizeSenha = lbNumero.getPreferredSize();
        lbNumero.setBounds(10, 35, sizeSenha.width, sizeSenha.height);
        
        lbTaxaRendimento = new JLabel("Valor: ");
        lbTaxaRendimento.setToolTipText("Digite o valor a ser sacado.");
        add(lbTaxaRendimento);
        
        Dimension sizeTaxa = lbTaxaRendimento.getPreferredSize();
        lbTaxaRendimento.setBounds(10, 60, sizeTaxa.width, sizeTaxa.height);
        
        txtTaxaRendimento = new JTextField(10);
        add(txtTaxaRendimento);
        
        Dimension sizeTxtTaxaRendimento = txtTaxaRendimento.getPreferredSize();
        txtTaxaRendimento.setBounds(60, 60, sizeTxtTaxaRendimento.width, sizeTxtTaxaRendimento.height);
        
        txtNome = new JTextField(10);
        add(txtNome);
        
        Dimension sizeTxtNome = txtNome.getPreferredSize();
        txtNome.setBounds(60, 10, sizeTxtNome.width, sizeTxtNome.height);
        
        //txtNumero = new JTextField(10);
        txtNumero = new JPasswordField("Hidden text");
        add(txtNumero);
        
        Dimension sizeTxtSenha = txtNumero.getPreferredSize();
        txtNumero.setBounds(60, 35, sizeTxtSenha.width, sizeTxtSenha.height);
        
        btnCriar = new JButton("Sacar");
        add(btnCriar);
        
        Dimension sizeBtnLogin = btnCriar.getPreferredSize();
        btnCriar.setBounds(50, 90, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnCriar.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           ContaFacade cf = ContaFacade.getInstance();
           String msg;
            try {
                msg = cf.saque(Integer.parseInt(txtNome.getText()),txtNumero.getText(), Double.parseDouble(txtTaxaRendimento.getText()));
            } catch (Exception ex) {
                 msg = "Numero Invalido! Digite novamente.";
                //Logger.getLogger(SacarFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
           JOptionPane.showMessageDialog(null, msg, "Mensagem", JOptionPane.PLAIN_MESSAGE);
          }
    }
}