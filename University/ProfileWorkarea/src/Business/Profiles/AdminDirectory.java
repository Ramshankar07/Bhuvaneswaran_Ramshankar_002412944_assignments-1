/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

//import Business.Business;
import Business.Department;
import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class AdminDirectory {

    Department business;
    ArrayList<AdminProfile> employeelist;

    public AdminDirectory(Department d) {

        business = d;
        employeelist = new ArrayList();

    }

    public AdminProfile newEmployeeProfile(Person p) {

        AdminProfile sp = new AdminProfile(p);
        employeelist.add(sp);
        return sp;
    }

    public AdminProfile findEmployee(String id) {

        for (AdminProfile sp : employeelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
