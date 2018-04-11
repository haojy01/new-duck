package org.donald.duck.algorithms.chapter2;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {

		String a[] = new String[] { "S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "A" };
		// h 序列
		int h[] = new int[] { 1, 4, 13 };
		System.out.println(Arrays.toString(a));
		for (int s = h.length - 1; s >= 0; s--) {
			int step = h[s];
			System.out.println("--------------------h=" + step + "-------------------------");
			for (int i = step; i < a.length; i++) {
				for (int j = i; j - step >= 0; j -= step) {
					if (a[j].compareTo(a[j - step]) < 0) {
						String temp = a[j - step];
						a[j - step] = a[j];
						a[j] = temp;
					}
				}
				System.out.println(Arrays.toString(a));
			}
		}
	}
}
