/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;

/**
 *
 * @author 2oook
 */
public class Monitor {
    
    static Color color = Color.DEEPPINK;
    static double x1 = 0;
    static double y1 = 0;
    static double angle = 0;
    static double length = 0;
    
    DrawSmth drow_obj = new DrawSmth(Visualize_files.gc);
    
    private boolean assert_flag = false;
    
    private boolean fields_is_ready = false;
    
    synchronized void get_params()
    {
        fields_is_ready = true;
        System.out.println("Notifying get_params");
        notify();
        
        color = Interpreter.color;
        x1 = Interpreter.x1;
        y1 = Interpreter.y1;
        angle = Interpreter.angle;
        length = Interpreter.length;
        
        
        while(fields_is_ready)
        {
            try 
            {
                System.out.println("Waiting get_params");
                wait();
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
    
    synchronized void visualize_bytes()
    {
            while(!fields_is_ready)
            {
                try 
                {
                    System.out.println("Waiting visualize_bytes");
                    wait();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            fields_is_ready = false;
            
            drow_obj.draw(x1, y1, angle, length, color);
            
            System.out.println("Notifying visualize_bytes");
            notify();

    }
    
    
    private void do_wait()
    {
        if(assert_flag == true){
            while(assert_flag){
                try 
                {
                    wait();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
           while(!assert_flag){
                try 
                {
                    wait();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }
        
    }
}
