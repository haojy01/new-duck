package org.donald.duck.algorithms.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PingPang {

	public static void main(String[] args) {

		List<String> A = new ArrayList<String>();
		A.add("a");
		A.add("b");
		A.add("c");

		List<String> B = new ArrayList<String>();
		B.add("x");
		B.add("y");
		B.add("z");

		Map<String, List<String>> condition = new HashMap<String, List<String>>();
		condition.put("a", new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				this.add("x");
			}
		});
		condition.put("b", new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				this.add("x");
				this.add("z");
			}
		});

		List<String> ab = new ArrayList<String>();

		/*
		 * for (int h = 0; h < A.size() * B.size(); h++) { for (int i = 0; i <
		 * A.size(); i++) { for (int j = 0; j < B.size(); j++) {
		 * 
		 * List<String> temp = condition.get(A.get(i)); if (temp != null &&
		 * temp.contains(B.get(j))) { continue; }
		 * 
		 * if (ab.contains(A.get(i)) || ab.contains(B.get(j))) { continue; }
		 * ab.add(A.get(i)); ab.add(B.get(j)); System.out.println(A.get(i) +
		 * "----" + B.get(j)); } } ab = new ArrayList<String>();
		 * System.out.println("=========="); }
		 */

		/*for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(i + "*" + j + " ");
			}
			System.out.println("");
		}*/
	}
}
