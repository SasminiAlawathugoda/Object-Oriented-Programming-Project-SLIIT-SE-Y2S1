package auctionanItem;


	public interface IItemservice {

		
		public static final Logger log = Logger.getLogger(IItemservice.class.getItemName());


		
		public void addItem(Item item);

		
		public Item getItemByName(String itemName);
		
		
		public ArrayList<Item> getItems();
		
		
		public Item updateItem(String itemName, Item item);

		
		public void removeItem(String itemName);

	}
}
