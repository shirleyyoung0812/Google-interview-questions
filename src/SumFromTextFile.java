import java.io.BufferedReader;
import java.io.FileReader;


public class SumFromTextFile {
	public static void sumFile(String name) {
		BufferedReader in = null;
		try {
			int total = 0;
			in = new BufferedReader(new FileReader(name));
			String s;
			while ((s = in.readLine()) != null) {
				total += Integer.parseInt(s);
			}
			System.out.println("Sum: " + total);
		}
		catch (Exception e) {
			//Prints this throwable and its backtrace to the standard error stream. 
			//This method prints a stack trace for this Throwable object on the error output stream 
			//that is the value of the field System.err. The first line of output contains the result 
			//of the toString() method for this object. Remaining lines represent data previously recorded 
			//by the method fillInStackTrace(). 
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sumFile("/Users/shirleyyoung/Documents/workspace/Google/numbers.txt");
	}

}
