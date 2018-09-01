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
public class FileChooseHandler extends Thread  
{
    @Override
    public void run()
    {
        handle_file();
    }
    
    synchronized void handle_file()
    {
        
                
        DrawSmth drow_obj = new DrawSmth(Visualize_files.gc);

        /*try 
        {
            interpreter.waiting_for_file.acquire();
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Visualize_files.class.getName()).log(Level.SEVERE, null, ex);
        }*/




        int i= 1000;
        do
        {

        /*try 
        {
            System.out.println("Waiting in FCH");
            wait();  
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(FileChooseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        System.out.println("After waiting in FCH");
        drow_obj.draw(Interpreter.x1, Interpreter.y1, Interpreter.angle, Interpreter.length, Interpreter.color);



        //interpreter.waiting_for_file.release();

        System.out.println("Notifying in FCH");

        notifyAll();

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
