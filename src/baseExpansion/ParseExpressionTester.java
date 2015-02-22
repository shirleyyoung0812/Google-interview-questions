package baseExpansion;

public class ParseExpressionTester {

	public static void main(String[] args) {
		ParseExpression pe = new ParseExpression("(a(b,c)d,e)");
		for (String s : pe.parseString()) {
			System.out.println(s);
		}
		// TODO Auto-generated method stub

	}

}
