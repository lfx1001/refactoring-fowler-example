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
		TextStatement textStatement = new TextStatement(this);
		String result = textStatement.print();
		return result;
	}

	public double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += rental.getCharge();
		}
		return result;
	}
	
	public int getTotalFrequentPoints() {
		int result = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}
	
	public List<Rental> getRentals(){
		return _rentals;
	}
}
