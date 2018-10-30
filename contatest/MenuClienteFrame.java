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
public class MenuClienteFrame extends JFrame {
    private JButton btnNovaConta;
    private JButton btnInformacaoConta;
    private JButton btnIncrementaRendimento;
    private JButton btnCobraJuros;
    
    public MenuClienteFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        //setLayout(null);
       
        btnNovaConta = new JButton("Sacar");
        add(btnNovaConta);
        btnInformacaoConta = new JButton("Depositar");
        add(btnInformacaoConta);
        btnIncrementaRendimento = new JButton("Visualizar Informacao");
        add(btnIncrementaRendimento);
        btnCobraJuros = new JButton("Alterar senha");
        add(btnCobraJuros);
        
        ButtonHandler handler = new ButtonHandler();
        btnNovaConta.addActionListener(handler);
        btnInformacaoConta.addActionListener(handler);
        btnIncrementaRendimento.addActionListener(handler);
        btnCobraJuros.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnNovaConta){
                //chama o SacarFrame
                SacarFrame novaContaFrame = new SacarFrame();
                novaContaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                novaContaFrame.setSize(260, 180);
                novaContaFrame.setVisible(true);
            }
            if(e.getSource() == btnInformacaoConta){
                //chama o DepositarFrame
                DepositarFrame visualizaContaFrame = new DepositarFrame();
                visualizaContaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                visualizaContaFrame.setSize(300, 300);
                visualizaContaFrame.setVisible(true);
            }
            if(e.getSource() == btnIncrementaRendimento){
                //chama o visualizaCliente
                visualizaCliente jurosFrame = new visualizaCliente();
                jurosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jurosFrame.setSize(300, 300);
                jurosFrame.setVisible(true);
            }
            else if(e.getSource() == btnCobraJuros){
                //chama o AlteraSenha
                AlteraSenha jurosFrame = new AlteraSenha();
                jurosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jurosFrame.setSize(260, 180);
                jurosFrame.setVisible(true);
            }
        }
    }
}