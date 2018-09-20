package studentdatabaseapp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Samjay
 */
public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses="";
    private int tuitionBalance=0;
    private static int  costOfCourse=600;
    private static int id=1000;
    private int feePaid;
    //constructor:prompts user to enter students name and year
    public Student(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName=scan.next();
        
        System.out.print("Enter student last name: ");
        this.lastName=scan.next();
        
        System.out.print("1 - Freshmen\t2 - Sophmore\t3 - Junior\t4 - Senior\nEnter student class level: ");
        this.gradeYear=scan.nextInt();
     
        if(!(this.gradeYear>=1 && this.gradeYear<=3)){
            System.out.println("Invalid entry");
            return;
        }else{
        setStudentID();
        } 
      
    }
    
    //Generate ID
    private void setStudentID(){
       //  GradeLevel+ID
        id++;
        this.studentID=gradeYear +""+id;
    }
    //get fee paid
    public void setFeePaid(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter fees to pay :");
        this.feePaid=scan.nextInt(); 
    }
    
    //get fee
    public int getFeePaid(){
       return feePaid; 
    }
    //search for course
    public static boolean search(String target) {
        String[] courses={"Math101","English101","Physics101","History101"};
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].equals(target)) {
                return true;
            }
        }
        return false;
    }
    //Enroll in course
    public void enroll(){
         Scanner scan=new Scanner(System.in);
         System.out.println("courses offered:  \1 English101\t\1 Math101\t\1 History101\t\1 Physics101");
         System.out.print("Enter course to enroll to,(Q to Quit): ");
//         String[] coursesEnrolled=new String[3];
        do{
            String course=scan.next();
            
            if(!course.equalsIgnoreCase("Q")){
                if(!search(course)){
                   System.out.print("Invalid entry!Try Again or enter Q to exit: ");
                  }
                else{
                    
                //update courses
                    
                courses +=course+"\t";
           //this i not working
               /* if (courses.equals("")){
                *    courses="No courses Enrolled Yet";
                *}
                */
                //update tutionBalance
                tuitionBalance=tuitionBalance+costOfCourse;
                System.out.print("Next course:( enter Q to exit enrollment): ");
                }
            }
            else{
                break;
            }
        
        }while(1!=0);
      //pay
        payTution(); 
        
    }
    //View balance
    public void viewBalance(){     
        System.out.println("\tFee balance is :$"+tuitionBalance);
    }
    
    //pay tuition
    public void payTution(){
        viewBalance();
        setFeePaid();
       tuitionBalance=tuitionBalance-getFeePaid();
       System.out.println("\tYour payment of $"+getFeePaid()+" has been recieved. Your new Fee Balance is $"+tuitionBalance);
    }
    //show status
    public String showInfo(){
        return "\nName: "+firstName+" "+lastName+" Student ID: "+studentID+" Grade Level: "+gradeYear+"\n"
                + "Courses Enrolled: "+courses+"\nFee Balance: $"+tuitionBalance;
    }
   
    
}
