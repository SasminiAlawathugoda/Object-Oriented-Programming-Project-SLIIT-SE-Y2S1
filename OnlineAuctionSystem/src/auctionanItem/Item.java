package auctionanItem;

public class Item {
  
	private String SellarName;
	private String ItemName;
	private double Price;
	
	
	public String getSellarName() {
		return SellarName;
	}
	public void setSellarName(String SellarName) {
		SellarName = sellarName;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String ItemName) {
		ItemName = itemName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double Price) {
		Price = price;
	}
	public String printDetails() {
		System.out.println("Sellar Name:" + SellarName + "\n" + "Item Name:" + ItemName + "\n" + "ItemPrice: " + Price );
		
	}

}

}
