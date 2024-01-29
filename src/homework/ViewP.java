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
    private ArrayList<allPerson> person;
    public ViewP(){
        this.person = new ArrayList<>();
    }

    public ArrayList<allPerson> getP() {
        return person;
    }

    public void setP(ArrayList<allPerson> person) {
        this.person = person;
    }
    public allPerson addNewP(){
        allPerson newdeets = new allPerson();
        person.add(newdeets);
        return newdeets;
        
    }
    public void deleteP(allPerson d){
        person.remove(d);
    }
    
}
