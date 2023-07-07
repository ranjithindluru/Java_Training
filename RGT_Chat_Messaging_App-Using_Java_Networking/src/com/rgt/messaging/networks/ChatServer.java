package com.rgt.messaging.networks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatServer {
	
	/**
	 * Declare the private int variable of Port and 
	 * create the final BlockingQueue object and List Object of clientHandler 
	 */
    private static final int PORT = 8888;
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private final List<ClientHandler> clients = new ArrayList<>();

 
/**
 * Start  the ServerSocket with Port(8888)
 * @throws IOException if exception occur on input and output throws the IOException
 */
	public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Chat server started on port " + PORT);

 

			while (true) {
			    Socket clientSocket = serverSocket.accept();
			    System.out.println("Accepted connection from " + clientSocket.getInetAddress().getHostAddress());

 

			    ClientHandler clientHandler = new ClientHandler(clientSocket);
			    clients.add(clientHandler);
			    new Thread(clientHandler).start();
			}
		}
    }

 
    /**
     * private broadcast to sent a message to Client Server with a ClientHandler
     * @param message
     */
	private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

 

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final ObjectOutputStream output;
        private final ObjectInputStream input;

 

        public ClientHandler(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.output = new ObjectOutputStream(clientSocket.getOutputStream());
            this.input = new ObjectInputStream(clientSocket.getInputStream());
        }

 

        @Override
        public void run() {
            try {
                while (true) {
                    String message = (String) input.readObject();
                    System.out.println("Received message from " + clientSocket.getInetAddress().getHostAddress() + ": " + message);
                    messageQueue.put(message);
                }
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                System.out.println("Connection closed by client");
            } finally {
                clients.remove(this);
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

      /**
       * To sent a message to the client server
       * @param message
       */

        public void sendMessage(String message) {
            try {
                output.writeObject(message);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

 

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
