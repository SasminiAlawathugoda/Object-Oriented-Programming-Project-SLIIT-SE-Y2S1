 package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		try {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String dbUsername = null;
			String dbPassword = null;
			String sql = "select username,password from registration where username=? and password=?";
		    Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction","root", "");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
		    ResultSet rs = ps.executeQuery();
		    PrintWriter out = response.getWriter();
		    
		    while(rs.next()) {
		    	dbUsername = rs.getString("username");
		    	dbPassword = rs.getString("password");
		    }
		    if(username.equals(dbUsername) && password.equals( dbPassword)) { 
		    	out.println("You have successfully Logged In");
		    	
		    }else{
		    	//response.sendRedirect("loginIndex.jsp");
		    	RequestDispatcher rd = request.getRequestDispatcher("loginIndex.jsp");
		    	rd.include(request, response);
		    	
		    	
		    }
		    
			
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			
			response.sendRedirect("welcomeUser.jsp");
		}
		catch(ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (SQLException e) {
			//TODP Auto-generated catch block
			e.printStackTrace();
		}
	}

}
