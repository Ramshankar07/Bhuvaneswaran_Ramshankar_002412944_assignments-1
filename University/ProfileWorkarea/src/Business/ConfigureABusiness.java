/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.Course.CourseCatalog;
import Business.Course.CourseOffer;
import Business.Course.CourseSchedule;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.AdminDirectory;
import Business.Profiles.AdminProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentProfile;
import Business.Profiles.StudentDirectory;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Department initialize() {
        Department d = new Department("Information Systems");
        CourseCatalog coursecatalog = d.getCourseCatalog();
        coursecatalog.newCourse("appeng", "info 5100", 4);
        coursecatalog.newCourse("Cloud", "info 7105", 4);
        coursecatalog.newCourse("Linux", "info 8105", 4);
        coursecatalog.newCourse("Web", "info 6105", 4);
        coursecatalog.newCourse("UIUX", "info 6305", 4);
        CourseSchedule courseschedule = d.newCourseSchedule("Fall2023");
        CourseSchedule courseschedule1 = d.newCourseSchedule("Spring2023");
        CourseSchedule courseschedule3 = d.newCourseSchedule("Fall2024");
        CourseSchedule courseschedule4 = d.newCourseSchedule("Spring2024");
        CourseSchedule courseschedule5 = d.newCourseSchedule("Spring2025");
        CourseSchedule courseschedule2 = d.newCourseSchedule("Fall2025");
        CourseOffer c1= courseschedule.newCourseOffer("info 5100");
        CourseOffer c2= courseschedule.newCourseOffer("info 7105");
        CourseOffer c3= courseschedule1.newCourseOffer("info 8105");
        CourseOffer c4= courseschedule1.newCourseOffer("info 6105");
        c1.generatSeats(20);
        c2.generatSeats(20);
        c3.generatSeats(20);
        c4.generatSeats(20);
        

        



        
        
        
// Create Persons
      PersonDirectory persondirectory = d.getPersonDirectory();
// person representing sales organization        
        Person Admin = persondirectory.newPerson("Admin");
        
        Person Dean = persondirectory.newPerson("Dean");
        Person Sec = persondirectory.newPerson("Secratary");
    
// Create person objects to represent customer organizations. 
        Person f1 = persondirectory.newPerson("Kal");
        Person f2 = persondirectory.newPerson("Nick");
        Person f3 = persondirectory.newPerson("Sam");
        Person f4 = persondirectory.newPerson("Zack");
        Person f5 = persondirectory.newPerson("Gail"); //we use this as customer
        Person s1 = persondirectory.newPerson("Jim");
        Person s2 = persondirectory.newPerson("Sophie");
        Person s3 = persondirectory.newPerson("Anastasia");
        Person s5 = persondirectory.newPerson("Ram");
        Person s4 = persondirectory.newPerson("Rex");
        
        
        
    
// Create Admins to manage the business
        AdminDirectory ad = d.getAdmindirectory();
        AdminProfile emp0 = ad.newEmployeeProfile(Admin);
        AdminProfile emp1 = ad.newEmployeeProfile(Sec);
        AdminProfile emp2 = ad.newEmployeeProfile(Dean);

        FacultyDirectory employeedirectory = d.getFacultydirectory();

        FacultyProfile emp3 = employeedirectory.newEmployeeProfile(f1);
        FacultyProfile emp4 = employeedirectory.newEmployeeProfile(f3);
        FacultyProfile emp5 = employeedirectory.newEmployeeProfile(f2);
        FacultyProfile emp6 = employeedirectory.newEmployeeProfile(f4);
        FacultyProfile emp7 = employeedirectory.newEmployeeProfile(f5);
        
        StudentDirectory sd = d.getStudentdirectory();
        StudentProfile st1= sd.newStudentProfile(s1);
        StudentProfile st2= sd.newStudentProfile(s2);
        StudentProfile st3= sd.newStudentProfile(s3);
        StudentProfile st4= sd.newStudentProfile(s4);
        
   
// Create User accounts that link to specific profiles

        UserAccountDirectory uadirectory = d.getUseraccountdirectory();
        UserAccount ua3 = uadirectory.newUserAccount(emp0, "admin", "XXXX"); /// order products for one of the customers and performed by a sales person
        UserAccount ua1 = uadirectory.newUserAccount(emp1, "Sec", "Sec");
        UserAccount ua2 = uadirectory.newUserAccount(emp2, "Dean", "Dean");
        UserAccount ua4 = uadirectory.newUserAccount(emp3, "Kal", "Kal");
        UserAccount ua5 = uadirectory.newUserAccount(emp4, "Nick", "Nick"); /// order products for one of the customers and performed by a sales person
        UserAccount ua6 = uadirectory.newUserAccount(emp5, "Sam", "Sam");
        UserAccount ua7 = uadirectory.newUserAccount(emp6, "Zack", "Zack");
        UserAccount ua8 = uadirectory.newUserAccount(emp7, "Gail", "Gail");
        UserAccount ua9= uadirectory.newUserAccount(st1, "Jim", "Jim");
        UserAccount ua10= uadirectory.newUserAccount(st2, "Sophie", "Sophie");
        
        
        c1.AssignAsTeacher(emp3);
        c2.AssignAsTeacher(emp7);
        c3.AssignAsTeacher(emp5);
        c4.AssignAsTeacher(emp4);
        return d;

    }

}
