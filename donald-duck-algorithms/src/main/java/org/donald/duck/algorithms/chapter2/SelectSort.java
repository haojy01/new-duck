package org.donald.duck.algorithms.chapter2;

import java.util.Arrays;

/**
 * 选择排序 交换N次 与输入的初始顺序无关 比较 1/2n×n
 * 
 */
public class SelectSort {

	public static void main(String[] args) {

		sort1();
		System.out.println("---------这是分割线-----------");
		sort2();

	}

	// 正儿八经的选择排序
	private static void sort1() {
		int a[] = new int[] { 99, 3, 2, 0, 4, 6, 7, 5, 8, 9 };
		for (int i = 0; i < 10; i++) {
			System.out.println("-----------" + i + "--------------");
			// 剩余最小数据中的下标
			int min_indx = i;
			for (int j = i + 1; j < 10; j++) {
				if (a[j] < a[min_indx]) {
					min_indx = j;
				}
			}
			// 交换当前i和当前最小下标
			int temp = a[i];
			a[i] = a[min_indx];
			a[min_indx] = temp;
			System.out.println(Arrays.toString(a));
		}
	}

	// bug 触目精心
	private static void sort2() {
		int a[] = new int[] { 99, 3, 2, 0, 4, 6, 7, 5, 8, 9 };
		for (int i = 0; i < 10; i++) {
			System.out.println("-----------" + i + "--------------");
			int min_indx = i;
			for (int j = i + 1; j < 10; j++) {
				if (a[j] < a[i]) {
					min_indx = j;
				}
			}
			int temp = a[i];
			a[i] = a[min_indx];
			a[min_indx] = temp;
			System.out.println(Arrays.toString(a));
		}
	}
}
