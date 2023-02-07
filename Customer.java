package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	//name, address, a plan and two lists
	String name;
	String address;
	String plan;

	ArrayList<String> interested;
	ArrayList<String> received;

	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;

		interested = new ArrayList<String>();
		received = new ArrayList<String>();

	}

	public String getName() {
		return name;
	}
	
	public String getPlan() {
		return plan;
	}
	
	public ArrayList<String> getQueue() {
		return interested;
	}
	
	public ArrayList<String> getRented() {
		return received;
	}

	@Override
	public int compareTo(Customer compareName) {

		return name.compareTo(compareName.getName());
	}

	@Override
	public String toString() {

		return "Name: " + name + ", Address: " + address + ", Plan: " + plan +"\nRented: " + received + "\nQueue: " + interested + "\n";
	}

}
