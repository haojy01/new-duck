package org.donald.duck.algorithms.chapter1;

/**
 * 求最大公约数 欧吉理德算法
 */

public class CommonDivisor {

	/**
	 * 递归
	 */
	public static int commonDivisor(int p, int q) {

		if (q == 0) {
			return p;
		}
		int r = p % q;
		return commonDivisor(q, r);
	}

	/**
	 * 迭代
	 */
	public static int commonDivisor2(int p, int q) {

		for (;;) {
			if (q == 0) {
				break;
			}
			int temp_p = p;
			int temp_q = q;
			p = q;
			q = temp_p % temp_q;
		}
		return p;
	}

	public static void main(String[] args) {
		int commonDivisor = commonDivisor2(10, 2);
		System.out.println(commonDivisor);
	}
}
