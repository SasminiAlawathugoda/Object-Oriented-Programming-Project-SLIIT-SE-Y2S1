package send_Email;

import java.io.IOException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DBconnection
 */
@WebServlet("/DBconnection")
public class DBconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBconnection() {
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
		// TODO Auto-generated method stub
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        java.sql.Connection con = DriverManager.getConnection("com.mysql.jdbc:mysql://http://localhost/phpmyadmin/", "admin", "");

	        Statement st = (Statement) con.createStatement();
	        ResultSet result = st.executeQuery("select * auctionconfirmation");

	        while (result.next()) {
	            
	        }
	    }
	    catch (ClassNotFoundException e) {
	        System.out.println("Driver not found");
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	}
 }
}
