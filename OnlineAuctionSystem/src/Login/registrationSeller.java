package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationSeller
 */
@WebServlet("/registrationSeller")
public class registrationSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationSeller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction","root", "");
			response.setContentType("Text/html");
			PrintWriter out = response.getWriter();
			
			String sql = "select firstname,lastname,username,address1,address2,city,email,password from registrationSeller";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String str = "<table border=1><tr><th>FirstName</th><th>LastName</th><th>UserName</th><th>AddressLine1</th><th>AddressLine2</th><th>City</th><th>Email</th><th>Password</th></tr>";
			while(rs.next()) {
				str += "<tr><td>"+rs.getString(1)+"</td></tr>"+"<tr><td>"+rs.getString(2)+"</td></tr>"+"<tr><td>"+rs.getString(3)+"</td></tr>"+"<tr><td>"+rs.getString(4)+"</td></tr>"+"<tr><td>"+rs.getString(5)+"</td></tr>"+"<tr><td>"+rs.getString(6)+"</td></tr>"+"<tr><td>"+rs.getString(7)+"</td></tr>"+"<tr><td>"+rs.getString(8)+"</td></tr>";      
						
			}
			str += "</table>";
			out.println(str);
			conn.close();
			out.close();
			
		   }catch(Exception e) {
	          System.out.println(e);
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   try {
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String sql = "insert into registrationSeller(firstname,lastname,username,address1,address2,city,email,password) values(?,?,?,?,?,?,?,?)";//sql command
		    Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction","root", "");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, address1);
			ps.setString(5, address2);
			ps.setString(6, city);
			ps.setString(7, email);
			ps.setString(8, password);
			
			ps.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("You have successfully registered!");
			
			 
			
			
		}
		catch(ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (SQLException e) {  //sql exception
			//TODP Auto-generated catch block
			e.printStackTrace();
		}
	}

}
