package send_Email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.*;

/**
 * Servlet implementation class ConfirmS
 */
@WebServlet("/ConfirmS")
public class ConfirmS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmS() {
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
			String confirmed_bidId = request.getParameter("confirm_bidId");
			System.out.print(confirmed_bidId);
			String username = request.getParameter("Username");
			Double bidPrice =Double.valueOf(request.getParameter("bid_price"));
			String com_date = request.getParameter("com_date");
			String bid_username = request.getParameter("bid_date");
			String ItemOwner = request.getParameter("ItemOwner");
			int ownerContactNo =Integer.valueOf(request.getParameter("ContactNo"));
			String email = request.getParameter("Email");
			request.setAttribute("confirmed_bidId", confirmed_bidId);
			request.setAttribute("username", username);
			request.setAttribute("bidPrice", bidPrice);
			request.setAttribute("com_date", com_date);
			request.setAttribute("bid_username", bid_username);
			request.setAttribute("ItemOwner", ItemOwner);
			request.setAttribute("ownerContactNo", ownerContactNo);
			request.setAttribute("email", email);
			
		
		String sql = "insert into auctionConfirmation(confirmed_bidId,username,bidPrice,com_date,bid_username,ItemOwner,ownerContactNo,email) values(?,?,?,?,?,?,?,?)";
		    Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction", "root", "");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, confirmed_bidId);
			ps.setString(2, username);
			ps.setDouble(3, bidPrice);
			ps.setString(4, com_date);
			ps.setString(5, bid_username);
			ps.setString(6, ItemOwner);
			ps.setInt(7, ownerContactNo);
			ps.setString(8, email);
			ps.execute();
			PrintWriter out = response.getWriter();
			out.println("You are the Winner!");
			
			request.getRequestDispatcher("viewConfirmationMail.jsp").forward(request, response);
		}
		catch(ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (SQLException e) {
			//TODP Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void bidConfirm(HttpServletRequest request, HttpServletResponse response,confirm1 con) throws ServletException, IOException {
		System.out.println(con.getItemOwner());
	}
}