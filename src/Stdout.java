

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Stdout {
	private PrintWriter writer;
	
	public Stdout(String fileName) {
		try {
			writer
			   = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not create" + fileName);
		}
	}
	public void close() {
		writer.close();
	}
	
	public void write(String x) {
		writer.write(x + "\n");
	}	
	
}
