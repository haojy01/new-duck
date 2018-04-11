package org.donald.duck.algorithms.cache;

public class ChoseSort {

	public static void main(String[] args) {

	}

	public void sort(int a[]) {

		int turn = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] < a[j]) {
					turn = i;
				}
			}
			int temp = a[i];
			a[i] = a[turn];
			a[turn] = temp;
		}
	}

}
