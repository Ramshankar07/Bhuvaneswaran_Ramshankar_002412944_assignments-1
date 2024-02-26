/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// import info5100.university.example.Campus.Seat;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.Seat;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.Persona.Transcript;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        Course course = coursecatalog.newCourse("app eng", "info5100", 4);
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        // CourseOffer courseoffer = courseschedule.newCourseOffer("info5100");
        // System.out.println(courseoffer.);
        // if (courseoffer==null){return;}
        // courseoffer.generatSeats(10);
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("01");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        // CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        // courseload.newSeatAssignment(courseoffer); 
        //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);
        Person p1 = pd.newPerson("Amuthan");
        Person p2 = pd.newPerson("KalBugrara");
        Person p3 = pd.newPerson("Vishalchawla");
        Person p4 = pd.newPerson("Nik Brown");
        FacultyDirectory fd = department.getFacultydirectory();
        fd.newFacultyProfile(p2);
        fd.newFacultyProfile(p3);
        fd.newFacultyProfile(p1);
        fd.newFacultyProfile(p4);
        // CourseOffer courseOffer = courseschedule.newCourseOffer("info5100");
        // courseOffer.AssignAsTeacher(fd.getTeacherlist());
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
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
                    // Add Course Offer
                    addCourseSchedule(department, coursecatalog,scanner);
                    break;
                case 3:
                    // Assign Teacher
                    break;
                case 4:
                    // Register Student for Course
                    registerStudentForCourse(scanner, department,coursecatalog);
                    break;
                case 5:
                    displayRegisteredCourses(scanner,department,coursecatalog);
                    break;
                case 6:
                printSemesterCourseReport(scanner, department);   
                return;
                    case 7:
                    System.out.println("Exiting...");
                    return;
                    case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        
        
        

    }
    public static void browseCourse(CourseCatalog coursecatalog) {
        // Add logic for handling option 2
        ArrayList<Course> courseList = coursecatalog.getCourseList();
        System.out.println("Available Courses:");
        for (Course course : courseList) {
            System.out.println(course.getCOurseNumber() + "  " + course.getCourseName() +
                    " (" + course.getCredits() + " credits)");}
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
        coursecatalog.newCourse(cname, cnumber, credits);
        System.out.println("Course Added");
    }

    private static void addCourseSchedule(Department dept,CourseCatalog coursecatalog,Scanner scanner){
        System.out.println("new Course");
        System.out.println("Enter the Semester name");
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

            
            if(courseOffer == null){
                System.out.println("Didn't Select any option");
                continue;
            }
            System.out.println("Select an option to assign  professor for this course offer");

            ArrayList<FacultyProfile> teacherList = dept.getFacultydirectory().getTeacherlist();
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.println((i + 1) + "." + teacherList.get(i).getPerson().getPersonId());
            }
            System.out.println(teacherList.size()+1 + ". Invite/create new teacher ?") ;
            String teacherInput = (new Scanner(System.in)).nextLine();

            FacultyProfile faculty;

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

    }while(true);
}
    private static void displayMenu() {
        System.out.println("\nCourse Management System");
        System.out.println("-------------------------------------------");
        System.out.println("1. Course Schedule Section");
        System.out.println("2. Add Course Offer to a Semester");
        System.out.println("3. Assign Teacher to a Course Offer");
        System.out.println("4. Register Student for a Course");
        System.out.println("5. Display enrolled courses");
        System.out.println("6. dSemester Course Report ");
        System.out.println("6. exit");
        System.out.println("8. exit");

        System.out.println("-------------------------------------------");
        System.out.print("Select an option --> : ");
    }
    private static void registerStudentForCourse(Scanner scanner, Department department, CourseCatalog coursecatalog) {
    System.out.print("Enter student ID: ");
    String studentId = scanner.next();
    System.out.print("Enter semester (e.g., 'Fall2020'): ");
    String semester = scanner.next();
    ArrayList<Course> courseList = coursecatalog.getCourseList();
    for(Course course : courseList) {
        System.out.println(course.getCOurseNumber()); 
    }
    System.out.print("Enter course code (e.g., 'info5100'): ");
    String courseCode = scanner.next();
    
    // CourseCatalog coursecatalog = department.getCourseSchedule(semester);
    
    // Implementating details for registering a student for a course
    if (studentId!=null){
        
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.findStudent(studentId);
        CourseSchedule cs = department.getCourseSchedule(semester);
        //print courseschedul
        System.out.println(cs);
        // CourseLoad courseLoads = student.getCurrentCourseLoad();
        
        // System.err.println(c
        CourseOffer co = cs.getCourseOfferByNumber(courseCode);
        if(co==null){System.out.println("Course not found."); return;}
        else{
       
            CourseLoad cl = student.newCourseLoad(semester);
            
            if(cl!=null){
                
                cl.newSeatAssignment(co);
            }
            else{
                 
                System.out.println("cl is null");
            // courseLoads.registerStudent(cl.newSeatAssignment(co));
            }
        System.out.println("Course Registered Successfully!");
    

    }
    }

    else{  System.out.println("Student not found."); }
        
    }
