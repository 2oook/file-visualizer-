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
    
    static private Color color = Color.DEEPPINK;
    static private double x1 = 0;
    static private double y1 = 0;
    static private double angle = 0;
    static private double length = 0;
    static private int depth_of_rec = 1;
    static private int length_divider = 3;
    static private int rad_angle = 3;
    
    DrawSmth drow_obj = new DrawSmth(Visualize_files.gc);
    
    private boolean fields_is_ready = false;
    
    synchronized void get_params()
    {
        fields_is_ready = true;
        System.out.println("Notifying in get_params");
        notify();
        
        color = Interpreter.color;
        x1 = Interpreter.x1;
        y1 = Interpreter.y1;
        angle = Interpreter.angle;
        length = Interpreter.length;
        depth_of_rec = Interpreter.depth_of_rec;
        length_divider = Interpreter.length_divider;
        rad_angle = Interpreter.rad_angle;
        
        
        while(fields_is_ready)
        {
            try 
            {
                System.out.println("Waiting in get_params");
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
            
            drow_obj.draw(x1, y1, angle, length, color, depth_of_rec, length_divider, rad_angle);
            
            System.out.println("Notifying visualize_bytes");
            notify();

    }

}
