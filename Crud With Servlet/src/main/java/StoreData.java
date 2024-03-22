

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StoreData")
public class StoreData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StoreData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("get");
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String city=request.getParameter("city");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile");
	
	System.out.println(name);
	System.out.println(city);
	System.out.println(email);
	System.out.println(mobile);
	
	
	 PrintWriter out=response.getWriter();
	 out.println("<html><body bgcolor='blue'> Data Stored "+name+" "+city+" "+email+" "+mobile);
	 out.flush();
	 
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssproject","root","root");
		
		Statement stmt =con.createStatement();
		stmt.executeUpdate("insert into user values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	 }

}
