package practice.algorithm_practice_for_grammar_study;

import java.util.Stack;

public class Test {
		public static void main(String[] args) {
			Stack<String> stack = new Stack<>();

			String str = "Hello, World!";

			for (int i = 0; i < str.length(); i++) {
				stack.push(String.valueOf(str.charAt(i)));
			}

			stack.forEach(System.out::print);


			System.out.println();

			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}

		}
}
