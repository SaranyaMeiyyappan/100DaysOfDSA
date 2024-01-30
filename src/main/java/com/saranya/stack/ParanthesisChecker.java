package main.java.com.saranya.stack;

import java.util.HashMap;
import java.util.Stack;

public class ParanthesisChecker {

	public static void main(String[] args) {
		String s = "{([])(){}(())()()}";
		System.out.println(isValid(s));
	}

	private static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			Character c = s.charAt(i);
			if(map.containsKey(c)) {
				if((stack.isEmpty()?'#':stack.pop())!=map.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}

}
