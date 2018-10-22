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
public class MenuGerenteFrame extends JFrame {
    private JButton btnNovaConta;
    private JButton btnInformacaoConta;
    private JButton btnIncrementaRendimento;
    private JButton btnCobraJuros;
    private JButton btnImprimeTodasContas;
    
    public MenuGerenteFrame(){
        super("Conta Bancaria");
        setLayout(new FlowLayout());
        //setLayout(null);
       
        btnNovaConta = new JButton("Criar Nova Conta");
        add(btnNovaConta);
        btnInformacaoConta = new JButton("Visualizar Conta");
        add(btnInformacaoConta);
        btnIncrementaRendimento = new JButton("Incrementar Rendimento");
        add(btnIncrementaRendimento);
        btnCobraJuros = new JButton("Cobrar juros");
        add(btnCobraJuros);
        btnImprimeTodasContas = new JButton("Imprimir Todas Contas");
        add(btnImprimeTodasContas);
        
        ButtonHandler handler = new ButtonHandler();
        btnNovaConta.addActionListener(handler);
        btnInformacaoConta.addActionListener(handler);
        btnIncrementaRendimento.addActionListener(handler);
        btnCobraJuros.addActionListener(handler);
        btnImprimeTodasContas.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener{

        public ButtonHandler() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnNovaConta){
                //chama o NovaContaFrame
                NovaContaFrame novaContaFrame = new NovaContaFrame();
                novaContaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                novaContaFrame.setSize(460, 80);
                novaContaFrame.setVisible(true);
            }
            if(e.getSource() == btnInformacaoConta){
                //chama o VisualizaContaFrame
                ClienteFrame contaFrame = new ClienteFrame();
                contaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                contaFrame.setSize(260, 180);
                contaFrame.setVisible(true);
            }
            if(e.getSource() == btnIncrementaRendimento){
                //chama o RendimentoFrame
            }
            if(e.getSource() == btnCobraJuros){
                //chama o JurosFrame
                ClienteFrame contaFrame = new ClienteFrame();
                contaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                contaFrame.setSize(260, 180);
                contaFrame.setVisible(true);
            }
            else if(e.getSource() == btnImprimeTodasContas){
                //chama o ImprimeFrame
                ClienteFrame contaFrame = new ClienteFrame();
                contaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                contaFrame.setSize(260, 180);
                contaFrame.setVisible(true);
            }
        }
    }
}