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
public class FacultyDirectory {

    Department business;
    ArrayList<FacultyProfile> employeelist;

    public ArrayList<FacultyProfile> getEmployeelist() {
        return employeelist;
    }

    public FacultyDirectory(Department d) {

        business = d;
        employeelist = new ArrayList();

    }

    public FacultyProfile newEmployeeProfile(Person p) {

        FacultyProfile sp = new FacultyProfile(p);
        employeelist.add(sp);
        return sp;
    }

    public FacultyProfile findEmployee(String id) {

        for (FacultyProfile sp : employeelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
