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

public class ServerRun {
	public static void main(String[] args) throws IOException {
		try(ServerSocket serverSocket = new ServerSocket(2000)){
			ExecutorService executorService = Executors.newCachedThreadPool();
			System.out.println("server run 2000");
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Socket run " + clientSocket);
				
				HandleServer handleServer = new HandleServer(clientSocket);
				executorService.execute(handleServer);
			}
		}
	}
	
	private static class HandleServer implements Runnable{
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
					break;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
				try {
					in.close();
					out.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				en.closeEntityManager();
				en.closeEntityManagerFactory();
			}
		}
		
		private void handleAddPatient() throws ClassNotFoundException, IOException {
			Patient p = (Patient) in.readObject();
			Patient_DAO patientDAO = new Patient_DAO(entityManager);
			
			patientDAO.add(p);
			
			out.writeUTF("them thanh cong");
			out.writeObject(p);
			out.flush();
			
		}
		
	}
}
