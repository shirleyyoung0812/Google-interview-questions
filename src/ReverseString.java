/**
 * Write a function to reverse a string.
 * "Madam, I'm Adam":   madA m'I ,madaM
 * @author shirleyyoung
 *
 */
public class ReverseString {
	public static String reverse (String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] array = s.toCharArray();
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			swap(array, start, end);
			start++;
			end--;
		}
		return new String(array);
		
	}
	private static void swap(char[] array,int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println(reverse("Madam, I'm Adam"));
		

	}

}
