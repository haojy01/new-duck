package org.donald.duck.algorithms.chapter1;

import java.util.Arrays;

import org.donald.duck.util.In;
import org.donald.duck.util.StdIn;
import org.donald.duck.util.StdOut;

public class BinarySearch {

	private BinarySearch() {
	}

	//二分查找
	public static int indexOf(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	@Deprecated
	public static int rank(int key, int[] a) {
		return indexOf(a, key);
	}

	public static void main(String[] args) {

		// read the integers from a file
		In in = new In("/home/haojy/github/tinyT.txt");
		int[] whitelist = in.readAllInts();

		// sort the array
		Arrays.sort(whitelist);

		// read integer key from standard input; print if not in whitelist
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (BinarySearch.indexOf(whitelist, key) == -1)
				StdOut.println(key);
		}
	}
}
