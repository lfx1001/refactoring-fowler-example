package ubu.gii.dass.refactoring;

public class RegularMovie extends Movie {

	public RegularMovie(String title, int priceCode) {
		super(title, priceCode);
	}

	@Override
	public double getCharge(int numberOfDays) {
		double result = 0;
		result += 2;
		if (numberOfDays > 2)
			result += (numberOfDays - 2) * 1.5;
		return result;
	}
	
	

}
