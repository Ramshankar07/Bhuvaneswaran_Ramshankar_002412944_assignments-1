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
    private ArrayList<allPerson> homeaddress;
    public ViewH(){
        this.homeaddress = new ArrayList<>();
    }

    public ArrayList<allPerson> getH() {
        return homeaddress;
    }

    public void setH(ArrayList<allPerson> deets) {
        this.homeaddress = deets;
    }
    public allPerson addNewH(){
        allPerson newdeets = new allPerson();
        homeaddress.add(newdeets);
        return newdeets;
        
    }
    public void deleteH(allPerson d){
        
    }

    public void deleteH(ViewH s) {
        homeaddress.remove(s);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
