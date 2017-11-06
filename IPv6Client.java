import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class IPv6Client {

	public static void main(String[] args) throws Exception{
		try (Socket socket = new Socket("18.221.102.182", 38004)) {
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			int size = 2;
			
			for (int i = 0; i < 12; i++,size*=2){
				System.out.println("data length: "+size);
				IPv6Packet p = new IPv6Packet(size);
				os.write(p.header);
				System.out.print("Code: ");
				for(int j = 0; j < 4; j++){
					System.out.printf("%02X", is.read());
				}
				System.out.println();
			}			
		}
	}

}
