/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Richard
 */
public class GUIDimensions {
    
    static final int horizontalModules = 5;

   
    static final int verticalModules = 3;
    
    private GUIDimensions()
    {
    
    }
    
    public static Dimension getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }
    
     public static int getHorizontalModules() {
        return horizontalModules;
    }

    public static int getVerticalModules() {
        return verticalModules;
    }
    
    public static int getModuleWidths() {
        return getScreenSize().width/getHorizontalModules();
    }
    
     public static int getModuleHeights() {
        return getScreenSize().height/getVerticalModules();
    }

}
