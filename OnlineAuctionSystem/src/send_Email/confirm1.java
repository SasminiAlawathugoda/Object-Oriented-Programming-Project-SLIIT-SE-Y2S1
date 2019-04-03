package send_Email;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class confirm1
 */
@WebServlet("/confirm1")
public class confirm1 {
	private String ItemOwner;
	private String ContactNo;
	private String confirm_bidId;
	private String Username;
	private  String bid_price;
	private  String com_date;
	private String bid_date;
	private String Email;
	public String getItemOwner() {
		return ItemOwner;
	}
	public void setItemOwner(String itemOwner) {
		ItemOwner = itemOwner;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getConfirm_bidId() {
		return confirm_bidId;
	}
	public void setConfirm_bidId(String confirm_bidId) {
		this.confirm_bidId = confirm_bidId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getBid_price() {
		return bid_price;
	}
	public void setBid_price(String bid_price) {
		this.bid_price = bid_price;
	}
	public String getCom_date() {
		return com_date;
	}
	public void setCom_date(String com_date) {
		this.com_date = com_date;
	}
	public String getBid_date() {
		return bid_date;
	}
	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
