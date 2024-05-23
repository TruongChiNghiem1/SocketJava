package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.EntityManagerFactoryUtil;
import dao.Patient_DAO;
import entities.Patient;
import jakarta.persistence.EntityManager;

public class Server {
	public static void main(String[] args) throws IOException{
		try (ServerSocket serverSocket = new ServerSocket(2000)){
			ExecutorService executorService = Executors.newCachedThreadPool();
			System.out.println("Server run on port 2000");
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
				
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				
				executorService.execute(clientHandler);
			}
		}
	}
	
	private static class ClientHandler implements Runnable {
		private Socket socket;
		private ObjectInputStream in;
		private ObjectOutputStream out;
		private EntityManagerFactoryUtil managerFactoryUtil;
		private EntityManager entityManager;
		
		public ClientHandler(Socket socket) {
			super();
			// TODO Auto-generated constructor stub
			this.socket = socket;
			this.managerFactoryUtil = new EntityManagerFactoryUtil();
			this.entityManager = managerFactoryUtil.getEnManager();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				String command = in.readUTF();
				switch (command) {
				case "add-patient":
					handleAddPatient();
					break;
				default:
					out.writeUTF("Lệnh không xác định từ client");
					out.flush();
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					in.close();
					out.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				managerFactoryUtil.closeEnManager();
				managerFactoryUtil.closeEnManagerFactory();
			}
			
		}
		
		private void handleAddPatient() throws ClassNotFoundException, IOException {
			Patient patient = (Patient) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			patientDAO.add(patient);
			
			out.writeUTF("Thêm bệnh nhân thành công");
			out.writeObject(patient);
			out.flush();
		}
		
	}
}
