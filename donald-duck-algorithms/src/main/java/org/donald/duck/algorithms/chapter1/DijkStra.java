package org.donald.duck.algorithms.chapter1;

public class DijkStra {

	public static void main(String args[]) {

		String[] a = new String[17];
		a[0] = "(";
		a[1] = "1";
		a[2] = "+";
		a[3] = "(";
		a[4] = "(";
		a[5] = "2";
		a[6] = "+";
		a[7] = "3";
		a[8] = ")";
		a[9] = "*";
		a[10] = "(";
		a[11] = "4";
		a[12] = "*";
		a[13] = "5";
		a[14] = ")";
		a[15] = ")";
		a[16] = ")";

		Stack<String> num = new Stack<String>();
		Stack<String> operator = new Stack<String>();

		for (String str : a) {
			if ("+".equals(str)) {
				operator.push(str);
			} else if ("-".equals(str)) {
				operator.push(str);
			} else if ("*".equals(str)) {
				operator.push(str);
			} else if ("/".equals(str)) {
				operator.push(str);
			} else if ("(".equals(str)) {
			} else if (")".equals(str)) {
				Integer num1 = Integer.parseInt(num.pop());
				Integer num2 = Integer.parseInt(num.pop());
				String oper = operator.pop();
				String result = "";
				if ("+".equals(oper)) {
					result = (num1 + num2) + "";
				} else if ("-".equals(oper)) {
					result = (num1 - num2) + "";
				} else if ("*".equals(oper)) {
					result = (num1 * num2) + "";
				} else if ("/".equals(oper)) {
					result = (num1 / num2) + "";
				}
				num.push(result);
			} else { // 数字
				num.push(str);
			}
		}
		System.out.println(num.pop());
	}
}
