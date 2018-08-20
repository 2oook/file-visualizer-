/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

/**
 *
 * @author iblow
 */
public class RecursivePrepFunc 
{
    static int deep_of_recursion = 4;
    static double [] res_massive = {};
    
    static double [] ret_coords ()
    {
        
        
        if(deep_of_recursion == 0)
        {
            //return 1;
            
        }
        else
        {
            deep_of_recursion -= 1;
            
        }
        
        
        
        
        
        return res_massive;
    }
}

