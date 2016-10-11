/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shsun
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import include.Message;
import include.RegisterCheck;

public class UserLogin implements ActionListener {
   
    private String path = "/tmp/users.txt";
    JFrame jf;
    JTextField uname;
    JPasswordField pass;

    public UserLogin() {
        jf = new JFrame("Login");
        jf.setLayout(new GridLayout(5, 1));
        jf.add(new JPanel());
        
        //user name 
        JLabel jl1 = new JLabel(" User Name：          ");
        uname = new JTextField(16);       
        JPanel jp1 = new JPanel();
        jp1.add(jl1);
        jp1.add(uname);
        jf.add(jp1);

        //password
        JLabel jl2 = new JLabel(" Password：            ");
        pass = new JPasswordField(16);
        JPanel jp2 = new JPanel();
        jp2.add(jl2);
        jp2.add(pass);
        jf.add(jp2);

        //button
        JPanel jp3 = new JPanel();
        JButton jb1 = new JButton("Register");
        jb1.addActionListener(this);
        JButton jb2 = new JButton("Login");
        jb2.addActionListener(this);
        JButton jb3 = new JButton("Quit");
        jb3.addActionListener(this);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        jf.add(jp3);

        jf.setResizable(true);
        jf.setVisible(true);
        jf.setSize(350, 300);
        jf.setLocation(300, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if (act.equals("Register")) { 
            jf.dispose();
            new UserRegistration();
        } else if (act.equals("Login")) {
            if ("".equals(uname.getText()) || "".equals(new String(pass.getPassword())) || pass.getPassword() == null) {
                
                Message.showMessage(jf, "User and Password cannot be empty","");
                uname.setText(null);
                pass.setText(null);
                uname.requestFocus();
            } else {
                String str = uname.getText() + "&&" + new String(pass.getPassword());

                try {
                     if (!RegisterCheck.isRegistered(uname.getText(), path)){
                        Message.showMessage(jf, "User Name does not exist!","");
                        uname.setText(null);
                        pass.setText(null);
                        uname.requestFocus();
                     }
                } catch (IOException ex) {
                     Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (RegisterCheck.isLogin(str, path)){
                        Message.showMessage(jf, "Login Sucessfully! User:"+uname.getText(),"");
                    }else{
                        Message.showMessage(jf, "Password is not correct!","");
                        uname.setText(null);
                        pass.setText(null);                      
                        uname.requestFocus();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                  
          }else if (act.equals("Quit")) {
            System.exit(0);
        }  

     }
    }

        