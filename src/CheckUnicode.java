import java.io.UnsupportedEncodingException;
/**
 * After given clearly definition of UTF-8 format. ex: 1-byte   : 0b0xxxxxxx 2- bytes:.... 
 * Asked to write a function to validate whether the input is valid UTF-8. 
 * Input will be string/byte array, output should be yes/no. 
 * @author shirleyyoung
 *
 */

public class CheckUnicode {
	//using java library
	//only byte data can be checked, a string is already UTF-16 internally
	//only byte arrays can be UTF-8 encoded
	public static byte[] getByte(String s){
		byte[] bytes = null;
		try{
			bytes = s.getBytes("UTF-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
			System.exit(-1);
		}
		return bytes;
	}
	public static boolean isUTF8(String s){
		try{
			byte[]bytes = s.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			System.exit(-1);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String original = " ";
		System.out.println(isUTF8(original));
		byte[] bytes = getByte(original);
		for(byte b : bytes){
			System.out.println(b);
		}
		byte[] bytes1 = new byte[2];
		bytes1[0] = (byte) 0b1111111;
		bytes1[1] = (byte)0xbf;
		System.out.println(bytes1[0]);
		String s = new String(bytes1);
		System.out.println(s + "***");
	}

}
