package ubu.gii.dass.refactoring;

import java.util.Iterator;

public class Statement {

	protected Customer customer;

	public Statement() {
		super();
	}

	public String printDetail() {
		String result = "";
		Iterator<Rental> rentals = customer.getRentals().iterator();		
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			// show figures for this rental
			result += printDetailLine(rental);
		}
		return result;
	}

	public String printFooter() {
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

	public String printHeader() {
		String result = "Rental Record for " + customer.getName() + "\n";
		return result;
	}

	public String print() {
		String result = printHeader();
		result += printDetail();
		// add footer lines
		result += printFooter();
		return result;
	}

}