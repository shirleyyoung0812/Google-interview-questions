

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public final class Stdin {
	private Scanner scanner;
	//assume UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";
	//assume language = English, country = US for consistency with System.out.
	private static final Locale LOCALE = Locale.US;
	public Stdin() {
		scanner = new Scanner(new BufferedInputStream(System.in), CHARSET_NAME);
		/*
		 * Sets this scanner's locale to the specified locale.
		 * A scanner's locale affects many elements of 
		 * its default primitive matching regular expressions;
		 */
		scanner.useLocale(LOCALE);
	}
	/**
	 * read an input stream from a file name or a URL
	 * @param fileName
	 */
	public Stdin(String s) {
		try {
			File file = new File(s);
			scanner = new Scanner(file, CHARSET_NAME);
			scanner.useLocale(LOCALE);
			//System.out.println("File open!");
		}
		catch (IOException ioe) {
			System.err.println("Could not open " + s);
		}
	}
	/**
	 * read the next line
	 * @return
	 */
	public String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		}
		catch (Exception e) {
			line = null;
		}
		return line;
	}
	
	public boolean exists() {
		return scanner != null;
	}
	public boolean isEmpty() {
		return !scanner.hasNext();
	}
	public boolean hasNextLine() {
		return scanner.hasNextLine();
	}
	public void close() {
		scanner.close();
	}
}
