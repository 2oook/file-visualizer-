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
    static private int depth_of_rec = 0;
    static private int length_divider = 3;
    static private int rad_angle = 3;
    

    
    @Override
    public void draw( GraphicsContext gc, double x1, double y1, double angle, double length) 
    {
        this.gc = gc;
        
        double[] crd1 = DrawSmth.draw_star_rec(depth_of_rec, x1, y1, angle, length);
        double[] crd2 = DrawSmth.draw_star_rec(depth_of_rec, crd1[0], crd1[1], 2*Math.PI/3, 99);
        double[] crd3 = DrawSmth.draw_star_rec(depth_of_rec, crd2[0], crd2[1], 4*Math.PI/3, 99);
        

    }
    
    private static double[] draw_star_rec(int depth, double x1,  double y1, double angle, double length)//рекурсивный метод отрисовки фигур
    {
        if(depth == 0)
        {
            double[] coords = DrawSmth.coord_prep(angle, length, x1, y1); //подготовка (вычисление) координат конца отрезка

            
            System.out.println("Before stroke line");
            System.out.println(x1 + " " + y1);
            System.out.println(coords[0] + " " + coords[1]);
            
            gc.strokeLine(x1, y1, coords[0], coords[1]);
            
            //System.out.println("Coords with delta " + (coords[0]) + " " + (coords[1]));
            
            return coords;
        }
        else
        {
            
            
            double coords2[] = DrawSmth.draw_star_rec(depth - 1, x1, y1, angle, length / length_divider);
            double coords3[] = DrawSmth.draw_star_rec(depth - 1, coords2[0], coords2[1], angle - Math.PI / rad_angle, length / length_divider);
            double coords4[] = DrawSmth.draw_star_rec(depth - 1, coords3[0], coords3[1], angle + Math.PI / rad_angle, length / length_divider);
            double coords5[] = DrawSmth.draw_star_rec(depth - 1, coords4[0], coords4[1], angle, length / length_divider);
            
            return coords5;
        }
    }
    
    private static double[] coord_prep(double angle, double length, double x1, double y1)
    {
        double[] res = {0.0, 0.0}; 
        
        double x = Math.sin(angle)*length;
        double y = Math.cos(angle)*length;
        
        System.out.println(x + " " + y);
        
        
        res[0] = x1+x;
        res[1] = y1+y;
        
        System.out.println(res[0] + " " + res[1]);
        
        return res;
    }
    
    static void change_depth (int p)
    {
        depth_of_rec = p;
    }
    
    
    
    
}
