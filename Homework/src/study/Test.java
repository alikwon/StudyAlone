package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Test {
	static enum Company {
		APPLE
	}

	static class Fruit2 {
		public final static Fruit2 apple = new Fruit2();
		public final static Fruit2 banana = new Fruit2();
	}

	static class Company2 {
		public final static Company2 apple = new Company2();
		public final static Company2 google = new Company2();
	}

	public static void main(String[] args) {
		Company type = Company.APPLE;
		Fruit2 a =Fruit2.apple;
		switch (type) {
		case APPLE:
			System.out.println(a);
			break;

		default:
			break;
		}
	}
}
