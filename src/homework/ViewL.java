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
    private ArrayList<Hw> localaddress;
    public ViewL(){
        this.localaddress = new ArrayList<>();
    }

    public ArrayList<Hw> getL() {
        return localaddress;
    }

    public void setL(ArrayList<Hw> deets) {
        this.localaddress = deets;
    }
    public Hw addNewL(){
        Hw newdeets = new Hw();
        localaddress.add(newdeets);
        return newdeets;
        
    }
    public void deleteL(Hw d){
        localaddress.remove(d);
    }
    
}
