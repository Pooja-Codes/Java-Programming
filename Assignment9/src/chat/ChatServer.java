package chat;


import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.*;

public class ChatServer extends JFrame implements Runnable {

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private JTextArea serverscreen = new JTextArea();
	private int clientNo = 0;
	private String allMessages="connected"+"\n";
	
	public ChatServer() {
		super("Chat Server");
		this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		this.setVisible(true);
		
		setLayout(new BorderLayout());
	    add(new JScrollPane(serverscreen), BorderLayout.CENTER);
	    serverscreen.setEditable(false);
	    
	    Thread t = new Thread(this);
		t.start();
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
	}

	@Override
	public void run() {
		try {
		     // Create a server socket
		     ServerSocket serverSocket = new ServerSocket(9898);
		     serverscreen.append("Chat server started at "+new java.util.Date() + '\n');
		     
		     while (true) {
		         // Listen for a new connection request
		         Socket socket = serverSocket.accept();
		         
		         // Increment clientNo
		          clientNo++;
		          
		          serverscreen.append("Starting thread for client " + clientNo +
		                  " at " + new Date() + '\n');

				// Find the client's host name, and IP address
				InetAddress inetAddress = socket.getInetAddress();
				serverscreen.append("Client " + clientNo + "'s host name is "
				  + inetAddress.getHostName() + "\n");
				serverscreen.append("Client " + clientNo + "'s IP Address is "
				  + inetAddress.getHostAddress() + "\n");
				  
              // Create and start a new thread for the connection
              new Thread(new HandleAClient(socket, clientNo)).start();
		}}
	   catch(IOException ex) {
		   System.err.println(ex);
	   }
		
	}
	  // Define the thread class for handling new connection
	  class HandleAClient implements Runnable {
	    private Socket socket; // A connected socket
	    private int clientNum;
	    
	    /** Construct a thread */
	    public HandleAClient(Socket socket, int clientNum) {
	      this.socket = socket;
	      this.clientNum = clientNum;
	    }
	    
	    /** Run a thread */
	    public void run() {
	      try {
	    	 
	        // Create data input and output streams
	        DataInputStream inputFromClient = new DataInputStream(
	          socket.getInputStream());
	        DataOutputStream outputToClient = new DataOutputStream(
	          socket.getOutputStream());

	        // Continuously serve the client
	        while (true) {
	        	  outputToClient.writeUTF(allMessages);
	          
		          String message = inputFromClient.readUTF();
		          
		          allMessages+=("Client "+this.clientNum+": "+message+"\n");
		          outputToClient.writeUTF(allMessages);        
	        }
	      }
	      catch(IOException ex) {
	        ex.printStackTrace();
	      }
	    }
	  }
	  
}


