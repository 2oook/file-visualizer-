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
    static private GraphicsContext gc;
    static private int depth_of_rec = 1;
    //static private double delta_w = 0; 
    //static private double delta_h = 0;
    
    @Override
    public double[] draw( GraphicsContext gc, double x1, double y1, double angle, double length) 
    {
        this.gc = gc;
        //this.delta_w = delta_w;
        //this.delta_h = delta_h;
        
        double[] further_coords = DrawSmth.draw_star_rec(depth_of_rec, x1, y1, angle, length);
        //gc.strokeLine(x1, y1, x2, y2);
        //gc.fillOval(x1, y1, x2, y2);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return further_coords;
    }
    
    private static double[] draw_star_rec(int depth, double x1,  double y1, double angle, double length)
    {
        if(depth == 0)
        {
            double[] coords = DrawSmth.coord_prep(angle, length);
            coords[0] = x1+coords[0];
            coords[1] = y1+coords[1];
            
            System.out.println("Before stroke line");
            System.out.println(x1 + " " + y1);
            System.out.println(coords[0] + " " + coords[1]);
            
            gc.strokeLine(x1, y1, coords[0], coords[1]);
            
            //System.out.println("Coords with delta " + (coords[0]) + " " + (coords[1]));
            
            return coords;
        }
        else
        {
            
            
            double coords2[] = DrawSmth.draw_star_rec(depth - 1, x1, y1, angle, length/3);
            double coords3[] = DrawSmth.draw_star_rec(depth - 1, coords2[0], coords2[1], angle - Math.PI/2, length/3);
            double coords4[] = DrawSmth.draw_star_rec(depth - 1, coords3[0], coords3[1], angle + Math.PI/2, length/3);
            double coords5[] = DrawSmth.draw_star_rec(depth - 1, coords4[0], coords4[1], angle, length/3);
            
            return coords5;
        }
    }
    
    private static double[] coord_prep(double angle, double length)
    {
        double[] res = {0.0, 0.0}; 
        
        double x = Math.sin(angle)*length;
        double y = Math.cos(angle)*length;
        
        System.out.println(x + " " + y);
        
        
        res[0] = x;
        res[1] = y;
        
        System.out.println(res[0] + " " + res[1]);
        
        return res;
    }
    
    static void change_depth (int p)
    {
        depth_of_rec = p;
    }
    
    
    
    
}
