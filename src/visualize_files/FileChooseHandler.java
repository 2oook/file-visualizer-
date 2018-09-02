/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author 2oook
 */
public class FileChooseHandler implements Runnable  
{
    
    Monitor monitor;
    
    FileChooseHandler(Monitor monitor)
    {
        Thread fch_thread = new Thread(this);    
        fch_thread.start();
        this.monitor = monitor;
    }
    
    @Override
    public void run()
    {
        handle_file();
    }
    
    void handle_file()
    {
        
                
        DrawSmth drow_obj = new DrawSmth(Visualize_files.gc);



        //monitor.visualize_bytes();


        int i= 1000000;
        do
        {
            
            monitor.visualize_bytes();
            //drow_obj.draw(Interpreter.x1, Interpreter.y1, Interpreter.angle, Interpreter.length, Interpreter.color);


            
        }
        while(--i > 0);


        /*if (interpreter.isAlive())
        {
            interpreter.interrupt();
            System.out.println("Thread interrupted");
        }   
        else
        {
            interpreter.start();
        }*/
    }
}
