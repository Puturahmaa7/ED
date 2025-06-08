
package edu;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;

public class SVGIcon extends JLabel{
    
    private FlatSVGIcon svgIcon;
    
    public void setSVGIcon(String image, int width, int height){
        svgIcon = new FlatSVGIcon(image,width, height);
        setIcon(svgIcon);
    }
}
