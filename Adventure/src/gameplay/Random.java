package gameplay;

/**
 * This class helps you generate random integers. It is the version that will
 * generate each possible value with approximately equal probability
 * (unlike the version on the midterm).
 * 
 * @author Dr Russell Campbell
 */
public class Random {

	/**
	 * This method generates a pseudorandom integer in the range [0, max).
	 *
	 * @param count
	 *   The argument passed in for this parameter should be different with each call.
	 *   This makes sure generated values are different when the processor executes calls
	 *   quickly within the same millisecond.
	 * 
	 * @param max
	 *   This is the strict upper bound for the possible integers that will be generated.
	 * 
	 * @return
	 *   The generated pseudorandom integer.
	 */
	public static int rand(int count, int max) {

		final int PRIME_1 = 2113; // different primes will change the random behaviour
		final int PRIME_2 = 7369; // its generally better to use larger primes
		long time = System.currentTimeMillis() % 1000000;
		long seed = time + count;
		double trig = Math.sin(PRIME_1 * seed + PRIME_2); // value between -1 and 1
		double func = Math.abs(PRIME_1 * trig); // make it positive and larger
		double frac = func - Math.floor(func); // digits past the decimal seem random

		return (int) (frac * max); // get an integer in our range [0, max)
	}
}
