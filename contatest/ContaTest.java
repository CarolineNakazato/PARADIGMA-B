/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatest;
import javax.swing.JFrame;
/**
 *
 * @author 17164260
 */
public class ContaTest {
    public static void main (String[] agrs){
        MenuFrame menu = new MenuFrame();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(260, 180);
        menu.setVisible(true);
    }
}