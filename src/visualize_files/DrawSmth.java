/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author iblow
 */
public class DrawSmth implements FigureForDraw 
{

    @Override
    public void draw( GraphicsContext gc, double x1, double y1, double x2, double y2) 
    {
        gc.strokeLine(x1, y1, x2, y2);
        //gc.fillOval(x1, y1, x2, y2);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
