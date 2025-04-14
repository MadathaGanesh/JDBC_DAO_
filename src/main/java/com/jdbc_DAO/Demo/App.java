package com.jdbc_DAO.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student Management System using JDBC with DAO Pattern
/*
 Build a simple console-based Java application to manage student records using JDBC. 
 Apply the DAO design pattern to cleanly separate the database logic from business logic.

🔧 Functional Requirements:
Add a student
User provides student ID, name, and age.:
Data should be inserted into the database.

Update a student: Given a student ID, update the name or age.

Delete a student: Delete student record using student ID.

Fetch a student by ID: Get and display a single student’s details.

Fetch all students:  Retrieve and display a list of all students.


 * */


public class App
{
    public static void main( String[] args )
    {

    	Student_DAO_Interface_Implementation obj=new Student_DAO_Interface_Implementation();  
    	Scanner sc=new Scanner(System.in);
    	int choice;
    	   	
         do {
        	 System.out.println("\n===== Student Management System =====");
             System.out.println("1. Add Student");
             System.out.println("2. Delete Student");
             System.out.println("3. Update Student");
             System.out.println("4. Get Single Student");
             System.out.println("5. Get All Students");
             System.out.println("6. Exit");
             System.out.print("Enter your choice: ");
             choice = sc.nextInt();
             sc.nextLine(); // consume newline
         switch (choice) {
		 case 1:
			System.out.println("Enter Student ID : ");
			int AddID=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student Name : ");
			String AddName=sc.nextLine();
			System.out.println("Enter Student Address : ");
			String AddAddress=sc.nextLine();
			obj.AddStudent(new StudentClass(AddID,AddName,AddAddress));
			break;
		
		case 2:
			System.out.println("Enter the StudID to delete : ");
			int delStud=sc.nextInt();
			obj.RemoveStudent(delStud);
			break;
			
		case 3:
			System.out.println("Enter the StudID to Update Detail");
			int StudID=sc.nextInt();
			System.out.println("Enter New Student Name : ");
			String newName=sc.nextLine();
			System.out.println("Enter New Address of  Student : ");
			String newAddress=sc.nextLine();
			obj.updateStudentDetails(StudID, newName, newAddress);
			break;
			
		case 4:
			System.out.println("Enter StudentID to retrieve data : ");
			int studId=sc.nextInt();
			StudentClass id= obj.getStudent(studId);
			if (id!=null) {
				System.out.println("Stud ID is : "+id.getID() + " .Student Name is : "+id.getName() + " . Student Address is : "+id.getAddress());
			}
			break;
			
		case 5:
			System.out.println("You are seeing all students details now : ");
			List<StudentClass> AllStudentsData=new ArrayList<StudentClass>();
			AllStudentsData= obj.getStudentsData();
			for(StudentClass s:AllStudentsData) {
				System.out.println(" StudID is : "+s.getID() + " . Stud Name is : "+s.getName() + " .Student Address is : "+s.getAddress());
			}
		case 6:
            System.out.println("Exiting Student Management System. Goodbye!");
            break;
	
		default:
			System.out.println("Enter correct choice ");
			break;
         }
         } while(choice !=6);
      
    }
}



