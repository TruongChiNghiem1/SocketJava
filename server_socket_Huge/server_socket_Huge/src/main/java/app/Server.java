package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.Doctor_DAO;
import dao.EntityManagerFactoryUtil;
import dao.Patient_DAO;
import entities.Doctor;
import entities.Patient;
import jakarta.persistence.EntityManager;

public class Server {
	public static void main(String[] args) throws IOException {
		try(ServerSocket serverSocket = new ServerSocket(2901)){
		ExecutorService executorService = Executors.newCachedThreadPool();
		System.out.println("Server is running...");
		while(true) {
			Socket clientsocket = serverSocket.accept();
			System.out.println("Client connected: " + clientsocket);
			ClientHandler clientHandler = new ClientHandler(clientsocket);
			
            executorService.execute(clientHandler);
		}
		}
	}
	public static class ClientHandler implements Runnable {
		private Socket socket;
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private EntityManagerFactoryUtil entityManagerFactoryUtil;
		private EntityManager entityManager;
		public ClientHandler(Socket socket) {
			super();
			this.socket = socket;
			this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
			this.entityManager = entityManagerFactoryUtil.getEntityManager();
		}
		
		@Override
			public void run() {
				// TODO Auto-generated method stub
				
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				String command = in.readUTF();
				
				switch (command) {
				case "add-Patient":
					handleAddPatient();
					break;
				case "delete-Patient":
					handlerDeletePatient();
					break;
				case "find-Doctor":
					handlerFindDoctorBySpecialty();
					break;

				default:
					out.writeUTF("Lệnh không xác định từ client");
					out.flush();
					break;
				}
			} catch (IOException | ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					in.close();
					out.close();
				} catch (IOException ioe) {
					// TODO: handle exception
					ioe.printStackTrace();
				}
				entityManagerFactoryUtil.closeEnManager();
				entityManagerFactoryUtil.closeEnManagerFactory();
			}
			}
		
		private void handleAddPatient() throws IOException, ClassNotFoundException{
			Patient patient = (Patient) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			patientDAO.addPatient(patient);
			
			out.writeUTF("Thêm thành công");
			out.writeObject(patient);
			out.flush();
		}
		
		private void handlerDeletePatient() throws IOException, ClassNotFoundException{
			String ma = (String) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			patientDAO.deletePatient(ma);
			
			out.writeUTF("Xóa thành công");
			out.flush();
		}
		
		private void handlerFindDoctorBySpecialty() throws IOException, ClassNotFoundException{
			String specialty = (String) in.readObject();
			Doctor_DAO doctorDAO = new Doctor_DAO(entityManager);
			List<Doctor> l =  doctorDAO.findDoctorBySpeciality(specialty);
			
			out.writeObject(l);
			out.flush();
		}
		
	}
}