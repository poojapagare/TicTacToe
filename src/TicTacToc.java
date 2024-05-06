import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TicTacToc implements ActionListener{
	Random random = new Random();
	JFrame jframe = new JFrame();
	JPanel jpanel_title = new JPanel();
	JPanel jpanel_button = new JPanel();
	JLabel textfield = new JLabel();
	JButton jbutton[] = new JButton[9];
	boolean player_1turn;
	
	TicTacToc(){
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(450, 450);
		jframe.getContentPane().setBackground(new Color(50,50,50));
		jframe.setLayout(new BorderLayout());
		jframe.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setForeground(Color.WHITE);
		textfield.setText("Tic-Tac-Toc");
		textfield.setOpaque(true);
		
		jpanel_title.setLayout(new BorderLayout());
		jpanel_title.setBounds(0, 0, 800, 100);
		
		jpanel_button.setLayout(new GridLayout(3,3));
		jpanel_button.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) { 
			jbutton[i] = new JButton();
			jpanel_button.add(jbutton[i]);
			jbutton[i].setFont(new Font("MV Boli",Font.BOLD,150));
			jbutton[i].setFocusable(false);
			jbutton[i].addActionListener(this);
		}
		
		jpanel_title.add(textfield);
		jframe.add(jpanel_title,BorderLayout.NORTH);
		jframe.add(jpanel_button);
		
		firstturn();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	     for(int i=0;i<9;i++) {
	    	 if(e.getSource() == jbutton[i]) {
	    		 if(player_1turn) {
	    			 if(jbutton[i].getText()=="") {
	    				 jbutton[i].setForeground(new Color(255,0,0));
	    				 jbutton[i].setText("X");
	    				 player_1turn = false;
	    				 textfield.setText("O turn");
	    				 check();
	    			 }
	    		 }else {
	    			 if(jbutton[i].getText()=="") {
	    				 jbutton[i].setForeground(new Color(0,0,255));
	    				 jbutton[i].setText("O");
	    				 player_1turn = true;
	    				 textfield.setText("X turn");
	    				 check();
	    			 }
	    		 }
	    	 }
	     }
	}
   public void firstturn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player_1turn = true;
			textfield.setText("X turn");
		}else {
			player_1turn = false;
			textfield.setText("O turn");
		}
   }
   public void check() {
	   
	  //Check For X Condition
	   if(jbutton[0].getText()=="X" && jbutton[1].getText()=="X" && jbutton[2].getText()=="X") {
		   xWins(0,1,2);
	   }
	   if(jbutton[3].getText()=="X" && jbutton[4].getText()=="X" && jbutton[5].getText()=="X") {
		   xWins(3,4,5);
	   }
	   if(jbutton[6].getText()=="X" && jbutton[7].getText()=="X" && jbutton[8].getText()=="X") {
		   xWins(6,7,8);
	   }
	   if(jbutton[0].getText()=="X" && jbutton[3].getText()=="X" && jbutton[6].getText()=="X") {
		   xWins(0,3,6);
	   }
	   if(jbutton[1].getText()=="X" && jbutton[4].getText()=="X" && jbutton[7].getText()=="X") {
		   xWins(1,4,7);
	   }
	   if(jbutton[2].getText()=="X" && jbutton[5].getText()=="X" && jbutton[8].getText()=="X") {
		   xWins(2,5,8);
	   }
	   if(jbutton[0].getText()=="X" && jbutton[4].getText()=="X" && jbutton[8].getText()=="X") {
		   xWins(0,4,8);
	   }
	   if(jbutton[2].getText()=="X" && jbutton[4].getText()=="X" && jbutton[6].getText()=="X") {
		   xWins(2,4,6);
	   }
	   
	   //Check for O Condition
	   if(jbutton[0].getText()=="O" && jbutton[1].getText()=="O" && jbutton[2].getText()=="O") {
		   oWins(0,1,2);
	   }
	   if(jbutton[3].getText()=="O" && jbutton[4].getText()=="O" && jbutton[5].getText()=="O") {
		   oWins(3,4,5);
	   }
	   if(jbutton[6].getText()=="O" && jbutton[7].getText()=="O" && jbutton[8].getText()=="O") {
		   oWins(6,7,8);
	   }
	   if(jbutton[0].getText()=="O" && jbutton[3].getText()=="O" && jbutton[6].getText()=="O") {
		   oWins(0,3,6);
	   }
	   if(jbutton[1].getText()=="O" && jbutton[4].getText()=="O" && jbutton[7].getText()=="O") {
		   oWins(1,4,7);
	   }
	   if(jbutton[2].getText()=="O" && jbutton[5].getText()=="O" && jbutton[8].getText()=="O") {
		   oWins(2,5,8);
	   }
	   if(jbutton[0].getText()=="O" && jbutton[4].getText()=="O" && jbutton[8].getText()=="O") {
		   oWins(0,4,8);
	   }
	   if(jbutton[2].getText()=="O" && jbutton[4].getText()=="O" && jbutton[6].getText()=="O") {
		   oWins(2,4,6);
	   }
   }
   public void xWins(int a, int b, int c) {
	   jbutton[a].setBackground(Color.GREEN);
	   jbutton[b].setBackground(Color.GREEN);
	   jbutton[c].setBackground(Color.GREEN);
	   for(int i=0;i<9;i++) {
		   jbutton[i].setEnabled(false);
	   }
	   textfield.setText("X win");
   }
   public void oWins(int a, int b, int c) {
	   jbutton[a].setBackground(Color.GREEN);
	   jbutton[b].setBackground(Color.GREEN);
	   jbutton[c].setBackground(Color.GREEN);
	   for(int i=0;i<9;i++) {
		   jbutton[i].setEnabled(false);
	   }
	   textfield.setText("O win");
   }
}
