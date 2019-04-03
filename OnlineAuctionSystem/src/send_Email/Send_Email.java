package send_Email;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.*;

/**
 * Servlet implementation class Send_Email
 */
@WebServlet("/Send_Email")
public class Send_Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send_Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		  Confirm bid=new Confirm();
		  bid.setConfirmed_bidId(request.getParameter("Confirmed_bidId"));
		  bid.setUsername(request.getParameter("username"));
		  bid.setbid_price(request.getParameter("bid_price"));
		  bid.setcom_date(request.getParameter("com_date"));
		  bid.setbid_username(request.getParameter("bid_username"));
		  bid.setsend_confirmEmail(request.getParameter("send_confirmEmail"));
		}
		
		catch(Throwable theException) {
			System.out.println("theException");
		}
	}

	/**
	 * @param conn 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Connection conn) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			
			String confirmed_bidId = request.getParameter("confirmed_bidId");
			String username = request.getParameter("username");
			String bidPrice = request.getParameter("bidPrice");
			String com_date = request.getParameter("com_date");
			String bid_username = request.getParameter("bid_username");
			String ItemOwner = request.getParameter("ItemOwner");
			String ownerContactNo = request.getParameter("ownerContactNo");
			String email = request.getParameter("email");
			String sql = "insert into auctionconfirmation(confirmed_bidId,username,bidPrice,com_date,bid_username,ItemOwner,ownerContactNo,email) values(?,?,?,?,?,?,?,?)";
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction", "root", "root");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, confirmed_bidId);
			ps.setString(2, username);
			ps.setString(3, bidPrice);
			ps.setString(4, com_date);
			ps.setString(5, bid_username);
			ps.setString(6, ItemOwner);
			ps.setString(7, ownerContactNo);
			ps.setString(8, email);
			ps.execute();
			PrintWriter out1 = response.getWriter();
			out1.println("You are the Winner!");
			
			String s2=request.getParameter("s1");
			if(s2.equals("insert")) {
				PreparedStatement ps1=conn.prepareStatement("insert into auctionconfirmation(confirmed_bidId,username,bidPrice,com_date,bid_username,ItemOwner,ownerContactNo,email)values(?,?,?,?,?,?,?,?,)");
				ps.setString(1, confirmed_bidId);
				ps.setString(2, username);
				ps.setString(3, bidPrice);
				ps.setString(4, com_date);
				ps.setString(5, bid_username);
				ps.setString(6, ItemOwner);
				ps.setString(7, ownerContactNo);
				ps.setString(8, email);
				
			    int a=ps.executeUpdate();
			    
			    if(a>0) {
			    	out1.println("Values are inserted");
			    }else {
			    	out1.println("values are not inserted");
			    }
			}else if(s2.equals("delete")) {
				PreparedStatement ps2=conn.prepareStatement("Delete from auctionconfirmation where confirmed_bidId=?");
				ps2.setString(1,confirmed_bidId);
				ps2.executeUpdate();
				out1.println("deleted with confirmed_bidId"+confirmed_bidId);
			}else if(s2.equals("update")) {
				String query="update auctionconfirmation set confirmed_bidId='"+confirmed_bidId+"'username='"+username+"'bidPrice='"+bidPrice+"'com_date'"+com_date+"'bid_username'"+bid_username+"'ItemOwner'"+ItemOwner+"'ownerContactNo'"+ownerContactNo+"'email'"+email;
				Statement st=conn.createStatement();
				st.executeUpdate(query);
				out1.println("update successfully");
			}
			PreparedStatement ps1=conn.prepareStatement("select*from auctionconfirmation");
			ResultSet rs1=ps.executeQuery();
			out1.println("update successfully");
		
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
