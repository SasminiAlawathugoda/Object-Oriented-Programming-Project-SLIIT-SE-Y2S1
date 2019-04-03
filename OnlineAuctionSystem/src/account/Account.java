package account;

public class Account {
	private String bidAmount;
	private String bidderAccount;
	private String sellerAccount;
	private String organizationAccount;
	private String payment;
	private String item;
	private String Amount;
	
	public String getbidAmount() {
		
		return bidAmount;
	}
	public void setbidAmount(String newbidAmount) {
		bidAmount=newbidAmount;
	}
	
	public String getbidderAccount() {
		return bidderAccount;
	}
	
	public void setbidderAccount(String newbidderAccount) {
		
		bidderAccount=newbidderAccount;
	
	}
	
	public String getsellerAccount() {
		return sellerAccount;
	}
	
	public void setsellerAccount(String newsellerAccount) {
         sellerAccount=newsellerAccount;
	}
	public String getorganizationAccount() {
		return organizationAccount;
	}
	
	public void setorganizationAccount(String neworganizationAccount) {
		
		organizationAccount=neworganizationAccount;
			}
	
	public String getpayement() {
		return payment;
	}
	public void setpayment(String newpayment) {
		payment=newpayment;
		}
	
	public String getitem() {
		return item;
	}
	public void setitem(String newitem) {
		item=newitem;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String newAmount) {
		Amount=newAmount;
	}
   @Override
   public String toString(){
	   return "organizationAccount="+organizationAccount+"\n"+"bidderAccount="+bidderAccount+"\n"+"sellerAccount="+sellerAccount+"\n";
   }
	}
	


