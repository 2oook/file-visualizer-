/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.io.*;
import javax.swing.JFileChooser;







/**
 *
 * @author ilyawest
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
        int temp;
        
        JFileChooser fileopen = new JFileChooser();
               fileopen.setCurrentDirectory(new File("."));
                int ret = fileopen.showDialog(null, "Открыть файл");                
                if (ret == JFileChooser.APPROVE_OPTION) 
                {
                    File file = fileopen.getSelectedFile();
                    try 
                    {
                        FileRead(file.getAbsolutePath());
                    } 
                    catch (IOException e1) 
                    {
                        System.out.println("Can not read file");
                    }
                }
        
		/*try (FileReader opfile = new FileReader(args[0]))
                {
                    
				
			do {
				temp = opfile.read();
			
			}while (temp != -1);
			
			
		}
                catch (IOException exc)
                {
			System.out.println("File IO fault");
		}*/
        
    }
    
    
    public void FileRead(String Filename) throws FileNotFoundException, IOException
    {         
        try (FileReader opfile = new FileReader(Filename))
        {
            int temp;
            
            do 
            {
		temp = opfile.read();
		
                if (temp != -1)
                {
                     
                    //logic of interpretation
                    
                    
                    
                    
					
                    System.out.println(temp + " " );
		}
                
            }while (temp != -1);
			
			
	}
        catch (IOException exc)
        {
            System.out.println("File IO fault");
        }

    }


}

