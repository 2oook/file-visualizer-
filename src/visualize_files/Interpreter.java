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
    
    Color color;
    double x1 = 0;
    double y1 = 0;
    double angle = 0;
    double length = 0;
   
    @Override
    public void run()
    {
        GetByte();
    }
    
    private synchronized void  GetByte ()
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
                    
                    byte[] hash;

                    if (temp != -1)
                    {

                        //logic of interpretation
                        
                        
                        ByteHash bh = new ByteHash();
                        
                        hash = bh.byte_hash(temp);
                        
                        //получаем цвет
                        
                        r = Math.abs(hash[(int)Math.round(Math.random()*31)]);
                        g = Math.abs(hash[(int)Math.round(Math.random()*31)]);
                        b = Math.abs(hash[(int)Math.round(Math.random()*31)]);
                        
                        color = Color.rgb (r, g, b);
                        
                        //получаем координаты
                        
                        x1 = (hash[0] * 3.92)/1000;
                        y1 = (hash[1] * 3.92)/1000;
                        
                        //получаем угол
                        
                        angle = hash[2] / 100;
                        
                        //получаем длину 
                        
                        length = hash[3] / 10; 

 


                        System.out.println(temp + " " );
                        
                        //вызов метода передающего параметры 
                        
                        send_params();
                        
                        try 
                        {
                            Interpreter.sleep(10000);
                        } 
                        catch (InterruptedException ex) 
                        {
                            Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
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
    
    private Interpreter send_params()
    {
        
        return  this;
    };

}

