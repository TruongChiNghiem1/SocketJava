package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import entities.Doctor;
import entities.Patient;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Scanner SC = new Scanner(System.in);
		try (Socket socket = new Socket("192.168.1.11", 2000)){
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			Patient p = new Patient("P1", "aaa", 30, "truong chi", "nam", "nghiem", "023232");
			System.out.println("1/ add \n2/ delete \n3/ find \n");
			
			String phimBam = SC.nextLine();
			switch (phimBam) {
			case "1":
				out.writeUTF("add-patient");
				out.writeObject(p);
				out.flush();
				
				String phanHoiCuaServer = in.readUTF();
				if(phanHoiCuaServer.equals("them thanh cong")) {
					Patient p1 = (Patient) in.readObject();
					System.out.println(p1);
				} else {
					System.out.println("lenh khong xac dinh");
				}
				break;
			case "2":
				System.out.println("nhap id can xoa: ");
				String idDelete = SC.nextLine();
				out.writeUTF("delete-patient");
				out.writeObject(idDelete);
				out.flush();
				
				String phanHoiCuaServerDelete = in.readUTF();
				if(phanHoiCuaServerDelete.equals("xoa thanh cong")){
					System.out.println("xoa nhan vien thanh cong");
				} else {
					System.out.println("loi du lieu xoa");
				}
				
				break;
			case "3":
				System.out.println("Tim bac si theo chuyen mon\n");
				System.out.println("Nhap chuyen mon: ");
				String chuyenMon = SC.nextLine();
				
				out.writeUTF("find-doctor");
				out.writeObject(chuyenMon);
				out.flush();
				
				String phanHoiServerFind = in.readUTF();
				if(phanHoiServerFind.equals("tim thanh cong")) {
					List<Doctor> listDoctor = (List<Doctor>) in.readObject();
					for (Doctor doctor : listDoctor) {
						System.out.println("Ket qua: " + doctor);
					}
				} else {
					System.out.println("Loi du lieu tim");
				}
				break;
			case "4":
				out.writeUTF("find-doctor-department");
				out.flush();
				
				String phanHoi = in.readUTF();
				if(phanHoi.equals("tim thanh cong")) {
					List<Object[]> listDoctor = (List<Object[]>) in.readObject();
					for (Object[] objectne : listDoctor) {
						System.out.println("phong " + objectne[0] + " co " + objectne[1]);
					}
				}
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
