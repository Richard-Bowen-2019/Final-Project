/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Map;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class TrafficMap {
    ArrayList<Module> map = null;
    int width = 5;
    int height = 3;
    
    private TrafficMap()
    {
        createMap();
        connectMap();       
    }
    
    public ArrayList<Module> getMapInstance()
    {
        if(map==null)
        {
            map = new ArrayList<>();
        }
        return map; 
    }
    
    private void createMap()
    {
        for(int i = 0;i<height;i++)
        {
            for(int j = 0;j<width;j++)
            {
                map.add(new Module(j,i));
            }
        }
    }       
    
    private void connectMap()
    {
        for(
            {
                map.
            }
        }
    }
    
    public Module getModule(int x, int y)
    {
        Module module = null;        
        for(Module m: map)
        {
            if(m.getx()==x&&m.gety()==y)
            {
                module = m;        
            }
        }
        return module;
    }
        
}
