/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author 2oook
 */
public interface FigureForDraw {
    void draw(GraphicsContext gc,double x1,double y1,double x2,double y2);
}
