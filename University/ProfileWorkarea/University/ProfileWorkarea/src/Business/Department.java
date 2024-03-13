/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Course.Course;
import Business.Course.CourseCatalog;
import Business.Course.CourseLoad;
import Business.Course.CourseOffer;
import Business.Course.CourseSchedule;
import Business.Degree.Degree;
//import info5100.university.example.Degree.Degree;
import Business.Profiles.FacultyProfile;
import Business.Profiles.FacultyDirectory;
import Business.Person.PersonDirectory;
import Business.Profiles.AdminDirectory;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccountDirectory;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {
    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    UserAccountDirectory useraccountdirectory;

    public UserAccountDirectory getUseraccountdirectory() {
        return useraccountdirectory;
    }

    public void setUseraccountdirectory(UserAccountDirectory useraccountdirectory) {
        this.useraccountdirectory = useraccountdirectory;
    }
    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    FacultyDirectory facultydirectory;
   StudentDirectory studentdirectory;
   AdminDirectory admindirectory;

    public AdminDirectory getAdmindirectory() {
        return admindirectory;
    }
    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }
    Degree degree;

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<>();
        coursecatalog = new CourseCatalog(this);
       studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        useraccountdirectory= new UserAccountDirectory(this);
        facultydirectory = new FacultyDirectory(this);
        admindirectory= new AdminDirectory(this);
        degree = new Degree("MSIS");
        
                
                
//                
    }
    public void addCoreCourse(Course c){
        degree.addCoreCourse(c);
        
    }
public void addElectiveCourse(Course c){
        degree.addElectiveCourse(c);
        
    }
    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

   

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }



}
