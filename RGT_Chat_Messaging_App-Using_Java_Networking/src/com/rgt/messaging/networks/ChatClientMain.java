package com.rgt.messaging.networks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

 

import javax.net.SocketFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

 

public class ChatClientMain extends JFrame {
    /**
	 * Declare the static variables of serverAddress and serverPort
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;

 
/**
 * create the JTextArea object and JTextField 
 * and Declare the variables of ObjectOutputStream & ObjectInputStream
 */
    private final JTextArea chatTextArea = new JTextArea(20, 40);
    private final JTextField messageTextField = new JTextField(40);
    private ObjectOutputStream output;
    private ObjectInputStream input;

 

    public ChatClientMain() {
        JPanel mainPanel = new JPanel();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        mainPanel.add(scrollPane);
        mainPanel.add(messageTextField);
        messageTextField.addActionListener(e -> sendMessage());

 

        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RGT Chat App");
        this.setVisible(true);
    }

    /**
     * Start the IP Address with Server Port
     * for creating the SocketFactory object and Socket to connect with Client Server
     * @throws IOException
     */
 

    public void start() throws IOException {
        SocketFactory socketFactory = SocketFactory.getDefault();
        Socket socket = socketFactory.createSocket(SERVER_ADDRESS, SERVER_PORT);
        System.out.println("Connected to chat server");

 

        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());

 

        new Thread(new MessageReceiver()).start();
    }

 
    /**
     * Send the message and write the message
     */
    private void sendMessage() {
        String message = messageTextField.getText();
        messageTextField.setText("");
        try {
            output.writeObject(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * create private class for receiving the Message
     *
     */
 

    private class MessageReceiver implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    String message = (String) input.readObject();
                    System.out.println("Received message: " + message);
                    SwingUtilities.invokeLater(() -> chatTextArea.append(message + "\n"));
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Connection closed by server");
            }
        }
    }

 

    public static void main(String[] args) {
        try {
            ChatClientMain client = new ChatClientMain();
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
