/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.ArrayList;

/**
 *
 * @author Ram
 */
public class Persondirectory {

    public static void setFirstName(String Fn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private ArrayList<Person> Personlist; 
//    Address address =new Address();
    public ArrayList<Person> getPersonlist() {
        return Personlist;
    }

    public void setPersonlist(ArrayList<Person> Personlist) {
        this.Personlist = Personlist;
    }

    public Persondirectory() {
        this.Personlist = new ArrayList<>();
        
    }
    
    public Person addPerson(){
       Person p =new Person();
       Personlist.add(p);
       return p;
    }
    public void deletePerson(Person P){
        Personlist.remove(P);
    }
    public Boolean searchPerson(String P){
        for (Person p: Personlist){
            if (p.getFirstName().equalsIgnoreCase(P)|| p.getLastName().equalsIgnoreCase(P) || p.getHomeaddress().getStreetName().equalsIgnoreCase(P)|| p.getWorkaddress().getStreetName().equalsIgnoreCase(P)){
                return true;
            }
        }
        return false;
    }
   
    public Person searchgetPerson(String P){
        for (Person p: Personlist){
            if (p.getFirstName().equalsIgnoreCase(P)|| p.getLastName().equalsIgnoreCase(P)|| p.getHomeaddress().getStreetName().equalsIgnoreCase(P)|| p.getWorkaddress().getStreetName().equalsIgnoreCase(P)){
                return p;
            }
        }
        return null;
    }

//    public boolean searchPerson(Person result) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
