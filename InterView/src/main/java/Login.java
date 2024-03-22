

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


@WebServlet("/Login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		 PrintWriter out=response.getWriter();
//		 out.println("<a href=\"Userhome.html\">Go to Home Page</a>");
		 out.println("<!DOCTYPE html>\r\n"
		 		+ "<html lang=\"en\">\r\n"
		 		+ "\r\n"
		 		+ "<head>\r\n"
		 		+ " \r\n"
		 		+ "  <title>www.myworld.com</title>\r\n"
		 		+ "  <style>\r\n"
		 		+ "    body {\r\n"
		 		+ "      background-color: rgb(155, 82, 82);\r\n"
		 		+ "      background-repeat: no-repeat;\r\n"
		 		+ "      background-attachment: fixed;\r\n"
		 		+ "      background-size: 100% 100%;\r\n"
		 		+ "    }\r\n"
		 		+ "\r\n"
		 		+ "    h1 {\r\n"
		 		+ "      color: rgb(166, 255, 0);\r\n"
		 		+ "    }\r\n"
		 		+ "     \r\n"
		 		+ "    ul {\r\n"
		 		+ "\r\n"
		 		+ "      list-style-type: none;\r\n"
		 		+ "      margin: 0;\r\n"
		 		+ "      padding: 0;\r\n"
		 		+ "      overflow: hidden;\r\n"
		 		+ "      color: rgb(100, 128, 0);\r\n"
		 		+ "      background-color: #e23434;\r\n"
		 		+ "      border-color: #618068;\r\n"
		 		+ "\r\n"
		 		+ "    }\r\n"
		 		+ "\r\n"
		 		+ "    li {\r\n"
		 		+ "      float: left;\r\n"
		 		+ "      height: 40px;\r\n"
		 		+ "      margin: 4px;\r\n"
		 		+ "      font-style: italic;\r\n"
		 		+ "      text-align: center;\r\n"
		 		+ "\r\n"
		 		+ "    }\r\n"
		 		+ "\r\n"
		 		+ "    /* h3{\r\n"
		 		+ "          background:linear-gradient(pink,aqua);\r\n"
		 		+ "    margin: 300px;\r\n"
		 		+ "    padding: 70px;\r\n"
		 		+ "    text-align: center;\r\n"
		 		+ "    background-color: blueviolet;\r\n"
		 		+ "    width: 500px;\r\n"
		 		+ "    height: 270px;\r\n"
		 		+ "    box-sizing:border-box red;\r\n"
		 		+ "    border: solid 5px blue;\r\n"
		 		+ "    box-shadow: 5px 10px green;\r\n"
		 		+ "          border-radius: 50%;\r\n"
		 		+ "          text-align: center;\r\n"
		 		+ "          }*/\r\n"
		 		+ "    h2 li a {\r\n"
		 		+ "      margin: auto;\r\n"
		 		+ "      font-size: 40px;\r\n"
		 		+ "      float: right;\r\n"
		 		+ "      text-align: center;\r\n"
		 		+ "      padding: 8px 55px;\r\n"
		 		+ "      text-decoration: none;\r\n"
		 		+ "      font-size: 17px;\r\n"
		 		+ "      font-size: 20px;\r\n"
		 		+ "    }\r\n"
		 		+ "    \r\n"
		 		+ "  </style>\r\n"
		 		+ "</head>\r\n"
		 		+ "\r\n"
		 		+ "<body background=\"Lotus.jpg\">\r\n"
		 		+ "  <h1 align=\"center\">Welcome To My Project</h1>\r\n"
		 		+ "  <hr>\r\n"
		 		+ "  <ul align=\"center\">\r\n"
		 		+ "\r\n"
		 		+ "    <h2>\r\n"
		 		+ "      <center>\r\n"
		 		+ "        <li><a href=\"Login.html\">Login</a></li>\r\n"
		 		+ "        <li><a href=\"Post.html\">Post Data</a></li>\r\n"
		 		+ "        <li><a href=\"http://localhost:9191/InterView/GetData\">Get Data</a></li>\r\n"
		 		+ "        <li><a href=\"Update.html\">Update Data</a></li>\r\n"
		 		+ "        <li><a href=\"Delete.html\">Delete Data</a></li>\r\n"
		 		+ "        \r\n"
		 		+ "       \r\n"
		 		+ "      </center>\r\n"
		 		+ "    </h2>\r\n"
		 		+ "\r\n"
		 		+ "  </ul>\r\n"
		 		+ "  <hr>\r\n"
		 		+ "\r\n"
		 		+ "</body>\r\n"
		 		+ "\r\n"
		 		+ "</html>");
		 out.flush();
		 
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssproject","root","root");
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM ssproject.user where email='"+email+"' and mobile= '"+mobile+"'");
			 if(result.next()) {
			    	System.out.println("Welcome");
			    }
			    else {
			    	System.out.println("Invalid Email/Password");
			    }
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
