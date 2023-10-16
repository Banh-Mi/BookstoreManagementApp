/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

/**
 *
 * @author BanhMi88
 */
public class SVGImage extends JLabel{
    private FlatSVGIcon svgIcon;
    
    public void setSvgImage(String fileName, int width, int height) {
        svgIcon = new FlatSVGIcon(GetSource.Image(fileName), width, height);
        setIcon(svgIcon);
    }
}
