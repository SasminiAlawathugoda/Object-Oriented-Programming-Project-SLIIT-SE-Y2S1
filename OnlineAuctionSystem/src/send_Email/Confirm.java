package send_Email;

public class Confirm {
	 private String Confirmed_bidId;
	 private String Username;
	 private String bid_price;
	 private String com_date;
	 private String bid_username;
	 private String send_confirmEmail;
	 
	 public String  getConfirmed_bidId() {
		 return Confirmed_bidId;
	 }
	 
	 public void setConfirmed_bidId(String newbidId) {
		 Confirmed_bidId=newbidId;
	 }
	 
	 public String getUsername() {
		 return Username;
	 }
	 
	 public void setUsername(String newUsername) {
		 Username=newUsername;
	 }
	 
	 public String getbid_price() {
		 return bid_price;
	 }
	 public void setbid_price(String newbid_price) {
		 bid_price=newbid_price;
	 }
	 
	 public String getcom_date() {
		 return com_date;
	 }
	 public void setcom_date(String newcom_date) {
		 com_date=newcom_date;
	 }
	 
	 public String getbid_username() {
		 return bid_username;
	 }
	 public void setbid_username(String newbid_username) {
		 bid_username=newbid_username;
	 }
	 
	 public String getsend_confirmEmail() {
		 return send_confirmEmail;
	 }
	 public void setsend_confirmEmail(String newsend_confirmEmail) {
		 send_confirmEmail=newsend_confirmEmail;
	 }
	 @Override
	 public String toString() {
	 return "Confirmed_bidId="+Confirmed_bidId+"\n"+ "Username="+ Username+"\n"+"bid_price="+bid_price+"\n"+"com_date="+com_date+"\n"+" bid_username="+ bid_username+"\n"+"send_confirmEmail="+send_confirmEmail+"\n";
	 }

}
