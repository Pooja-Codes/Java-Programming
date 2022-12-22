package PartIV;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RollDice extends JFrame {
	private int dice1 = 1;
	private int dice2 = 1;
	private int result = 2;
	private JPanel mainPanel;
	private JPanel dicesPanel;
	private ImagePanel img1JPanel;
	private ImagePanel img2JPanel;
	private JPanel resultPanel;
	private JLabel resultJLabel;
	private JPanel btnPanel;
	
	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		dicesPanel = new JPanel(new GridLayout(1, 2));
		resultPanel = new JPanel();
		resultJLabel = new JLabel();
		resultPanel.add(resultJLabel);
		this.repaint();
		
		btnPanel = new JPanel();
		JButton rollButton = new JButton("Roll Dice");
		rollButton.addActionListener((e) -> {
			this.diceRoll(1);
			this.repaint();
			this.diceRoll(2);
			this.repaint();
			
		});
		btnPanel.add(rollButton);
		
		mainPanel.add(dicesPanel, BorderLayout.NORTH);
		mainPanel.add(resultPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);

		this.add(mainPanel);
		this.setSize(700, 300);
		this.setVisible(true);
	}
	class DiceListener extends MouseAdapter {
		private int diceIndex;

		public DiceListener() {
			super();
		}

		public DiceListener(int dice) {
			super();
			diceIndex = dice;
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			RollDice.this.repaint();
			diceRoll(diceIndex);
			RollDice.this.repaint();
		}
	}

	public ImagePanel getDiceImage(int number, int diceIndex) {
		ImagePanel img = new ImagePanel("die" + number + ".png");
		img.addMouseListener(new DiceListener(diceIndex));
		return img;
	}

	public void repaint() {
		this.result = this.dice1 + this.dice2;
		resultJLabel.setText("Result: " + this.result);
		dicesPanel.removeAll();
		img1JPanel = getDiceImage(dice1, 1);
		img2JPanel = getDiceImage(dice2, 2);
		dicesPanel.add(img1JPanel);
		dicesPanel.add(img2JPanel);
	}
	public static int getRollRandomNumber() {
		return (int) (Math.random() * 6) + 1;
	}

	private void diceRoll(int i) {
		// TODO Auto-generated method stub
		if (i == 1) 
			this.dice1 = getRollRandomNumber();
		else if (i == 2) 
			this.dice2 = getRollRandomNumber();	
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	}
}
