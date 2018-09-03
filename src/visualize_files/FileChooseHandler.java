/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

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

        int i= 1000000;
        do
        {
            
            monitor.visualize_bytes();
            
        }
        while(--i > 0);

    }
}
