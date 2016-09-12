package test;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = "";
		while (sc.hasNext()) {

			line = sc.nextLine();
			String[] twonum = line.split(" ");

			System.out.println(add2(twonum[0], twonum[1]));

		}

	}

	/**
	 * 用字符串模拟两个大数相加
	 * 
	 * @param n1
	 *            加数1
	 * @param n2
	 *            加数2
	 * @return 相加结果
	 */
	public static String add2(String n1, String n2) {
		StringBuffer result = new StringBuffer();
		String ret = "error";
		// 1、反转字符串
		n1 = new StringBuffer(n1).reverse().toString();
		n2 = new StringBuffer(n2).reverse().toString();

		int len1 = n1.length();
		int len2 = n1.length();
		int maxLen = len1 > len2 ? len1 : len2;
		boolean nOverFlow = false; // 是否越界
		int nTakeOver = 0; // 溢出数量

		// 2.把两个字符串补齐，即短字符串的高位用0补齐
		if (len1 < len2) {
			for (int i = len1; i < len2; i++) {
				n1 += "0";
			}
		} else if (len1 > len2) {
			for (int i = len2; i < len1; i++) {
				n2 += "0";
			}
		}

		try {

			// 3.把两个正整数相加，一位一位的加并加上进位
			for (int i = 0; i < maxLen; i++) {
				int nSum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "");

				if (nSum >= 10) {
					if (i == (maxLen - 1)) {
						nOverFlow = true;
					}
					nTakeOver = 1;
					result.append(nSum - 10);
				} else {
					nTakeOver = 0;
					result.append(nSum);
				}
			}

			// 如果溢出的话表示位增加了
			if (nOverFlow) {
				result.append(nTakeOver);
			}

			ret = result.reverse().toString();
		} catch (Exception e) {
			// TODO: handle exception
			ret = "error";
		}

		return ret;
	}

}
