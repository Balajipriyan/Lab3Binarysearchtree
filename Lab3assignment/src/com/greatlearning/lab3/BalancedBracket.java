package com.greatlearning.lab3;
import java.util.*;
public class BalancedBracket {

	static boolean isBracketsBalanced(String value)
	{
		Deque<Character> inputvalue = new ArrayDeque<Character>();
		for (int i = 0; i < value.length(); i++) {
			char b = value.charAt(i);

			if (b == '(' || b == '[' || b == '{') {
				inputvalue.push(b);
				continue;
			}
			if (inputvalue.isEmpty())
				return false;
			char a;
			switch (b) {
			case '}':
				a = inputvalue.pop();
				if (a == '(' || a == '[')
					return false;
				break;

			case ')':
				a = inputvalue.pop();
				if (a == '{' || a == '[')
					return false;
				break;

			case ']':
				a = inputvalue.pop();
				if (a == '(' || a == '{')
					return false;
				break;
			}
		}

		return (inputvalue.isEmpty());
	}

	public static void main(String[] args)
	{
		String value = "([{}])";
		if (isBracketsBalanced(value))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}
}

