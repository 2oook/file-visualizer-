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
        Thread fch_thread = new Thread(this); //создаём новый поток    
        fch_thread.start();                   //запускаем поток
        this.monitor = monitor;               //инициализация монитора
    }
    
    @Override
    public void run()
    {
        handle_file();
    }
    
    void handle_file()
    {
        while(true)
        {
            
            monitor.visualize_bytes();
            System.out.println("Drawing in FCH");
            
        }
    }
}
