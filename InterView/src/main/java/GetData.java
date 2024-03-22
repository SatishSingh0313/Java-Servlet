

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetData() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssproject","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from user");
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<table border='3px'>");
				out.println("<tr>");
					out.println("<th>");
						out.println("Name");
					out.println("</th>");
					
					out.println("<th>");
						out.println("City");
					out.println("</th>");
					
					out.println("<th>");
						out.println("Email");
					out.println("</th>");
					
					out.println("<th>");
						out.println("Mobile");
					out.println("</th>");
					
				out.println("</tr>");
				
				
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>");
						out.println(rs.getString(1));
					out.println("</td>");
					
					out.println("<td>");
						out.println(rs.getString(2));
					out.println("</td>");
					
					out.println("<td>");
						out.println(rs.getString(3));
					out.println("</td>");
					
					out.println("<td>");
						out.println(rs.getString(4));
					out.println("</td>");
					
				out.println("</tr>");
				}
				out.println("</table>");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
