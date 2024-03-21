package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 String Uid=req.getParameter("id");
		 String firstName=req.getParameter("fnm");
		 String lastName=req.getParameter("lnm");
		 String email=req.getParameter("em");
		 String phno=req.getParameter("ph");
		 String add=req.getParameter("add");
		 String pass=req.getParameter("pw");
		
		 PrintWriter out=resp.getWriter();
		 out.println("<html><body bgcolor='blue'> Data Recorded "+Uid+" "+firstName+" "+lastName+" "+email+" "+phno+" "+ add);
		 out.flush();
		 
		 try {
			getClass().forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement("insert  into crudservlet.user values(?,?,?,?,?,?,?)");
			pstmt.setString(1, Uid);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, email);
			pstmt.setString(5, phno);
			pstmt.setString(6, add);
			pstmt.setString(7, pass);
			pstmt.execute();
		 } 
		 catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	 }
 }
