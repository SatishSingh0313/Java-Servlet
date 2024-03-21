package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		String email=req.getParameter("em");
		String password=req.getParameter("pw");
		PrintWriter out=resp.getWriter();
//		out.println("<html><body bgcolor='yellow'> <h1> Login Successfully.."+email+" "+password);
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Load And Register");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Establish");
			PreparedStatement pstmt=con.prepareStatement("select * from crudservlet.user where email=? and password=?");
		    System.out.println("Patform Created");
		    pstmt.setString(1, email);
		    pstmt.setString(2, password);
		    
		    ResultSet rs= pstmt.executeQuery();
		    	if( rs.next()) {
		    		out.println("<html><body bgcolor='green'> <h1> Login Successfully.."
		    	+" "+rs.getString(2));
		    		
		    	}
		    	else {
		    		out.println("<html><body bgcolor='red'> <h1> Invalid User.. Check Id & Password");
		    		    		
		    	}
		    
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
