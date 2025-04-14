package com.jdbc_DAO.Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class Student_DAO_Interface_Implementation implements Student_DAO_Interface{
	public void AddStudent(StudentClass insert ){
		try {
			Connection con=DBConnection.getConnection();
			// Check if the ID is existed previously (or) If ID is not there then we need to enter new data.
			String checkQuery="Select * from StudentManagementSystem where ID=?";
			PreparedStatement Check_Pstmt=con.prepareStatement(checkQuery);
			Check_Pstmt.setInt(1, insert.getID());
			ResultSet rs=Check_Pstmt.executeQuery();
			
			if(rs.next()) {
	            System.out.println("⚠️ Student with ID " + insert.getID() + " already exists.");
			}else {
				String query="Insert into StudentManagementSystem(ID,name,Address) values (?,?,?)";
				PreparedStatement Insert_Pstmt=con.prepareStatement(query);		
				Insert_Pstmt.setInt(1, insert.getID());
				Insert_Pstmt.setString(2, insert.getName());
				Insert_Pstmt.setString(3, insert.getAddress());
				int count= Insert_Pstmt.executeUpdate();
				System.out.println("New Data inserted Successfully !" + insert.getID());
				System.out.println("Total number of rows inserted are : "+count);
				Insert_Pstmt.close();
			}
			rs.close();
			Check_Pstmt.close();
			con.close();
			
		}
		catch (Exception e) {
			System.out.println("");
			System.out.println("An error occured ! : "+ e);
		}
				
	}

	@Override
	public void RemoveStudent(int id) {
		try {
			Connection conn=DBConnection.getConnection();
			String rm_query="Delete from StudentManagementSystem where ID=?";
			PreparedStatement rm_stmt=conn.prepareStatement(rm_query);
			rm_stmt.setInt(1,id);
			int count=rm_stmt.executeUpdate();
			if(count>0) {
			System.out.println("Student ID  "+ id +" is removed from table");
			}else {
				System.out.println("No data found with this ID ::  "+id);
			}
			rm_stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error occured while removing data => "+e);
		}
	}

	@Override
	public void updateStudentDetails(int id,String newName,String newAddress) {
		try {
			Connection update_emp=DBConnection.getConnection();
			String query="Update StudentManagementSystem set name=?, Address=? where ID=?";
			PreparedStatement update_stmt=update_emp.prepareStatement(query);
			update_stmt.setString(1, newName);
			update_stmt.setString(2, newAddress);
			update_stmt.setInt(3,id);
			int count=update_stmt.executeUpdate();
			if(count >0) {
				System.out.println("Employee Details updated succcessfully");
			}else {
				System.out.println("No employee found with this ID. ");
			}
			
			update_stmt.close();
			update_emp.close();
		} catch (Exception e) {
			System.out.println("An error occured while updating data : "+e);
		}
	}

	@Override
	public StudentClass getStudent(int id) {
		try {
		Connection Single_Data=DBConnection.getConnection();
		String query="select * from StudentManagementSystem where ID=?";
		PreparedStatement pstmt=Single_Data.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("Stud ID is : "+rs.getInt("id") + " . Stud Name is : "+rs.getString("name") + " .Stud Address is : "+ rs.getString("Address"));
		}
		rs.close();
		pstmt.close();
		Single_Data.close();
		}catch (Exception e) {
			System.out.println("An error occured while retrieving single Row Data : "+e);
		}
		return null;
	}

	@Override
	public List<StudentClass> getStudentsData() {
		List<StudentClass> list=new ArrayList<StudentClass>();
		try {
		Connection con=DBConnection.getConnection();
		String query="select * from StudentManagementSystem";
		PreparedStatement pstmt=con.prepareStatement(query);
		ResultSet rs=pstmt.executeQuery();
		int count=0;
		while(rs.next()) {
			list.add(new StudentClass(rs.getInt("ID"), rs.getString("name"), rs.getString("Address")));
			count++;
		}
		System.out.println("Total number of rows retrieved are : "+count);
		rs.close();
		pstmt.close();
		con.close();
		}catch (Exception e) {
			System.out.println("An error Occured : "+e);
		}
		return list;
	}
	
	

}
