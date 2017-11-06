
public class IPv6Packet {

	public byte[] header;
	private int[] IPDest = {18,221,102,182};
	
	public IPv6Packet(int payloadSize){
		header = new byte[40+payloadSize];
		header[0] = (6 << 4);
		
		header[4] = (byte)(payloadSize>>8);
		header[5] = (byte)payloadSize;
		
		header[6] = 17;	
		header[7] = 20;
		
		header[18] = (byte)255;
		header[19] = (byte)255;
		header[20] = (byte)192;
		header[21] = (byte)168;
		header[22] = (byte)24;
		header[23] = (byte)1;
		
		header[34] = (byte)0xFF;
		header[35] = (byte)0xFF;
		header[36] = (byte)IPDest[0];
		header[37] = (byte)IPDest[1];
		header[38] = (byte)IPDest[2];
		header[39] = (byte)IPDest[3];				
	}
	
}
