package com.jdbc_DAO.Demo;

import java.util.List;

public interface Student_DAO_Interface {
	public void AddStudent(StudentClass insert);
	public void RemoveStudent(int id);
	public void updateStudentDetails(int id,String newName,String newAddress);
	StudentClass getStudent(int id);
	List<StudentClass> getStudentsData();  // Retrieve all students data at same data in the form of List<> datatype.

}