private static void displayRegisteredCourses(Scanner scanner, Department department,CourseCatalog coursecatalog) {
    System.out.print("Enter student ID: ");
    String studentId = scanner.next();
    System.out.print("Enter semester (e.g., 'Fall2020'): ");
    String semester = scanner.next();
    
    if (studentId == null) {
        System.out.println("Invalid student profile.");
        return;
    }
    else{
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.findStudent(studentId);

        // CourseSchedule cs = department.getCourseSchedule(semester);
  
    // Assuming the StudentProfile class has a method to get all semesters with course loads
     CourseLoad courseLoads = student.getCurrentCourseLoad();
        if (courseLoads == null) {
        System.out.println("No courses registered.");
        return;
        }

    System.out.println("Registered Courses for semester: " + courseLoads.getSemester());
    ArrayList<SeatAssignment> seatAssignments = courseLoads.getSeatAssignments();

    if (seatAssignments.isEmpty()) {
        System.out.println("No courses registered for this semester.");
    } else {
        for (SeatAssignment sa : seatAssignments) {
            CourseOffer co = sa.getCourseOffer(); 
            System.out.println(" - " + co.getCourseNumber() );
        }
    }}
}
public static void printSemesterCourseReport(Scanner scanner, Department department) {
    System.out.print("Enter the semester for the report: ");
    String semester = scanner.next();
    CourseSchedule cs = department.getCourseSchedule(semester);

    if (cs == null) {
        System.out.println("Semester not found.");
        return;
    }

    System.out.println("Course Report for " + semester);
    ArrayList<CourseOffer> courseOffers = cs.getSchedule();
    for (CourseOffer co : courseOffers) {
        System.out.println("Course: " + co.getCourseNumber() + " - " + co.getSubjectCourse());
        System.out.println("Teacher: " + (co.getFacultyProfile() != null ? co.getFacultyProfile().getPerson().getPersonId() : "No teacher assigned"));

        ArrayList<Seat> seatList = co.getSeatlist();

        if (seatList.isEmpty()) {
            System.out.println("No students enrolled.");
            continue;
        }

        for (Seat seat : seatList) {
            if (seat.isOccupied()) {
                SeatAssignment sa = seat.getSeatassignment();
                CourseLoad courseLoad = sa.getCourseload();
                StudentProfile student = courseLoad.getStudentProfile(); // Assuming you've added getStudentProfile()
                // Now you have the StudentProfile, you can print it out or add it to a list
                System.out.println("Student: " + student.getPerson().getPersonId()); // Assuming getName() gets the student's name
            }
        }

        // Calculating average GPA and total tuition for the course - this would require additional methods or calculations
        // Assuming methods exist to calculate GPA and tuition based on SeatAssignments
    }

    // The total revenue part seems to be correctly implemented in your given method
    System.out.println("Total Revenue: " + cs.calculateTotalRevenues());
}

}    

    


