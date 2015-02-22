package baseExpansion;
import java.util.*;
public class ParseExpression {
	private static String s;
	private static int index;
	
	public ParseExpression(String s) {
		ParseExpression.s = s;
		index = 0;
	}
	public List<String> parseString() {
		return parseExpression(false);
	}
	private List<String> parseExpression(boolean para) {
		List<String> rst = new ArrayList<String> ();
		while (!eof()) {
			List<String> components = parseComponent(para);
			rst.addAll(components);
			if (s.charAt(index) == ',')
				continue;
			else
				break;
		}
		return rst;
	}
	
	private List<String> parseComponent(boolean para) {
		List<String> leftComponent = null;
		while (!eof() && s.charAt(index) != ',') {
			List<String> rightComponent = parseComponentPart(para);
			if (rightComponent == null)
				break;
			if (leftComponent == null)
				leftComponent = rightComponent;
			else 
				leftComponent = combine(leftComponent, rightComponent);
		}
		return leftComponent;
	}
	private List<String> parseComponentPart(boolean para) {
		char curr = s.charAt(index);
		List<String> rst = new ArrayList<String> ();
		if (curr == '(') {
			index++;
			rst = parseExpression(true);
			index++;
			return rst;
		}
		else if (Character.isLetter(curr)) {
			StringBuilder sb = new StringBuilder();
			while (Character.isLetter(curr)) {
				//if (curr == ')' && para)
					//break;
				sb.append(curr);
				curr = s.charAt(++index);
			}
			rst.add(sb.toString());
			return rst;
		}
		else {
			return null;
		}
	}
	
	private List<String> combine(List<String> leftComponent, List<String> rightComponent) {
		List<String> rst = new ArrayList<String> ();
		for (String left : leftComponent) {
			for (String right : rightComponent) {
				rst.add(left + right);
			}
		}
		return rst;
	}
	private boolean eof() {
		return index == s.length();
	}

}
