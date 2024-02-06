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
public class ViewL {
    private ArrayList<allPerson> localaddress;
    public ViewL(){
        this.localaddress = new ArrayList<>();
    }

    public ArrayList<allPerson> getL() {
        return localaddress;
    }

    public void setL(ArrayList<allPerson> deets) {
        this.localaddress = deets;
    }
    public allPerson addNewL(){
        allPerson newdeets = new allPerson();
        localaddress.add(newdeets);
        return newdeets;
        
    }
    public void deleteL(allPerson d){
        localaddress.remove(d);
    }
    
}
