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
public class ViewH {
    private ArrayList<Hw> homeaddress;
    public ViewH(){
        this.homeaddress = new ArrayList<>();
    }

    public ArrayList<Hw> getH() {
        return homeaddress;
    }

    public void setH(ArrayList<Hw> deets) {
        this.homeaddress = deets;
    }
    public Hw addNewH(){
        Hw newdeets = new Hw();
        homeaddress.add(newdeets);
        return newdeets;
        
    }
    public void deleteH(Hw d){
        homeaddress.remove(d);
    }
    
}
