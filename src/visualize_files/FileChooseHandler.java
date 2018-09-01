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
 * @author iblow
 */
public class FileChooseHandler {
    static synchronized void handle_file(GraphicsContext gc)
    {
        Interpreter interpreter = new Interpreter ();
                
                interpreter.start();
                
                DrawSmth drow_obj = new DrawSmth(gc);
                
                try 
                {
                    interpreter.waiting_for_file.acquire();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Visualize_files.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                int i= 1000;
                do
                {
                drow_obj.draw(interpreter.x1, interpreter.y1, interpreter.angle, interpreter.length, interpreter.color);
                
                
                
                interpreter.waiting_for_file.release();
                
                //System.out.println("Notifying");
                
                //interpreter.notify();
                
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
