/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject.Model.Vehicles;

import FinalProject.Model.Map.Road;
import FinalProject.Model.Map.Intersection;
import FinalProject.Model.Map.IntersectionVertex;

/**
 *
 * @author Richard
 */
public class Van extends Vehicle{

    public Van(Intersection module,IntersectionVertex model, Road edge) 
    {
        super(module,model,edge);
        this.Size = 2;
    }
    
}
