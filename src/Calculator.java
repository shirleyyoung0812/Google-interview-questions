/**
 * design and implement a calculater that can calculate expressions like: 
 * + 2 4 
 * * 8 ( + 7 12) 
 * ( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 ) 
 * 
 * (PS:all items are space delimetered.) 
 * Example answers 
 * + 2 4 => 2 + 4 = 6 
 * * 8 ( + 7 12) => 8 * ( 7 + 12 ) = 152 
 * ( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 ) => 7+8*12+2*(9+4)*7+3 = 288
 * @author shirleyyoung
 *
 */
import java.util.*;
public class Calculator {
	public static int operation(String s) {
		if (s == null || s.length() == 0)
			throw new IllegalArgumentException("Null or empty string, cannot provide operation!");
		String[] items = s.split(" ");
		
		Stack<String> stack = new Stack<String> ();
		int index = 0;
		while (index < items.length) {
			if (items[index].equals(")")) {
				int rst = operate(stack);
				stack.pop();
				stack.push(String.valueOf(rst));
			}
			else {
				stack.push(items[index]);
			}
			index++;
		}
		if (stack.size() == 1)
			return Integer.parseInt(stack.pop());
		int rst = operate(stack);
		return rst;
		
	}
	private static int operate(Stack<String> stack) {
		String operators = "(+-*/)";
		Stack<Integer> tmp = new Stack<Integer> ();
		while (!stack.isEmpty() && !operators.contains(stack.peek())) {
			tmp.push(Integer.valueOf(stack.pop()));
		}
		if (stack.isEmpty())
			throw new IllegalArgumentException("Cannot find operator!");
		if (tmp.size() == 1) {
			if (stack.peek().equals("(")) {
				return(tmp.pop());
			}
			else 
				throw new IllegalArgumentException("Not enough input numbers!");
		}
		String operator = stack.pop();
		int rst = 0;
		if (operator.equals("+")) {	
			while (!tmp.isEmpty())
				rst += tmp.pop();
		}
		else if (operator.equals("-")) {
			rst = tmp.pop();
			while (!tmp.isEmpty())
				rst -= tmp.pop();
		}
		else if (operator.equals("*")) {
			rst = 1;
			while (!tmp.isEmpty())
				rst *= tmp.pop();
		}
		else if (operator.equals("/")) {
			rst = tmp.pop();
			while (!tmp.isEmpty())
				rst /= tmp.pop();
		}
		else 
			throw new IllegalArgumentException("Cannot find the operator!");
		return rst;
	}
	public static void main(String[] args) {
		System.out.println(operation("+ 2 4"));
		System.out.println(operation("* 8 ( + 7 12 )"));
		System.out.println(operation("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )"));
		System.out.println(operation("+ ( / 8 2 ) ( - 6 3 ) ( * 5 2 )"));

	}

}
