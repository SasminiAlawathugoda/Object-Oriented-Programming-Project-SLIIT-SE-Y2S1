package account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckAccount
 */
@WebServlet("/CheckAccount")
public class CheckAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAccount() {
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
		response.setContentType("text/html");
		Account Acc=new Account();
		Acc.setbidAmount(request.getParameter("bidAmount"));
		Acc.setAmount(request.getParameter("Amount"));
		Acc.setbidderAccount(request.getParameter("bidderAccount"));
		Acc.setitem(request.getParameter("item"));
		Acc.setorganizationAccount(request.getParameter("organizationAccount"));
		Acc.setpayment(request.getParameter("payment"));
		Acc.setsellerAccount(request.getParameter("Account"));
		
		request.getRequestDispatcher("sendEmail.jsp").forward(request,response);
	}

}
