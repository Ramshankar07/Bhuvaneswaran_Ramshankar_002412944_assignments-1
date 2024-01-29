/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework;

import java.util.ArrayList;

/**
 *
 * @author Ram
 */
public class ViewB {
    private ArrayList<Hw> deets;
    public ViewB(){
        this.deets = new ArrayList<>();
    }

    public ArrayList<Hw> getB() {
        return deets;
    }

    public void setB(ArrayList<Hw> deets) {
        this.deets = deets;
    }
    public Hw addNewB(){
        Hw newdeets = new Hw();
        deets.add(newdeets);
        return newdeets;
        
    }
    public void deleteB(Hw d){
        deets.remove(d);
    }
    
}
