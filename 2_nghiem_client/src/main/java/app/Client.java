package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;import java.net.ServerSocket;
import java.net.Socket;

import entities.Patient;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try(Socket severSocket = new Socket("192.168.1.22", 2000)){
			ObjectOutputStream out = new ObjectOutputStream(severSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(severSocket.getInputStream());
			
			Patient p = new Patient("P1" ,"123 address", 20, "Nghiệm", "Male", "Trương Chí", "0993394955");
			System.out.println(p);
			
			out.writeUTF("add-patient");
			out.writeObject(p);
			out.flush();
			
			String phanHoiServer = in.readUTF();
			if(phanHoiServer.equals("them thanh cong")){
				Patient p1 = (Patient) in.readObject();
			} else {
				System.out.println("lenh khong xac dinh");
			}
		}
	}
}
