package markovChain;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StringTester {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		StringGenerator2 sg = new StringGenerator2("/Users/shirleyyoung/Documents/workspace/Google/testString.txt");
		
		sg.generator("/Users/shirleyyoung/Documents/workspace/Google/output.txt", 300);
	}

}
