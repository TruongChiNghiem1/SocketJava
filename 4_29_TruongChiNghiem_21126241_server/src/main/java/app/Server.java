package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.Doctor_DAO;
import dao.EntityManagerFactoryUtil;
import dao.Patient_DAO;
import entities.Doctor;
import entities.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Server {
	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(2000)){
			ExecutorService executorService = Executors.newCachedThreadPool();
			System.out.println("Server run 2000");
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("client accept " + clientSocket);
				
				HandleServer handleServer = new HandleServer(clientSocket);
				executorService.execute(handleServer);
			}
		}
	}
	
	private static class HandleServer implements Runnable {
		private Socket socket;
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private EntityManagerFactoryUtil en;
		private EntityManager entityManager;
		
		
		
		public HandleServer(Socket socket) {
			super();
			this.socket = socket;
			this.en = new EntityManagerFactoryUtil();
			this.entityManager = en.getEntityManager();
		}


		public void run() {
			// TODO Auto-generated method stub
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				
				String request = in.readUTF();
				switch (request) {
				case "add-patient":
					handleAddPatient();
					break;
				case "delete-patient":
					handleDeletePatient();
					break;
				case "find-doctor":
					handleFindDoctor();
					break;
				case "find-doctor-department":
					handleFindDoctorDepartment();
				default:
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					in.close();
					out.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				en.closeEntityManager();
				en.closeEntityManagerFactory();
			}
		}


		private void handleFindDoctorDepartment() throws ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			Doctor_DAO doctorDAO = new Doctor_DAO(entityManager);
			
			List<Object[]> d = doctorDAO.findDoctorDepartment();
			
			out.writeUTF("tim thanh cong");
			out.writeObject(d);
			out.flush();
		}


		private void handleFindDoctor() throws ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			Doctor_DAO doctorDAO = new Doctor_DAO(entityManager);
			List<Object[]> listDoctor = doctorDAO.findDoctorDepartment();
		
			out.writeUTF("tim thanh cong");
			out.writeObject(listDoctor);
			out.flush();
		}


		private void handleDeletePatient() throws ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			String idDelete = (String) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			if(patientDAO.delete(idDelete)) {
				out.writeUTF("xoa thanh cong");
			} else {
				out.writeUTF("xoa khong thanh cong");
			}
			out.flush();
		}


		private void handleAddPatient() throws ClassNotFoundException, IOException {
			// TODO Auto-generated method stub
			Patient p = (Patient) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			
			patientDAO.add(p);
			
			out.writeUTF("them thanh cong");
			out.writeObject(p);
			out.flush();
		}
		
	}
}
