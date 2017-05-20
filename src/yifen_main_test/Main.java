package yifen_main_test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BigInteger a,b;
		Scanner in = new Scanner(System.in);
		a = in.nextBigInteger();
		b = in.nextBigInteger();
		System.out.println(a.add(b));
	}
}
