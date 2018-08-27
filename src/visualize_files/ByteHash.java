/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iblow
 */
public class ByteHash 
{
    byte[] byte_hash(int b)
    {
        byte[] hash = {};
        
        
        
        try 
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest();
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println( " " + hash);
        
        
        
        return hash;
    }
}
