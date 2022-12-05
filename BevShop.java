import java.util.*;

public class BevShop implements BevShopInterface {
	
	public ArrayList<Order> orders;
	
	public BevShop() {
		
		orders = new ArrayList<Order>();
		
	}
	
	public boolean isValidTime(int time) {
		
		if(time < MAX_TIME && time > MIN_TIME)
			
			return true;
		
		else
			
			return false;
		
	}
	
	public int getMaxNumOfFruits() {
		
		return MAX_FRUIT;
		
	}
	
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
		
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		
		if(numOfFruits > MAX_FRUIT)
		
			return true;
		
		else
			
			return false;
		
	}
	
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
		
	}
	
	public boolean isEligibleForMore() {
		
		if(getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL)
			
			return true;
		
		else
			
			return false;
		
	}
	
	public int getNumOfAlcoholDrink() {
		
		return getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
		
	}
	
	public boolean isValidAge(int age) {
		
		if(age > MIN_AGE_FOR_ALCOHOL)
			
			return true;
		
		else
			
			return false;
		
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		
		Order order = new Order(time, day, new Customer(customerName, customerAge));
		orders.add(order);
		
	}
	
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}
	
	public void processAlcoholOrder(String bevName, Size size) {
		
		if(isEligibleForMore() == true && isValidAge(getCurrentOrder().getCustomer().getAge()) == true)
			
			getCurrentOrder().addNewBeverage(bevName, size);
		
		else
			
			System.out.println("You are not eligible for more alcohol");
		
	}
	
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}
	
	public int findOrder(int orderNo) {
		
		for(int i = 0; i < orders.size(); i++) {
			
			if(orders.get(i).getOrderNo() == orderNo)
				
				return i;
			
		}
		
		return -1;
		
	}
	
	public double totalOrderPrice(int orderNo) {
		
		return orders.get(findOrder(orderNo)).calcOrderTotal();
		
	}
	
	public double totalMonthlySale() {
		
		double total = 0;
		
		for(int i = 0; i < orders.size(); i++) {
			
			total += orders.get(i).calcOrderTotal();
			
		}
		
		return total;
		
	}
	
	public int totalNumOfMonthlyOrders() {
		
		return orders.size();
		
	}
	
	public Order getCurrentOrder() {
		
		return orders.get(orders.size() - 1);
		
	}
	
	public Order getOrderAtIndex(int index) {
		
		return orders.get(index);
		
	}
	
	public void sortOrders() {
		
		for(int i = 0; i < orders.size()-1; i++) {
			
			int index = i;
			
			for(int n = i+1; n < orders.size(); n++) {
				
				if(orders.get(n).compareTo(orders.get(index)) == -1)
					
					index = n;
				
			}
			
			Order temp = orders.get(index);
			orders.set(index, orders.get(i));
			orders.set(i, temp);
			
		}
		
	}
	
	public String toString() {
		
		String toReturn = "Total monthly sale: " + totalMonthlySale() + "\n";
		
		for(int i = 0; i < orders.size(); i++) {
			
			toReturn += "Order " + i + ": \n" + orders.get(i).toString() + "\n";
			
		}
		
		return toReturn;
		
	}

}
