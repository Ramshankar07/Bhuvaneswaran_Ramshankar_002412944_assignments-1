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
    private ArrayList<allPerson> deets;
    public ViewB(){
        this.deets = new ArrayList<>();
    }

    public ArrayList<allPerson> getB() {
        return deets;
    }

    public void setB(ArrayList<allPerson> deets) {
        this.deets = deets;
    }
    public allPerson addNewB(){
        allPerson newdeets = new allPerson();
        deets.add(newdeets);
        return newdeets;
        
    }
    public void deleteB(allPerson d){
        deets.remove(d);
    }
    
}
