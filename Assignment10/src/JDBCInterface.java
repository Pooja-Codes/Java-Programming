import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class JDBCInterface extends JFrame {

	private JPanel controlPanel;
	private JTextArea textQueryArea;
	private JTextField lastNameQuery,LastNameQuery,FirstNameQuery,AgeQuery,CityQuery;
	private JButton queryButton,insertqueryButton;
	
	private Connection conn;
	private PreparedStatement queryStmtLastName,queryStmtAll,queryInsert;
	
	
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 400;
	final int AREA_ROWS = 20;
	final int AREA_COLUMNS = 40;
   
   public JDBCInterface() {
		try {
			this.conn = DriverManager.getConnection("jdbc:sqlite:assignment.db");
			queryStmtLastName = conn.prepareStatement("Select * from People WHERE Last = ?");
			queryStmtAll = conn.prepareStatement("Select * from People"); //all people
			queryInsert=conn.prepareStatement("Insert into People (Last, First, age, city) values (?,?,?,?)"); //for insert
			
		} catch (SQLException e) {
			System.err.println("Connection error: " + e);
			System.exit(1);
		}
		
	   createControlPanel();
	   queryButton.addActionListener(new QueryButtonListener());
	   insertqueryButton.addActionListener(new InsertButtonListener());
	   
	   textQueryArea = new JTextArea(
	            AREA_ROWS, AREA_COLUMNS);
	   textQueryArea.setEditable(false);
	   
	   /* scrollPanel is optional */
	   JScrollPane scrollPane = new JScrollPane(textQueryArea);
	   JPanel textPanel = new JPanel();
	   textPanel.add(scrollPane);
	   this.add(textPanel, BorderLayout.CENTER);
	   this.add(controlPanel, BorderLayout.NORTH);
   }
   
   private JPanel createControlPanel() {
	   
	   /* you are going to have to create a much more fully-featured layout */
	   
	   controlPanel = new JPanel(new GridLayout(4,4));
	   
	   JPanel insertPanel = new JPanel(new GridLayout(2,4));
	   JLabel lblLast = new JLabel("Last Name:");
	   insertPanel.add(lblLast);
	   LastNameQuery=new JTextField(10);
	   insertPanel.add(LastNameQuery);
	   
	   JLabel lblFirst = new JLabel("First Name:");
	   insertPanel.add(lblFirst);
	   FirstNameQuery=new JTextField(10);
	   insertPanel.add(FirstNameQuery);
	   
	   JLabel lblAge = new JLabel("Age:");
	   insertPanel.add(lblAge);
	   AgeQuery=new JTextField(10);
	   insertPanel.add(AgeQuery);
	   
	   JLabel lblCity = new JLabel("City:");
	   insertPanel.add(lblCity);
	   CityQuery=new JTextField(10);
	   insertPanel.add(CityQuery);
	   
	   JPanel insertbuttonPanel = new JPanel();
	   insertqueryButton = new JButton("Insert");
	   insertbuttonPanel.add(insertqueryButton);
	   
	   
	   
	   JPanel inputPanel = new JPanel();
	   JLabel lbl = new JLabel("Last Name:");
	   inputPanel.add(lbl);
	   lastNameQuery = new JTextField(10);
	   inputPanel.add(lastNameQuery);
	   
	   
	   
	   JPanel buttonPanel = new JPanel();
	   queryButton = new JButton("Execute Query");
	   buttonPanel.add(queryButton);
	   
	   
	   controlPanel.add(insertPanel);
	   controlPanel.add(insertbuttonPanel);
	   controlPanel.add(inputPanel);
	   controlPanel.add(buttonPanel);
	   
	   return controlPanel;
	   
	   
   }
   
   class InsertButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event) {
		   /* You will have to implement this */
		   try {
			   String lastNameText = LastNameQuery.getText();
			   String firstNameText = FirstNameQuery.getText();
			   String ageText = AgeQuery.getText();
			   String cityText = CityQuery.getText();
			   
			   if(lastNameText.isEmpty() || firstNameText.isEmpty() || ageText.isEmpty() || cityText.isEmpty() ) {
				   createMessageBox("All fields must be filled!");
			   }
			   else {
				   PreparedStatement stmt = queryInsert;
				   stmt.setString(1, lastNameText);
				   stmt.setString(2, firstNameText);
				   stmt.setString(3, ageText);
				   stmt.setString(4, cityText);
				   stmt.execute();
				   
				   //pooja: below two lines to remove empty fields during my assignmet work
				   //PreparedStatement stmt2 = conn.prepareStatement("delete from People where Last=''");
				   //stmt2.execute();
				   
				   createMessageBox("Inserted Successfully");
				   LastNameQuery.setText("");
				   FirstNameQuery.setText("");
				   AgeQuery.setText("");
				   CityQuery.setText("");
			   }
			  }
		   catch (SQLException e) {
		   		// TODO Auto-generated catch block
			   createMessageBox(e.getMessage());
			  }
	   }
   }
	private void createMessageBox(String msg)
	{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon("src/java.png");
		//JLabel lbl = new JLabel(msg); //via frame
		//frame.add(lbl);
		//frame.setSize(300,300);
		//frame.setVisible(true);
		JOptionPane.showMessageDialog(frame,msg,"Message", JOptionPane.INFORMATION_MESSAGE, icon); //via JOptionPane
	}
   
   class QueryButtonListener implements ActionListener {
	   public void actionPerformed(ActionEvent event)
       {
		   /* as far as the columns, it is totally acceptable to
		    * get all of the column data ahead of time, so you only
		    * have to do it once, and just reprint the string
		    * in the text area.
		    */
		   
		   /* you want to change things here so that if the text of the 
		    * last name query field is empty, it should query for all rows.
		    * 
		    * For now, if the last name query field is blank, it will execute:
		    * SELECT * FROM People WHERE Last=''
		    * which will give no results
		    */
		   String header="First"+"\t"+"Last"+"\t"+"Age"+"\t"+"City"+"\t"+"Id"+ "\n";
		   try {
			   if(lastNameQuery.getText().isEmpty()) {
				   PreparedStatement stmt = queryStmtAll;
				   ResultSet rset = stmt.executeQuery();
				   ResultSetMetaData rsmd = rset.getMetaData();
				   int numColumns = rsmd.getColumnCount();
				   String rowString = "";
					while (rset.next()) {
						for (int i=1;i<=numColumns;i++) {
							Object o = rset.getObject(i);
							rowString += o.toString() + "\t";
						}
						rowString += "\n";
					}
					//System.out.print("rowString  is  " + rowString);
					textQueryArea.setText(header+rowString);
				   
			   }
			   else {
				   textQueryArea.setText("");
				   PreparedStatement stmt = queryStmtLastName;
				   String lastNameText = lastNameQuery.getText();
					stmt.setString(1, lastNameText);
					ResultSet rset = stmt.executeQuery();
					ResultSetMetaData rsmd = rset.getMetaData();
					int numColumns = rsmd.getColumnCount();
					//System.out.println("numcolumns is "+ numColumns);
									
		
					String rowString = "";
					while (rset.next()) {
						for (int i=1;i<=numColumns;i++) {
							Object o = rset.getObject(i);
							rowString += o.toString() + "\t";
						}
						rowString += "\n";
					}
					//System.out.print("rowString  is  " + rowString);
					textQueryArea.setText(header+rowString);
			   }
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
       }
   }
    
   public static void main(String[] args)
	{  
	   JFrame frame = new JDBCInterface();
	   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);      
	}
}
