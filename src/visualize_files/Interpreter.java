/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.io.*;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.paint.Color;
import javax.swing.JFileChooser;







/**
 *
 * @author 2oook
 */
public class Interpreter extends Thread
{
   
    @Override
    public void run()
    {
        GetByte();
    }
    
    void  GetByte ()
    {

        JFileChooser fileopen = new JFileChooser();
        
        fileopen.setCurrentDirectory(new File("."));
        int ret = fileopen.showDialog(null, "Открыть файл");

        if (ret == JFileChooser.APPROVE_OPTION) 
        {
            File file = fileopen.getSelectedFile();
            
            try(FileReader opfile = new FileReader(file.getAbsolutePath()))
            {

                int temp;
                int r = 255;
                int g = 255;
                int b = 255;

                do 
                {
                    temp = opfile.read();
                    int byte_hash = 0;

                    if (temp != -1)
                    {

                        //logic of interpretation
                        
                        //byte_hash = Integer.toString(temp).hashCode();
                        ByteHash bh = new ByteHash();
                        
                        bh.byte_hash(temp);
                        
                        Color color = Color.rgb (r, g, b);


                        System.out.println(temp + " " );
                    }

                }
                while (temp != -1);


            } 
            catch (IOException e1) 
            {
                System.out.println("Can not read file");
            }
        }
        
		
        
    }
    

}

