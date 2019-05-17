package ubu.gii.dass.refactoring;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
	}

	@Override
	public double getCharge(int numberOfDays) {
		double result = 0;
		result += 1.5;
		if (numberOfDays > 3)
			result += (numberOfDays - 3) * 1.5;
		return result;
	}
	
	

}
