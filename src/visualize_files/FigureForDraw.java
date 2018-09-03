/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualize_files;

import javafx.scene.paint.Color;

/**
 *
 * @author 2oook
 */
public interface FigureForDraw {
    void draw(double x1,double y1,double x2,double y2, Color color, int depth_of_rec, int length_divider, int rad_angle);
}
