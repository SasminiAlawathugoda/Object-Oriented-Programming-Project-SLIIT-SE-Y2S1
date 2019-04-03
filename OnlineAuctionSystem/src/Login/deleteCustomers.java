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
 * Servlet implementation class deleteCustomers
 */
@WebServlet("/deleteCustomers")
public class deleteCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCustomers() {
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
			
			String sql = "select * from registration";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String str = "<table border=1><tr><th>FirstName</th><th>LastName</th><th>Email</th><th>UserName</th><th>Password</th><th>Delete</th></tr>";
			while(rs.next()) {
				str += "<form method='post' action='deleteCustomers'>"+"<tr><td>"+rs.getString(1)+"</td></tr>"+"<tr><td>"+rs.getString(2)+"</td></tr>"+"<tr><td>"+rs.getString(3)+"</td></tr>"+"<tr><td>"+rs.getString(4)+"</td></tr>"+"<tr><td>"+rs.getString(5)+"</td></tr>"+"<td><tr>"+"<input type='submit' value='Delete'/>"+"</tr></td>"+"</form>";      
						
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
		// TODO Auto-generated method stub
   try {
			
			String firstname = request.getParameter("firstname");
			 
			String sql = "delete * from registration where firstname=?";
		    Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction","root", "");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			 
			
		    ps.executeUpdate();
		 
			
		 
			
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
