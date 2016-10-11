/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.include;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author shsun
 */
public class Message {
    
        public static void showMessage (JFrame jf, String message, String option){
        //if (title.isEmpty())  {title = "Message";}
        
        if (option.isEmpty()) {
           JOptionPane.showMessageDialog(jf, message, option,JOptionPane.PLAIN_MESSAGE);
        }else if (option.equals("Error")){
           JOptionPane.showMessageDialog(jf, message, option,JOptionPane.ERROR_MESSAGE);
        }else{
           JOptionPane.showConfirmDialog(jf, message, option, JOptionPane.CLOSED_OPTION);
        }       
    }   
}
