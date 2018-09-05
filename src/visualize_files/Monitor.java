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
    
    //критическая область (переменные совместно используемые двумя потоками)
    static private Color color = Color.DEEPPINK;    //инициализация цвета
    static private double x1 = 0;                   //инициализация первой координаты отрезка
    static private double y1 = 0;                   //инициализация первой координаты отрезка
    static private double angle = 0;                //инициализация угла поворота фигуры
    static private double length = 0;               //инициализация длины отрезка фигуры
    static private int depth_of_rec = 1;            //инициализация глубины рекурсии
    static private int length_divider = 3;          //инициализация коэффициента изменения длины линии
    static private int rad_angle = 3;               //инициализация коэффициент изменения угла отрисовки отрезка
    
    DrawSmth drow_obj = new DrawSmth(Visualize_files.gc);//создание объекта отрисовки фигуры
    
    private boolean fields_is_ready = false;             //флаг сигнализирующий о готовности переменных к использованию
    
    synchronized void get_params()//метод управляющий потоком преобразования байтов в переменные используемые для отрисовки фигур
    {
        fields_is_ready = true;
        
        
        color = Interpreter.color;
        x1 = Interpreter.x1;
        y1 = Interpreter.y1;
        angle = Interpreter.angle;
        length = Interpreter.length;
        depth_of_rec = Interpreter.depth_of_rec;
        length_divider = Interpreter.length_divider;
        rad_angle = Interpreter.rad_angle;
       
        System.out.println("Notifying in get_params");
        notify();//уведомить поток отрисовки фигур о том, что аргументы готовы
        
        while(fields_is_ready)//ждать пока не потребуются еще аргументы
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
    
    synchronized void visualize_bytes()//метод управляющий потоком отрисовки фигур
    {
            while(!fields_is_ready)//ждать пока не будут готовы аргументы
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
            notify();//уведомить поток интерпретатор о том, что требуются еще аргументы

    }

}
