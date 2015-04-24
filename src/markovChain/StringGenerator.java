package markovChain;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
public class StringGenerator {
	List<String> trainingSet;
	String file;
	public StringGenerator(String file) throws FileNotFoundException, IOException{
		this.file = file;
		trainingSet = new ArrayList<String> ();
		read();
	}
	/**
	 * read training set and buffered it into a list
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void read() throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null){
			String[] row = line.split(" ");
			for(String s : row)
				trainingSet.add(s);
		}
		reader.close();		
	}
	/**
	 * Generate frequency table
	 * @param output
	 * @param length
	 * @throws IOException
	 */
	private Map<String, List<Frequency>> generateTable(){
		Map<String, List<String>> frequencyTable = new HashMap<String, List<String>> ();
		frequencyTable.put(trainingSet.get(0), new ArrayList<String> ());
		for(int i = 1; i < trainingSet.size(); i++){
			String s = trainingSet.get(i);
			String p = null;
			if(!Character.isLetter(s.charAt(s.length() - 1))){
				p = s.substring(s.length() - 1, s.length());
				s = s.substring(0, s.length() - 1);
			}
			if(!frequencyTable.containsKey(s)){
				frequencyTable.put(s, new ArrayList<String> ());
				if(p != null)
					frequencyTable.get(s).add(p);
			}
			String last = trainingSet.get(i - 1);
			if(!Character.isLetter(last.charAt(last.length() - 1)))
				last = last.substring(0, last.length() - 1);
			frequencyTable.get(last).add(s);	
		}
		Map<String, List<Frequency>> nextFrequency = getFrequency(frequencyTable);
		return nextFrequency;
	}
	private Map<String, List<Frequency>> getFrequency(Map<String, List<String>> frequencyTable){
		Map<String, List<Frequency>> countFre = new HashMap<String, List<Frequency>>();
		for(Entry<String, List<String>> e : frequencyTable.entrySet()){
			String key = e.getKey();
			List<String> next = e.getValue();
			Map<String, Integer> f = new HashMap<String, Integer>();
			for(String s : next){
				if(!f.containsKey(s))
					f.put(s, 1);
				else
					f.put(s, f.get(s) + 1);
			}
			List<Frequency> nextFrequency = mapFrequency(f);
			countFre.put(key, nextFrequency);	
		}
		return countFre;
	}
	private List<Frequency> mapFrequency(Map<String, Integer> f){
		String[] array = new String[f.size()];
		int[] c = new int[f.size()];
		int index = 0;
		for(Entry<String, Integer> ec : f.entrySet()){
			array[index] = ec.getKey();
			c[index] = ec.getValue();
			index++;
		}
		for(int i = 1; i < c.length; i++){
			c[i] += c[i - 1];
		}
		List<Frequency> rst = new ArrayList<Frequency> ();
		for(int i = 0; i < c.length; i++)
			rst.add(new Frequency(array[i], c[i]));
		return rst;
	}
	
	
	/**
	 * generate the string
	 * @param output
	 * @param length
	 * @throws IOException
	 */
	public void Generator(String output, int length) throws IOException{
		if(trainingSet.size() == 0){
			System.out.println("No training set found!");
			return;
		}
		Map<String, List<Frequency>> nextFrequency = generateTable();
		Random r = new Random();
		FileWriter writer = new FileWriter(output);
		int i = 0;
		String last = null;
		int countWord = 0;
		while(i < length){
			String s = null;
			if(last == null || !nextFrequency.containsKey(last))
				s = trainingSet.get(r.nextInt(trainingSet.size()));
			else
				s = getNext(nextFrequency.get(last));
			writer.append(s).append(" ");
			countWord++;
			if(countWord == 15){
				writer.append("\n");
				countWord = 0;
			}
			last = s;
			i++;
		}
		writer.append(".\n");
		writer.flush();
		writer.close();
	}
	private String getNext(List<Frequency> nextFre){
		int size = nextFre.size();
		Random r = new Random();
		int next = r.nextInt(nextFre.get(size - 1).count) + 1;
		for(Frequency f : nextFre){
			if(next <= f.count)
				return f.s;
		}
		return nextFre.get(r.nextInt(size)).s;
	}
	/**
	 * the structure that contains the string and its count
	 * @author shirleyyoung
	 *
	 */
	private class Frequency{
		String s;
		int count;
		public Frequency(String s, int c){
			this.s = s;
			count = c;
		}
	}	
}
