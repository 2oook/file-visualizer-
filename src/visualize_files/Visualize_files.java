/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;


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
import javafx.stage.Stage;


public class Visualize_files extends Application 
{
    static GraphicsContext gc;
    double canvas_w = 500;
    double canvas_h = 500;
    int i = 0;
    
    @Override
    public synchronized void start(Stage primaryStage) {
        
        Button btn = new Button();//кнопка выбора файла
        btn.setText("Choose file");
        
        Button clear_btn = new Button();//кнопка очистки экрана
        clear_btn.setText("Clear plate");
        
        /*
        Button chg_depth_btn = new Button();
        chg_depth_btn.setText("Set depth");
        
        TextField chg_depth_tf = new TextField();
        */
        
        
        
        /*chg_depth_btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                    
                int p = Integer.parseInt(chg_depth_tf.getText());

                System.out.println(chg_depth_tf.getText() + " ");

                DrawSmth.change_depth(p);
 
                
            }
        });
        */
        
        clear_btn.setOnAction(new EventHandler<ActionEvent>() //обработчик очистки экрана
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                gc.clearRect(0,0, canvas_w,canvas_h);             
                
                System.out.println("In handle of clear button");
            
            }
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() //обработчик выбора файла
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                Monitor monitor = new Monitor();
                
                Interpreter interpreter = new Interpreter(monitor);
        
                FileChooseHandler fch = new FileChooseHandler(monitor);

            }
        });
        
        
        FlowPane root = new FlowPane(10,10);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 500, 600);
        
        primaryStage.setTitle("Visualize your file");
        primaryStage.setScene(scene);
        
        
        
        Canvas vizual_canvas = new Canvas (canvas_w, canvas_h);
        
        gc = vizual_canvas.getGraphicsContext2D();
        //gc.setLineWidth(1);
        
       
        
        /*
        vizual_canvas.setOnScroll(new EventHandler() 
        {       
            @Override
            public void handle(Event event) 
            {    

            }
        });
        */

        
        root.getChildren().addAll(vizual_canvas, btn, clear_btn/*, chg_depth_btn,chg_depth_tf*/);
    

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
