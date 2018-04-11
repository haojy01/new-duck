package org.donald.duck.algorithms.chapter4;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		sort();
	}

	public static void sort() {
		int a[] = { 1, 3, 5, 7, 9 };
		int b[] = { 2, 4, 6, 8, 10,15,16,17,18 };
		int aux[] = new int[a.length + b.length];

		System.out.println(aux.length);

		int i = 0;
		int j = 0;
		for (int h = 0; h < aux.length; h++) {
			if (i > a.length - 1) {
				aux[h] = b[j];
				j++;
				continue;
			}
			if (j > b.length - 1) {
				aux[h] = a[i];
				i++;
				continue;
			}
			if (a[i] < b[j]) {
				aux[h] = a[i];
				i++;
				continue;
			}
			if (a[i] > b[j]) {
				aux[h] = b[j];
				j++;
				continue;
			}
		}

		System.out.println(Arrays.toString(aux));
	}
}
