package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	/**
	 * @param numberOfDays TODO
	 * @return
	 */
	double getCharge(int numberOfDays) {
		float result = 0;
		int priceCode = _priceCode;
		int daysRented = numberOfDays;
		switch (priceCode) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2)
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;
		}
		return result;
	}

	int getFrequentRenterPoints(Rental rental) {
		int result = 0;
		result++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			result++;
		return result;
	}
}
