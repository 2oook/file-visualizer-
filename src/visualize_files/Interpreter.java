/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.io.*;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;




/**
 *
 * @author 2oook
 */
class Interpreter implements Runnable
{
    Monitor monitor;
    
    Interpreter(Monitor monitor)
    {
        Thread interpreter_thread = new Thread(this);      
        interpreter_thread.start();
        this.monitor = monitor;
    }
    
    
    
    
    static Color color = Color.DEEPPINK;
    static double x1 = 0;
    static double y1 = 0;
    static double angle = 0;
    static double length = 0;
    static int depth_of_rec = 2;
    static int length_divider = 2;
    static int rad_angle = 1;


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
                    
                    byte[] hash;

                    if (temp != -1)
                    {
                        
                        System.out.println(temp + " " );

                        //получаем хэш байта
                                   
                        ByteHash bh = new ByteHash();
                        
                        hash = bh.byte_hash(temp);
                        
                        //получаем цвет
                        
                        r = Math.abs(hash[4]);//(int)Math.round(Math.random()*31)]);
                        g = Math.abs(hash[8]);//(int)Math.round(Math.random()*31)]);
                        b = Math.abs(hash[15]);//(int)Math.round(Math.random()*31)]);
                        
                        
                        //System.out.println("R " + r);
                        //System.out.println("G " + g);
                        //System.out.println("B " + r);
                        
                        color = Color.rgb (r, g, b);
                        
                        //получаем координаты
                        
                        x1 = Math.abs((hash[0] * 3.92));
                        y1 = Math.abs((hash[1] * 3.92));
                        
                        //получаем угол поворота фигуры
                        
                        angle = hash[2];
                        
                        //получаем длину 
                        
                        length = Math.abs(hash[3] / 4); 
                        
                        //получаем глубину рекурсии
                        
                        if(hash[5]%2 != 0)
                        {
                            depth_of_rec = 2;
                        }
                        else 
                        {
                            depth_of_rec = 1;
                        }
                        
                        if(hash[31] > 69)
                        {
                            depth_of_rec = 0;
                        }
                        
                        //получаем коэффициент изменения длины линии
                        
                                               
                        if(hash[6]%2 != 0)
                        {
                            length_divider = 2;
                        }
                        else 
                        {
                            length_divider = 3;
                        }
                        
                        
                        
                        //получаем коэффициент изменения угла внутри фигуры
                        
                        if(length_divider == 3)
                        {
                            rad_angle = 3;
                        }
                        else 
                        {
                            rad_angle = 1;
                        }


                        
                        //вызов метода передающего параметры 


                        monitor.get_params();
                        
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

