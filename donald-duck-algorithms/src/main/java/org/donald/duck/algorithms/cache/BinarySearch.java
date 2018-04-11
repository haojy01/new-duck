package org.donald.duck.algorithms.cache;

public class BinarySearch {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		rank(9, a);
	}

	public static void rank(int search, int[] a) {
		int low = 0;
		int high = a.length - 1;

		for (int i = 0; i < a.length; i++) {
			System.out.println("+++++++");
			int mod = (low + high) / 2;
			if (mod > high || mod < low) {
				System.out.println("没有找到");
				break;
			}
			if (a[mod] < search) {
				low = mod + 1;
			} else if (a[mod] > search) {
				high = mod - 1;
			} else {
				System.out.println(mod);
				break;
			}
			System.out.println(low);
			System.out.println(high);
			System.out.println(mod);
		}

	}

}
