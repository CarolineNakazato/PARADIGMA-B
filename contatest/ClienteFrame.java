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
public class ClienteFrame extends JFrame {
    private JLabel lbNome;
    private JLabel lbSenha;
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    
    public ClienteFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        setLayout(null);
        
        lbNome = new JLabel("Nome: ");
        lbNome.setToolTipText("Digite um nome.");
        add(lbNome);
        
        Dimension sizeNome = lbNome.getPreferredSize();
        lbNome.setBounds(10, 10, sizeNome.width, sizeNome.height);
        
        lbSenha = new JLabel("Senha: ");
        lbSenha.setToolTipText("Digite uma senha.");
        add(lbSenha);
        
        Dimension sizeSenha = lbSenha.getPreferredSize();
        lbSenha.setBounds(10, 40, sizeSenha.width, sizeSenha.height);
        
        txtNome = new JTextField(10);
        add(txtNome);
        
        Dimension sizeTxtNome = txtNome.getPreferredSize();
        txtNome.setBounds(50, 10, sizeTxtNome.width, sizeTxtNome.height);
        
        txtSenha = new JPasswordField("Hidden text");
        add(txtSenha);
        
        Dimension sizeTxtSenha = txtSenha.getPreferredSize();
        txtSenha.setBounds(50, 40, sizeTxtSenha.width, sizeTxtSenha.height);
        
        btnLogin = new JButton("Login");
        add(btnLogin);
        
        Dimension sizeBtnLogin = btnLogin.getPreferredSize();
        btnLogin.setBounds(50, 80, sizeBtnLogin.width, sizeBtnLogin.height);
        
        ButtonHandler handler = new ButtonHandler();
        btnLogin.addActionListener(handler);
        
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //verifica se o cliente existe
            try{
                BufferedReader br = new BufferedReader(new FileReader("arq.txt"));
                while(br.ready()){
                    String linha = br.readLine();
                    System.out.println(linha);
                }
                br.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}