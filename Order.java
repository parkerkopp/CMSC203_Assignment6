import java.util.*;

public class Order implements OrderInterface, Comparable<Order>{
	
	int orderTime;
	Day orderDay;
	Customer cust;
	ArrayList<Beverage> beverages;
	int orderNumber;
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		orderNumber = generateOrder();
		beverages = new ArrayList<Beverage>();
		
	}
	
	public int generateOrder() {
		
		orderNumber = (int)(Math.random()*80001)+10000;
		return orderNumber;
		
	}
	
	public int getOrderNo() {
		
		return orderNumber;
		
	}
	
	public int getOrderTime() {
		
		return orderTime;
		
	}
	
	public Day getOrderDay() {
		
		return orderDay;
		
	}
	
	public Customer getCustomer() {
		
		return new Customer(cust);
		
	}
	
	public Day getDay() {
		
		return orderDay;
		
	}
	
	public boolean isWeekend() {
		
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
			
			return true;
		
		else
			
			return false;
		
	}
	
	public Beverage getBeverage(int itemNo) {
		
		return beverages.get(itemNo);
		
	}
	
	public int getTotalItems() {
		
		return beverages.size();
		
	}
	
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
		
	}
	
	public void addNewBeverage(String bevName, Size size) {
		
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		beverages.add(alcohol);
		
	}
	
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
		
	}
	
	public double calcOrderTotal() {
		
		double total = 0;
		
		for(int i = 0; i < beverages.size(); i++) {
			
			total += beverages.get(i).calcPrice();
			
		}
		
		return total;
		
	}
	
	public int findNumOfBeveType(Type type) {
		
		int count = 0;
		
		for(int i = 0; i < beverages.size(); i++) {
			
			if(beverages.get(i).getType() == type)
				
				count++;
			
		}
		
		return count;
		
	}
	
	public String toString() {
		
		String toReturn = orderNumber + "," + orderTime + "," + orderDay + "," + cust.getName() + "," + cust.getAge();
		
		for(int i = 0; i < beverages.size(); i++) {
			
			toReturn += "\nBeverage " + i + ": " + beverages.get(i).toString();
			
		}
		
		return toReturn;
		
	}
	
	public int compareTo(Order anotherOrder) {
		
		if(orderNumber == anotherOrder.orderNumber)
			
			return 0;
		
		else if(orderNumber < anotherOrder.orderNumber)
			
			return -1;
		
		else
			
			return 1;
		
	}

}
