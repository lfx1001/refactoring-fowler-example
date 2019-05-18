package ubu.gii.dass.refactoring;

import java.util.Iterator;

public class TextStatement {
	
	private Customer customer;
	
	public TextStatement(Customer customer) {
		this.customer=customer;
	}
	
	public String printDetail(Customer customer) {
		String result = "";
		Iterator<Rental> rentals = this.customer.getRentals().iterator();		
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			// show figures for this rental
			result += printDetailLine(rental);
		}
		return result;
	}

	public String printFooter(Customer customer) {
		String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(customer.getTotalFrequentPoints())
				+ " frequent renter points";
		return result;
	}

	public String printDetailLine(Rental rental) {
		String result = "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(rental.getCharge()) + "\n";
		return result;
	}

	public String printHeader(Customer customer) {
		String result = "Rental Record for " + customer.getName() + "\n";
		return result;
	}
	
	
}
