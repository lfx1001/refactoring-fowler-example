package ubu.gii.dass.refactoring;

import java.util.Iterator;

public abstract class Statement {

	protected Customer customer;

	public Statement() {
		super();
	}
	
	public abstract String printFooter();

	public abstract String printDetailLine(Rental rental); 

	public abstract String printHeader();

	public final String printDetail() {
		String result = "";
		Iterator<Rental> rentals = customer.getRentals().iterator();		
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			// show figures for this rental
			result += printDetailLine(rental);
		}
		return result;
	}


	public final String print() {
		String result = printHeader();
		result += printDetail();
		// add footer lines
		result += printFooter();
		return result;
	}

}