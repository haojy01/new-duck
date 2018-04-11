package org.donald.duck.algorithms.chapter1;

import org.donald.duck.util.StdOut;
import org.donald.duck.util.StdRandom;

public class RandomSeq {

	// this class should not be instantiated
	private RandomSeq() {
	}

	/**
	 * Reads in two command-line arguments lo and hi and prints n uniformly
	 * random real numbers in [lo, hi) to standard output.
	 *
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {

		String[] arg = new String[] { "123" };
		int n = Integer.parseInt(arg[0]);

		// for backward compatibility with Intro to Programming in Java version
		// of RandomSeq
		if (arg.length == 1) {
			// generate and print n numbers between 0.0 and 1.0
			for (int i = 0; i < n; i++) {
				double x = StdRandom.uniform();
				StdOut.println(x);
			}
		}

		else if (arg.length == 3) {
			double lo = Double.parseDouble(arg[1]);
			double hi = Double.parseDouble(arg[2]);

			// generate and print n numbers between lo and hi
			for (int i = 0; i < n; i++) {
				double x = StdRandom.uniform(lo, hi);
				StdOut.printf("%.2f\n", x);
			}
		}

		else {
			throw new IllegalArgumentException("Invalid number of arguments");
		}
	}
}
