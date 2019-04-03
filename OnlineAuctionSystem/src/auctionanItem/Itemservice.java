package auctionanItem;

public class Itemservice {
	public class Itemservice implements IItemservice {
		

		
		public static final Logger log = Logger.getLogger(Itemservice.class.getName());

		private static Connection connection;

		private static Statement statement;

		static{
			
			createItemTable();
		}

		private PreparedStatement preparedStatement;

		
		 
		public static void createItemTable() {

			try {
				connection = DBConnectionUtil.getDBConnection();
				statement = connection.createStatement();
				
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
				statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		
		@Override
		public void addItem(Item item) {

			String sellarName = CommonUtil.generateIDs(getSellarName());
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_Items));
				connection.setAutoCommit(false);
				
				
				item.setSellarName(sellarName);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getSellarName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemName());
				preparedStatement.setdouble(CommonConstants.COLUMN_INDEX_THREE, item.getPrice());
				
				preparedStatement.execute();
				connection.commit();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}

		
		
		public Item getItemeByItemName(String itemName);

			return actionOnItem(itemName).get(0);
		}
		
			
		public ArrayList<Item> getItems() {
			
			return actionOnItem(null);
		}

		
		
		public void removeItem(String itemName) {

			// Before deleting check whether employee ID is available
			if (itemName!null && !itemName.isEmpty()) {
				/*
				 * Remove employee query will be retrieved from EmployeeQuery.xml
				 */
				try {
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_Item));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemName);
					preparedStatement.executeUpdate();
				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
				
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
		}

		
		private ArrayList<Item> actionOnItem(String itemName) {

			ArrayList<Item> employeeList = new ArrayList<Item>();
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				if (itemName != null && !itemName.isEmpty()) {
					
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_Item));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemName);
				}
				
				
				else {
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_Item));
				}
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					Item item = new Item();
					item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					item.setSellarName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					item.setPrice(resultSet.getdouble(CommonConstants.COLUMN_INDEX_THREE));
					
					itemList.add(item);
				}

			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
							
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return itemList;
		}

		
		public Item updateItem(String itemName, Item item) {

			
			if (Itemname != null && !itemName.isEmpty()) {
				
				try {
					connection = DBConnectionUtil.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_Item));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getSellarName());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemName());
					preparedStatement.setdouble(CommonConstants.COLUMN_INDEX_THREE, item.getPrice());
					
					preparedStatement.executeUpdate();

				} catch (SQLException | SAXException | IOException | ParserConfigurationException
						| ClassNotFoundException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
					
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						log.log(Level.SEVERE, e.getMessage());
					}
				}
			}
			
			return getItemByName(itemName);
		}
		
		
		private ArrayList<String> getItemName(){
			
			ArrayList<String> arrayList = new ArrayList<String>();
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_Item_Name));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				}
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return arrayList;
		}
	}


}
