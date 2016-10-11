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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import include.Message;
import include.RegisterCheck;
import model.User;
public class UserRegistration implements ActionListener {
   
    private ArrayList<User> list = new ArrayList<User>();
    private String path = "/tmp/users.txt";
    
    JFrame jf;
    JTextField uname, email;
    JPasswordField pass, repass;
    
    public ArrayList<User> getList() {
       return list;
    }
    
    public UserRegistration() {
        
        //JFrame
        jf = new JFrame("Registration");      
        jf.setLayout(new GridLayout(7, 1));
        jf.add(new JPanel());
        
        //user name 
        JLabel jl1 = new JLabel(" User Name：         ");
        uname = new JTextField(16);       
        JPanel jp1 = new JPanel();
        jp1.add(jl1);
        jp1.add(uname);
        jf.add(jp1);

        //email 
        JLabel jl2 = new JLabel(" Email：                 ");
        email = new JTextField(16);       
        JPanel jp2 = new JPanel();
        jp2.add(jl2);
        jp2.add(email);
        jf.add(jp2);
        
        //password
        JLabel jl3 = new JLabel(" Password：          ");
        pass = new JPasswordField(16);
        JPanel jp3 = new JPanel();
        jp3.add(jl3);
        jp3.add(pass);
        jf.add(jp3);
        
        //re-password
        JLabel jl4 = new JLabel(" Password Again：");
        repass = new JPasswordField(16);
        JPanel jp4 = new JPanel();
        jp4.add(jl4);
        jp4.add(repass);
        jf.add(jp4);

        //buttons
        JPanel jp5 = new JPanel();
        JButton jb1 = new JButton("Register");
        jb1.addActionListener(this);
        JButton jb2 = new JButton("Quit");
        jb2.addActionListener(this);
        jp5.add(jb1);
        jp5.add(jb2);
        jf.add(jp5);

        jf.setResizable(true);
        jf.setVisible(true);
        jf.setSize(350, 300);
        jf.setLocation(300, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        if (act.equals("Register")) {
            
            
            String userName = uname.getText().trim();
            String mail = email.getText().trim();
            String password = new String(pass.getPassword());
            String repassword = new String(repass.getPassword());
            String error = new String();
            boolean isVaild = true; 
        
            if (!password.equals(repassword)) {
                Message.showMessage(jf, "Password must match","");
                isVaild = false;
            }
            if ("".equals(userName) || "".equals(password)){
                Message.showMessage(jf, "User and Password cannot be empty","");
                isVaild = false;
            }
            if (RegisterCheck.isVaildEmail(mail)== false){
                Message.showMessage(jf, "Email address must be valid","");
                isVaild = false;
            }
            try {
                if (RegisterCheck.isRegistered(userName, path)){
                    Message.showMessage(jf, "User Name exist already, please try another one","");
                    isVaild = false; 
                }
            } catch (IOException ex) {
                Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            
            if (isVaild){
                User user = new User();
                user.setUserName(userName);
                user.setEmail(mail);
                user.setPassWord(password);

                //save to arrary
                list.add(user);
                
                //save to disk 
                String str = user.getUserName() + "&&"+ user.getPassWord() +"&&" + user.getEmail() +"\n";
                try {
                    writeToFile(str);
                } catch (IOException ex) {
                    Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
                Message.showMessage(jf, "User "+user.getUserName()+" added sucessfully", "");
            }
        }else if (act.equals("Quit")) {
            System.exit(0);
        }    
    }
    
    public static void main(String[] args) {
        new UserRegistration();
    }
    
    public void writeToFile(String str) throws IOException{
        File file = new File(path);
        file.createNewFile();  
        try {
            try (FileOutputStream fos = new FileOutputStream(file, true)) {
                fos.write(str.getBytes());
            }
        } catch (Exception e1) {
                Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, e1);
        }
    } 
     
}
                   

