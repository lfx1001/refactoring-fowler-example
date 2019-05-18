package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		String result = printHeader(this);
		result += printDetail(this);
		// add footer lines
		result += printFooter(this);
		return result;
	}

	private String printDetail(Customer customer) {
		String result = "";
		Iterator<Rental> rentals = customer._rentals.iterator();		
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			// show figures for this rental
			result += printDetailLine(rental);
		}
		return result;
	}

	private String printFooter(Customer customer) {
		String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(customer.getTotalFrequentPoints())
				+ " frequent renter points";
		return result;
	}

	private String printDetailLine(Rental rental) {
		String result = "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(rental.getCharge()) + "\n";
		return result;
	}

	private String printHeader(Customer customer) {
		String result = "Rental Record for " + customer.getName() + "\n";
		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += rental.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentPoints() {
		int result = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}
}
