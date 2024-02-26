/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO code application logic here
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
        coursecatalog.newCourse("Web Development", "info 6105", 4);
        coursecatalog.newCourse("UIUX", "info 6305", 4);
        coursecatalog.newCourse("Cloud Development", "info 7105", 4);
        coursecatalog.newCourse("Linux administration", "info 8105", 4);
        
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer==null)return;
        courseoffer.generatSeats(10);
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("01");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);
        Person p1 = pd.newPerson("Amuthan");
        Person p2 = pd.newPerson("KalBugrara");
        Person p3 = pd.newPerson("Vishalchawla");
        Person p4 = pd.newPerson("we4567io");
        FacultyDirectory fd = department.getFacultydirectory();
        fd.newFacultyProfile(p2);
        fd.newFacultyProfile(p3);
        fd.newFacultyProfile(p1);
        fd.newFacultyProfile(p4);
        

        //

        while (true) {
        System.out.println("Select an option:");
        System.out.println("1. Manage Add Course and browse course Catalog");
        System.out.println("2. Manage the  new semester schedule by adding courses and assigning teachers");
        System.out.println("3. Register Student for a Course");
        System.out.println("4.Display enrolled courses");
        System.out.println("5.Exit");
        System.out.println("Please select an option");
      int option = scanner.nextInt();
       
            
        

        switch(option) {
            case 1:

                System.out.println("press 1 for add course and press 2 for browse course");
                int option1 =scanner.nextInt();
                switch (option1) {
                    case 1:
                        addCourse( coursecatalog, scanner);

                        
                        break;
                    case 2:
                        System.out.println("total no of courses to be added");
                        
                        browseCourse(coursecatalog);

                        break;
                    default:
                        System.out.println("Invalid option selected.");
                        break;
                }




                break;
            case 2:
            CourseSchedule cs=addCourseSchedule(department, coursecatalog);
            courseschedule =cs;
                
                break;
            case 3:
                System.out.println("student registration");
                registerStudentForCourse( scanner, department, courseschedule);
                
                break;
            case 4:
                System.out.println("display enrolled courses");  
                break; 
            case 5:
                System.out.println("display enrolled courses");  
                return;      
            default:
                System.out.println("Invalid option selected.");
        }
    }
    }
    // private static void printCourseOfferDetails() {
    //     System.out.println("Course Number: " + getCourseNumber());
    //     System.out.println("Course Name: " + getCourseName());
    //     System.out.println("Credit Hours: " + getCreditHours());
        
    //     FacultyProfile faculty = getFacultyProfile();
    //     if (faculty != null) {
    //         System.out.println("Faculty Assigned:");
    //         System.out.println("Name: " + faculty.getPerson().getName()); // Assuming Person class has getName() method
    //         // You can print other relevant information about the faculty as well
    //     } else {
    //         System.out.println("Faculty: Not Assigned");
    //     }
        
    //     int totalRevenues = getTotalCourseRevenues();
    //     System.out.println("Total Course Revenues: $" + totalRevenues);
        
    //     System.out.println("Available Seats: " + (seatlist.size() - cl.getRegisteredStudentsCount()));
    //     // Assuming cl.getRegisteredStudentsCount() returns the count of registered students for this course offer
        
    //     System.out.println("--------------");
    // }
    public static void browseCourse(CourseCatalog coursecatalog) {
        // Add logic for handling option 2
        ArrayList<Course> courseList = coursecatalog.getCourseList();
        System.out.println("Available Courses:");
        for (Course course : courseList) {
            System.out.println(course.getCOurseNumber() + "  " + course.getCourseName() +
                    " (" + course.getCredits() + " credits)");
        }

        
    }
    public static void addCourse(CourseCatalog coursecatalog, Scanner scanner) {
        System.out.println("You selected: Add Courses");
        // Add logic for handling option 1
        System.out.println("Enter the course name:");
        String cname = scanner.next();
        System.out.println("Enter the course credits:");
        int credits = scanner.nextInt();
        System.out.println("Enter the course number:");
        String cnumber = scanner.next();
        
        // Create a new course object and add it to the course catalog
        Course newCourse = coursecatalog.newCourse(cname, cnumber, credits);
        System.out.println("Course Added");
    }

    private static CourseSchedule addCourseSchedule(Department dept,CourseCatalog coursecatalog ){
        System.out.println("new Course");
        System.out.println("For which semester do you want to add course schedule");
        Scanner scanner1 = new Scanner(System.in);
        String semName = scanner1.nextLine();
        CourseSchedule courseSchedule = dept.newCourseSchedule(semName);
        do{
            System.out.println("Choose for which course do u want course offer"+ "for "+ semName);
            ArrayList<Course> courseList = dept.getCourseCatalog().getCourseList();
            browseCourse(coursecatalog);
            
            
            // for(int i =0; i< courseList.size(); i++){
            //     System.out.println((i+ 1)+ "."+courseList.get(i));
            // }
            int courseIndex = Integer.parseInt(scanner1.next())-1;
            Course courseSelected = courseList.get(courseIndex);

            CourseOffer courseOffer = courseSchedule.newCourseOffer(courseSelected.getCOurseNumber());

            if(courseOffer.equals(null)){
                System.out.println("Wrong option selected");
                continue;
            }
            System.out.println("Select an option to assign the professor for this course offer");

            ArrayList<FacultyProfile> teacherList = dept.getFacultydirectory().getTeacherlist();
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println((i + 1) + "." + teacherList.get(i).getPerson().getPersonId());
            }
            System.out.println(teacherList.size()+1 + ". Invite/create new teacher ?") ;
            String teacherInput = (new Scanner(System.in)).nextLine();

            FacultyProfile faculty;
            courseOffer.generatSeats(20);

            if(Integer.parseInt(teacherInput)-1 == teacherList.size()){
                System.out.println("Enter name of new faculty");
                String facultyName = (new Scanner(System.in)).nextLine();
                Person newFaculty = dept.getPersonDirectory().newPerson(facultyName);
                dept.getFacultydirectory().newFacultyProfile(newFaculty);
                System.out.println("\n The faculty created" + newFaculty) ;
                System.out.println("Select an option to assign the professor for this course offer");
                for (int i = 0; i < teacherList.size(); i++) {
                    System.out.println((i+1)+"." + teacherList.get(i).getPerson().getPersonId());
                }
                teacherInput = (new Scanner(System.in)).nextLine();

            }
            faculty = dept.getFacultydirectory().getTeacherlist().get(Integer.parseInt(teacherInput)-1);
            courseOffer.AssignAsTeacher(faculty);

            System.out.println("For the"+courseOffer.getCourseName()+"faculty"
            +courseOffer.getFacultyProfile().getPerson()+"is assigned successfully.");
            System.out.println("Do you want to add schedule for more course\n 1.Yes \n 2.No?");
            String isAddMoreOffer = (new Scanner(System.in)).nextLine();
            if(isAddMoreOffer.equals("2")){
                break;
            }

            System.out.println();

    }while(true);
    for (CourseOffer cour : courseSchedule.getSchedule()) {
        System.out.println(cour.getCourseName() + "  "  +
                cour.getFacultyProfile().getPerson().getPersonId() +" " +courseSchedule.getSemester()+ " "+cour.getCourseNumber());

    }   
    return(courseSchedule);

    
}
private static void registerStudentForCourse(Scanner scanner, Department department,CourseSchedule courseSchedule) {
    System.out.print("Enter student ID: ");
    String studentId = scanner.next();
  
    System.out.print("Enter semester (e.g., 'Fall2020'): ");
    String semester = scanner.next();

    ArrayList<CourseOffer> courseList = courseSchedule.getSchedule();
    for (CourseOffer cour : courseList) {
        System.out.println(cour.getCourseName() + "  "  +
                cour.getFacultyProfile().getPerson().getPersonId() + courseSchedule.getSemester() +cour.getCourseNumber());

    }  
    System.out.print("Enter course name (e.g., 'UIUX'): ");
    String courseCode = scanner.next();
   
    // CourseCatalog coursecatalog = department.getCourseSchedule(semester);
    
    // Implementating details for registering a student for a course
    if (studentId!=null){
        
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.findStudent(studentId);
        if (student==null){System.out.println("student is null");}
        // CourseSchedule cs = department.getCourseSchedule(semester);
        //print courseschedul
        // System.out.println(cs);
        // CourseLoad courseLoads = student.getCurrentCourseLoad();
        
        // System.err.println(c
        CourseLoad cl = student.newCourseLoad(semester);
        if(cl==null){System.out.println("Course not found."); return;}
        for (CourseOffer cour : courseList) {
            System.out.println(cour.getCourseName());
            if ( cour.getCourseName().equals(courseCode)){
                
                cl.newSeatAssignment(cour);
                System.out.println("Course Registered Successfully!");
                break;
            }
            else{
                System.out.println("Course Registration Unsuccessful");
            }

        } 
        
    }

    else{  System.out.println("Student not found."); }
        
    }
    



    


        
        // Displaying options

        
        // Reading user input
        // int option = scanner.nextInt();
        
        // // Handling user input
        
        
        // scanner.close();
    }
