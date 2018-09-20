package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {
 
    public static void main(String[] args) { 
        //Ask how many Students we want to add
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter number of new Students to enroll:");
            int numOfNewStudents=scan.nextInt();
            Student[] students=new Student[numOfNewStudents];
            for(int i=0;i<numOfNewStudents;i++){
                students[i]=new Student();
                students[i].enroll();
                
            }
             //StudentInfo Header
           System.out.println("\n\t\tStudent Info");
           
            for(int i=0;i<numOfNewStudents;i++){
               System.out.println(students[i].showInfo());   
            }
                
        //create a number of new students
        
    }
    
}
