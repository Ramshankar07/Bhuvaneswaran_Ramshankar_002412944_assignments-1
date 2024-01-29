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
public class ViewP {
    private ArrayList<Hw> person;
    public ViewP(){
        this.person = new ArrayList<Hw>();
    }

    public ArrayList<Hw> getP() {
        return person;
    }

    public void setP(ArrayList<Hw> deets) {
        this.person = deets;
    }
    public Hw addNewP(){
        Hw newdeets = new Hw();
        person.add(newdeets);
        return newdeets;
        
    }
    public void deleteP(Hw d){
        person.remove(d);
    }
    
}
