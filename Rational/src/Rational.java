
public class Rational {
	int p;
	int q;
	/*
	 * Constructor: if numerator and denominator are not in lowest terms, this method should use Euclid’s
	 * algorithm to reduce them prior to storing them in instance variables
	 * Requires: denominator ≠ 0
	 */
	public Rational(int numerator, int denominator) {
		int num = numerator;
		int den = denominator;
		int temp = 0;
		while(den != 0) {
			temp = den;
			den = num % den;
			num = temp;
			
		}
		this.p = numerator / num;
		this.q = denominator / num;	
	}
	/*
	 * Ensures: return value is the sum of this and b
	 */
	public Rational plus(Rational b) { 
		return new Rational(((this.p * b.q) + (this.q * b.p)), (this.q * b.q));
	}
	/*
	 * Ensures: return value is the difference of this and b
	 */
	public Rational minus(Rational b) {
		return new Rational((this.p * b.q) - (this.q * b.p), (this.q * b.q));
	}
	/*
	 * Ensures: return value is the product of this and b
	 */
	public Rational times(Rational b) {
		return new Rational((this.p * b.p), (this.q * b.q));
	}
	/*
	 * Ensures: return value is the ratio of this and b
	 */
	public Rational divides(Rational b) {
		return new Rational((this.p * b.q), (this.q * b.p));
	}
	/*
	 * Ensures: return value is this = b
	 */
	public boolean equals(Rational b) {
		if(this.p == b.p && this.q == b.q){
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * Ensures: return value is the numerator of this
	 */
	public long numerator() {
		long num = this.p;
		return num;
	}
	/*
	 * Ensures: return value is the denominator of this
	 */
	public long denominator() {
		long den = this.q;
		return den;
	}
	/*
	 * Ensures: return value is a string representation of n/d, where n is the numerator and d is the
	 * denominator
	 */
	public String toString() {
		String fraction = Long.toString(this.p) + "/" + Long.toString(this.q);
		return fraction;
	}
	/*
	 * Main() to test all the methods
	 */
	public static void main(String[] args) {
		//Original Rational Number
		Rational number = new Rational(5, 4);
		//Converts original Rational Number to a String
		String stringNum = number.toString();
		//Prints out the String version of the original fraction
		System.out.println("String form of Number: " + stringNum);
		//Additional Rational Number
		Rational newRat = new Rational(2, 3);
		//Adding the Rational Number
		Rational addRat = number.plus(newRat);
		String addString = addRat.toString();
		System.out.println("Added: " + addString);
		//Subtracting the Rational Numbers
		Rational subRat = number.minus(newRat);
		String subString = subRat.toString();
		System.out.println("Subtracted: " + subString);
		//Multiplying the Rational Numbers
		Rational timesRat = number.times(newRat);
		String timesString = timesRat.toString();
		System.out.println("Multiplied: " + timesString);
		//Dividing the Rational Numbers
		Rational divideRat = number.divides(newRat);
		String divideString = divideRat.toString();
		System.out.println("Divided: " + divideString);
		boolean equal = number.equals(newRat);
		System.out.println("Equals: " + equal);
		long numerator = number.numerator();
		System.out.println("Numerator: " + numerator);
		long denominator = number.denominator();
		System.out.println("Denominator: " + denominator);	
	}
}
