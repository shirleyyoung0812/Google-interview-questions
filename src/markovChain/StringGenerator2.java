package markovChain;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
public class StringGenerator2 {
	private class Frequency{
		String s;//hashcode of the string
		int count;//occurrence
		public Frequency(String s, int c){
			this.s = s;
			this.count = c;
		}
	}
	Map<String, List<Frequency>> table;
	Random r;
	public StringGenerator2(String fileName) throws FileNotFoundException, IOException{
		table = new HashMap<String, List<Frequency>> ();
		r = new Random();
		generateTable(fileName);
		assert(isUniqueList());
	}
	public void generateTable(String fileName) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		String last = null;
		while((line = reader.readLine()) != null){
			String[] row = line.split(" ");
			for(String s : row){
				String puntua = null;
				if(!Character.isLetter(s.charAt(s.length() - 1))){
					puntua = s.substring(s.length() - 1);
					s = s.substring(0, s.length() - 1);
				}
				if(!table.containsKey(s))
					table.put(s, new ArrayList<Frequency> ());
				if(last != null)
					add(table.get(last), s);
				if(puntua != null)
					add(table.get(s), puntua);
				last = s;
			}
		}
		reader.close();
		mapFrequency();
	}
	private void add(List<Frequency> next, String s){
		int index = -1;
		for(int i = 0; i < next.size(); i++){
			if(next.get(i).s.equals(s)){
				index = i;
				break;
			}
		}
		if(index != -1)
			next.get(index).count++;
		else
			next.add(new Frequency(s, 1));
	}
	private void mapFrequency(){
		for(Entry<String, List<Frequency>> e : table.entrySet()){
			List<Frequency> next = e.getValue();
			for(int i = 1; i < next.size(); i++){
				next.get(i).count += next.get(i - 1).count;
			}
		}
	}
	private boolean isUniqueList(){
		Set<String> words = new HashSet<String> ();
		for(List<Frequency> next : table.values()){
			words.clear();
			for(Frequency f : next){
				if(!words.add(f.s))
					return false;
			}
		}
		return true;
	}
	public void generator(String outputName, int length) throws IOException{
		if(table.size() == 0){
			System.out.println("No training set found!");
			return;
		}
		FileWriter writer = new FileWriter(outputName);
		int index = 0;
		String last = null;
		int countWord = 0;//number of words in one line
		while(index < length){
			String s = null;
			if(last == null || !table.containsKey(last)){
				//generate a random string from the key set
				Object[] keys = table.keySet().toArray();
				s = (String) keys[r.nextInt(keys.length)];
			} else
				s = getNext(table.get(last));
			writer.append(s).append(" ");
			countWord++;
			if(countWord == 15){
				writer.append("\n");
				countWord = 0;
			}
			last = s;
			index++;
		}
		writer.append(".\n");
		writer.flush();
		writer.close();
	}
	private String getNext(List<Frequency> next){
		int size = next.size();
		int nextIndex = r.nextInt(next.get(size - 1).count) + 1;
		for(Frequency f : next){
			if(nextIndex <= f.count)
				return f.s;
		}
		return next.get(r.nextInt(size)).s;
	}
		
}
