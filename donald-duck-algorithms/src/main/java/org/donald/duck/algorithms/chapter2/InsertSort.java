package org.donald.duck.algorithms.chapter2;

import java.util.Arrays;

/**
 * 插入排序
 * 特点：其右边的元素不变，左边的元素有序
 */
public class InsertSort {

	public static void main(String[] args) {
		sort1();
		System.out.println("---------这是分割线-----------");
		sort2();
	}

	/**
	 * 正儿八经的插入排序
	 */
	private static void sort1() {
		int a[] = new int[] { 99, 3, 2, 0, 4, 6, 7, 5, 8, 9 };

		for (int i = 0; i < 10; i++) {
			System.out.println("-----------" + i + "--------------");
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
				System.out.println(Arrays.toString(a));
			}
		}
	}

	// 千奇百怪的排序
	private static void sort2() {
		int a[] = new int[] { 99, 3, 2, 0, 4, 6, 7, 5, 8, 9 };

		for (int i = 0; i < 10; i++) {
			System.out.println("-----------" + i + "--------------");
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				System.out.println(Arrays.toString(a));
			}
		}
	}
}
