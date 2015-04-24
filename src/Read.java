



public class Read { 
	public int read2(byte[] buff, int sizeInBytes){
		int index = 0, next = 0;
		//assume return -1 if reach the end of the file
		byte[] tmp = new byte[256];
		while(index < sizeInBytes && (next = readFromDisk(tmp))!= -1)
			for(int i = 0; i< next && index < sizeInBytes; buff[index++] = tmp[i++]);
		return index;
	}
	public int readFromDisk(byte[] buff){
		return 256;
	}
	
	public void read(int sizeInBytes) {
		//readFromDisk() will read 256 bytes and put into 
		//the byte array, so we only need the size / 256
		int size = sizeInBytes / 256;
		byte[] b = new byte[size];
		int c = readFromDisk();
		//assume readFromDisk() will return -1 if the 
		//length is less than 256
		if(c == -1)
			return;
		b[0] = (byte)c;
		int i = 1;
		for(; i < size; i++){
			c = readFromDisk();
			//reach the end of the file
			if(c == -1)
				break;
			b[i] = (byte)c;
		}
	}
	public int readFromDisk(){
		return 255;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
