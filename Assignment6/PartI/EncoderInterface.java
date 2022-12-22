import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EncoderInterface extends JFrame {
	private JMenuBar menuBar;
	private JTextField inputStr;
	private JComboBox<String> encodingOpt;
	private ActionListener combolistener;
	private ActionListener btnlistener;
	private JButton clearBtn;
	private JTextField outputStr;
	private String tempOutput;
	
	public EncoderInterface() {
		menuBar = new JMenuBar();     
	    setJMenuBar(menuBar);
	    menuBar.add(createFileMenu());
	    
	    //**input panel starts**
	  	JPanel panel1 = new JPanel();
	  	
	    inputStr = new JTextField(12);
	    setLayout(new FlowLayout());
	    panel1.add(inputStr);
	    //inputStr.addActionListener((e) ->  Encoder.encodeNumeric(inputStr.getText()));
	    inputStr.addCaretListener(new TypingListener());
	    
	    combolistener = new ChoiceListener();
	    encodingOpt=new JComboBox<String>();
	    encodingOpt.addItem("Numeric");
	    encodingOpt.addItem("ROT13");
	    encodingOpt.addActionListener(combolistener);
	    panel1.add(encodingOpt);
	    
	    clearBtn=new JButton("Clear");
	    btnlistener = new ClearListener();
	    clearBtn.addActionListener(btnlistener);
	    panel1.add(clearBtn);
	    //**input panel ends & added**
	    
	    //**output panel starts**
	    JPanel panel2 = new JPanel();
	    
	    outputStr = new JTextField(20);
	    setLayout(new FlowLayout());
	    panel2.add(outputStr);
	    //**output panel ends & added**
	    
	    //**final merge panel starts**
	    JPanel controlPanel = new JPanel();
	    
	    controlPanel.setLayout(new GridLayout(2,1));
	    controlPanel.add(panel1);
	    controlPanel.add(panel2);
	    add(controlPanel);
	    //**final merge panel ends & added**
	    
		setSize(500,200);
	}
	
	public JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}
	
	public JMenuItem createFileExitItem(){
		JMenuItem item = new JMenuItem("Exit");      
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
			System.exit(0);
			}
		}      
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	class TypingListener implements CaretListener {

		@Override
		public void caretUpdate(CaretEvent e) {
			performEncoding();
		}
		
	}
	
	class ChoiceListener implements ActionListener{  
		public void actionPerformed(ActionEvent event){  
			performEncoding();
		}
    }
	
	public void performEncoding(){ 
		String encodeType=(String)encodingOpt.getSelectedItem();
		if(encodeType=="Numeric") {
			tempOutput=Encoder.encodeNumeric(inputStr.getText());
			outputStr.setText(tempOutput);
		}
		else if (encodeType=="ROT13") {
			tempOutput=Encoder.encodeROT13(inputStr.getText());
			outputStr.setText(tempOutput);
		}
	}
	
	class ClearListener implements ActionListener{
       public void actionPerformed(ActionEvent event)
       {
    	   inputStr.setText("");
    	   outputStr.setText("");
       }
    }         
    
	public static void main(String[] args) {
	      JFrame frame = new EncoderInterface();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);    
	}
}
