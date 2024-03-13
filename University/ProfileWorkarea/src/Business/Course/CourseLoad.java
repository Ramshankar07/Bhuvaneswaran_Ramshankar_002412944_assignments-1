/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Course;


import java.util.ArrayList;
import Business.Profiles.StudentProfile;

// import info5100.university.example.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    StudentProfile studentProfile;
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }
    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
    public String getSemester() {
        return semester;
    }
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null){ System.out.println("Seats not available.");
        return null;}
        SeatAssignment sa = seat.newSeatAssignment(this);
        
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){ 

        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public float getSemesterScore(){ //total score for a full semeter
        float sum = 0;
        for (SeatAssignment sa: seatassignments){
            sum = sum + sa.GetCourseStudentScore();
        }
        return sum;
    }
        public ArrayList<SeatAssignment> getSeatAssignments(){
            return seatassignments;
        }
    //create a function that returns studentprofile
    



}
