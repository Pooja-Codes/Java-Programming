package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import chat.ChatServer.HandleAClient;

public class ChatClient extends JFrame implements Runnable {

	private static int WIDTH = 400;
	private static int HEIGHT = 300;
	private JTextArea chatbox=new JTextArea(30,30);
	private JTextField typechat =new JTextField(30);
	Socket socket = null;
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	public ChatClient() {
		super("Chat Client");
		this.setSize(ChatClient.WIDTH, ChatClient.HEIGHT);
		createMenu();
		setLayout(new BorderLayout());
		JPanel chatPanel1 = new JPanel();
		JPanel chatPanel2 = new JPanel();
		
		chatPanel1.add(new JScrollPane(chatbox));
		chatbox.setEditable(false);
		
		typechat.addActionListener(new ChatFieldListener());
		chatPanel2.add(typechat); 
		this.add(chatPanel1,BorderLayout.CENTER);
		this.add(chatPanel2,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.addActionListener(new OpenConnectionListener());
		menu.add(connectItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	class OpenConnectionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					socket = new Socket("localhost", 9898);
					chatbox.append("connected"+'\n');
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					chatbox.append("connection Failure");
				}
			}
			  
		  }
		  
	class ChatFieldListener implements ActionListener {
			

			@Override
			public void actionPerformed(ActionEvent e) {
			    try {
				      // Create an input stream to receive data from the server
				      fromServer = new DataInputStream(socket.getInputStream());
				      
				      // Create an output stream to send data to the server
				      toServer = new DataOutputStream(socket.getOutputStream());
				    }
				    catch (IOException ex) {
				    	chatbox.append(ex.toString() + '\n');
				    }
			    
			    try {
			    	String chat = fromServer.readUTF();
				    chatbox.setText(chat + '\n');
			        
			        String message = typechat.getText().trim();
			        toServer.writeUTF(message);
			        toServer.flush();
			        typechat.setText("");
			       
			        chat = fromServer.readUTF();
				    chatbox.setText(chat + '\n');
			      }
			      catch (IOException ex) {
			        System.err.println(ex);
			      }
			}
		  }
			
	public void run() {
	}
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
	}
}
