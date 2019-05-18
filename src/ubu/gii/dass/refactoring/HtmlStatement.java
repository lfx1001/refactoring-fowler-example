package ubu.gii.dass.refactoring;

public class HtmlStatement extends Statement {

	public HtmlStatement(Customer customer) {
		this.customer=customer;
	}

	@Override
	public String printFooter() {
		String result = "</P>\n<P>Amount owed is " + String.valueOf(customer.getTotalCharge()) + "</P>\n";
		result += "<P>You earned " + String.valueOf(customer.getTotalFrequentPoints())
				+ " frequent renter points</P>";
		return result;
	}

	@Override
	public String printDetailLine(Rental rental) {
		String result = "\t" + rental.getMovie().getTitle() + "\t"
				+ String.valueOf(rental.getCharge()) + "<BR />\n";
		return result;
	}

	@Override
	public String printHeader() {
		String result = "<H1>Rental Record for " + customer.getName() + "</H1>\n<P>\n";
		return result;
	}

}
