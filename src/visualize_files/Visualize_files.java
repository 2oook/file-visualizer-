/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Visualize_files extends Application 
{
    static GraphicsContext gc;
    double canvas_w = 500;
    double canvas_h = 500;
    double x1 = canvas_w-400, x2 = canvas_w-400, y1 = canvas_h-400, y2 = canvas_h-400;
    int i = 0;
    
    @Override
    public synchronized void start(Stage primaryStage) {
        
        Button btn = new Button();
        btn.setText("Choose file");
        
        Button clear_btn = new Button();
        clear_btn.setText("Clear plate");
        
        Button chg_depth_btn = new Button();
        chg_depth_btn.setText("Set depth");
        
        TextField chg_depth_tf = new TextField();
        
        
        
        
        chg_depth_btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                //if(chg_depth_tf.getText())
                    
                int p = Integer.parseInt(chg_depth_tf.getText());

                System.out.println(chg_depth_tf.getText() + " ");

                DrawSmth.change_depth(p);
 
                
            }
        });
        
        clear_btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                gc.clearRect(0,0, canvas_w,canvas_h);
                
                
                x1 = x2 = canvas_w-400;
                y1 = y2 = canvas_h-400;
                
                
                
                System.out.println("In handle of clear button");
            
            }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                Interpreter interpreter = new Interpreter();
                
                interpreter.start();
                         
                FileChooseHandler fch = new FileChooseHandler();
                
                fch.start();
                
                
                
     
                
            }
        });
        
        
        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
        //root.setBackground(Background.EMPTY);
        Scene scene = new Scene(root, 500, 600);
        
        primaryStage.setTitle("Visualize your file");
        primaryStage.setScene(scene);
        
        
        
        Canvas vizual_canvas = new Canvas (canvas_w, canvas_h);
        
        gc = vizual_canvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        
       
        
        
        vizual_canvas.setOnScroll(new EventHandler() 
        {       
            @Override
            public void handle(Event event) 
            {
                
                
                
                DrawSmth drow_obj = new DrawSmth(gc);
                
                //drow_obj.draw(gc, x1, y1, 0, 99, Color);
                
                //здесь будет вызов интерпретатора.....

                

            }
        });
        

        
        root.getChildren().addAll(vizual_canvas, btn, clear_btn, chg_depth_btn,chg_depth_tf);
    

        primaryStage.show();
 
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
