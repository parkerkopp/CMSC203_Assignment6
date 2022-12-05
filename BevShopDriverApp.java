
public class BevShopDriverApp {
	
	public static void main(String[] args) {
		
		BevShop shop = new BevShop();
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Parker", 17);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Mocha and Strawberry Smoothie to order");
		shop.processCoffeeOrder("Mocha", Size.MEDIUM, false, false);
		shop.processSmoothieOrder("Strawberry Smoothie", Size.MEDIUM, 3, false);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Whiskey to order");
		shop.processAlcoholOrder("Whiskey", Size.MEDIUM);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "John", 25);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Whiskey, Wine, and Beer to order");
		shop.processAlcoholOrder("Whiskey", Size.MEDIUM);
		shop.processAlcoholOrder("Wine", Size.SMALL);
		shop.processAlcoholOrder("Beer", Size.LARGE);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Vodka to order");
		shop.processAlcoholOrder("Vodka", Size.MEDIUM);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Getting total order price");
		System.out.println(shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Vanessa", 36);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Gina", 57);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println(shop);
		shop.sortOrders();
		System.out.println(shop);
		
	}

}
