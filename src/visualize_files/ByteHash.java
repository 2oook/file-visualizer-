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
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author iblow
 */
public class ByteHash 
{
    byte[] byte_hash(int b)
    {
        byte[] hash = {};
        byte[] in = {(byte)b};
        String s  = "";
        
        
        
        try 
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(in);
            hash = md.digest();     
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        s  = DatatypeConverter.printHexBinary(hash).toLowerCase();
        //System.out.println( " " + s + " " + s.length());
        
        return hash;
    }
}
