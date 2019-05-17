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
	
	

}
