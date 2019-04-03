package account;

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

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class getDBconnection
 */
@WebServlet("/getDBconnection")
public class getDBconnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDBconnection() {
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
		doGet(request, response);
		try {
			String item = request.getParameter("item");
			String bidAmount = request.getParameter("bidAmount");
			String bidderAccount = request.getParameter("bidderAccount");
			String organizationAccount = request.getParameter("organizationAccount");
			String payment = request.getParameter("payment");
			String sellerAccount = request.getParameter("sellerAccount");
			String sql = "insert into auctionconfirmation(item,bidAmount,bidderAccount,organizationAccount,payment,sellerAccount) values(?,?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
	        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/completeauction", "root", "root");
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, item);
	        ps.setString(2, bidAmount);
	        ps.setString(3, bidderAccount);
	        ps.setString(4, organizationAccount);
	        ps.setString(5, payment);
	        ps.setString(6, sellerAccount);
	        ps.execute();
	        PrintWriter out = response.getWriter();
	        out.println("Account Details");

	        Statement st = (Statement) con.createStatement();
	        ResultSet result = st.executeQuery("select * account");

	        while (result.next()) {
	            
	        }
	        String s2=request.getParameter("s1");
			Connection conn;
			if(s2.equals("insert")) {
				PreparedStatement ps1=con.prepareStatement("insert into account(item,bidAmount,bidderAccount,organizationAccount,payment,sellerAccount)values(?,?,?,?,?,?)");
				ps.setString(1, item);
				ps.setString(2, bidAmount);
				ps.setString(3, bidderAccount);
				ps.setString(4, organizationAccount);
				ps.setString(5, payment);
				ps.setString(6, sellerAccount);
				
			    int a=ps.executeUpdate();
			    
			    if(a>0) {
			    	out.println("Values are inserted");
			    }else {
			    	out.println("values are not inserted");
			    }
			}else if(s2.equals("delete")) {
				PreparedStatement ps2=con.prepareStatement("Delete from account where item=?");
				ps2.setString(1,item);
				ps2.executeUpdate();
				out.println("item"+item);
			}else if(s2.equals("update")) {
				String query="update account set item='"+item+"'bidAmount='"+bidAmount+"'bidderAccount='"+bidderAccount+"'organizationAccount'"+organizationAccount+"'payment'"+payment+"'sellerAccount'"+sellerAccount;
				java.sql.Statement st1=con.createStatement();
				st1.executeUpdate(query);
				out.println("update successfully");
			}
			PreparedStatement ps1=con.prepareStatement("select*from auctionconfirmation");
			ResultSet rs1=ps.executeQuery();
			out.println("update successfully");
		
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

	