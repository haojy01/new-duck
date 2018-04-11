package org.donald.duck.algorithms.chapter1;

import org.donald.duck.util.StdIn;
import org.donald.duck.util.StdOut;

/***
 * 字符串散列 洗牌算法 时间复杂度 O(n)
 */
public class Knuth {

	private Knuth() {
	}

	public static void shuffle(Object[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			// choose index uniformly in [0, i]
			int r = (int) (Math.random() * (i + 1));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}

	public static void shuffleAlternate(Object[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			// choose index uniformly in [i, n-1]
			int r = i + (int) (Math.random() * (n - i));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Knuth.shuffle(a);
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
	}
}