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
public class NovaContaFrame extends JFrame {
    private JButton btnSimples;
    private JButton btnPoupanca;
    private JButton btnEspecial;
    
    public NovaContaFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        //setLayout(null);
        
        btnSimples = new JButton("Conta Simples");
        add(btnSimples);
        btnPoupanca = new JButton("Conta Poupanca");
        add(btnPoupanca);
        btnEspecial = new JButton("Conta Especial");
        add(btnEspecial);
        
        ButtonHandler handler = new ButtonHandler();
        btnSimples.addActionListener(handler);
        btnPoupanca.addActionListener(handler);
        btnEspecial.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnSimples){
                //chama o CadastraContaSimplesFrame
                CadastrarContaSimplesFrame cadastraContaSimplesFrame = new CadastrarContaSimplesFrame();
                cadastraContaSimplesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastraContaSimplesFrame.setSize(260, 200);
                cadastraContaSimplesFrame.setVisible(true);
            }
            if(e.getSource() == btnPoupanca){
                //chama o CadastraContaPoupancaFrame
                CadastraContaPoupancaFrame cadastraContaPoupancaFrame = new CadastraContaPoupancaFrame();
                cadastraContaPoupancaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                cadastraContaPoupancaFrame.setSize(260, 200);
                cadastraContaPoupancaFrame.setVisible(true);
            }
            else if(e.getSource() == btnEspecial){
                //chama o CadastraContaEspecialFrame
                ClienteFrame contaFrame = new ClienteFrame();
                contaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                contaFrame.setSize(260, 180);
                contaFrame.setVisible(true);
            }
        }
    }
}