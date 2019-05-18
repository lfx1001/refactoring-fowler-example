package ubu.gii.dass.refactoring;


public class TextStatement extends Statement {
	
	public TextStatement(Customer customer) {
		this.customer=customer;
	}

	@Override
	public String printFooter() {
		String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(customer.getTotalFrequentPoints())
				+ " frequent renter points";
		return result;	
	}

	@Override
	public String printDetailLine(Rental rental) {
		String result = "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(rental.getCharge()) + "\n";
		return result;
	}

	@Override
	public String printHeader() {
		String result = "Rental Record for " + customer.getName() + "\n";
		return result;	
	}
		
}
