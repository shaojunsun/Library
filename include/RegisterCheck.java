/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.include;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author shsun
 */
public class RegisterCheck {
    
    public static boolean isVaildEmail(String email){
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }   
    /**
     *
     * @param username
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static boolean isRegistered(String username, String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            String s1 = "";
            byte[] b = new byte[1024];
            while (true) {
                int i = fis.read(b);
                if (i == -1)
                    break;
                s1 = s1 + new String(b, 0, i);
            }
            int i = s1.indexOf(username);
            if (i != -1){ return true;}
        }
        return false;
    }
    public static boolean isLogin(String str, String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        try (FileInputStream fis = new FileInputStream(file)) {
            String s1 = "";
            byte[] b = new byte[1024];
            while (true) {
                int i = fis.read(b);
                if (i == -1)
                    break;
                s1 = s1 + new String(b, 0, i);
            }
            System.out.println(s1);
            System.out.println(str);
            int i = s1.indexOf(str);
            System.out.println(i);
            if (i != -1){ return true;}
        }
        return false;
    }
    
}
