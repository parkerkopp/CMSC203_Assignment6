
public class Customer {
	
	String name;
	int age;
	
	public Customer(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Customer(Customer c) {
		
		name = c.name;
		age = c.age;
		
	}
	
	public int getAge() {
		
		return age;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String toString() {
		
		return name + "," + age;
		
	}

}
