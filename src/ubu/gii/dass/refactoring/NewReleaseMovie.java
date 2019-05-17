package ubu.gii.dass.refactoring;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title, int priceCode) {
		super(title, priceCode);
	}

	@Override
	public double getCharge(int numberOfDays) {
		double result = 0;
		result += numberOfDays * 3;
		return result;
	}

	@Override
	public int getFrequentRenterPoints(int numberOfDays) {
		int result = super.getFrequentRenterPoints(numberOfDays);
		// add bonus for a two day new release rental
		if (numberOfDays >1) {
			result++;
		}
		return result;
	}
	
	

}
