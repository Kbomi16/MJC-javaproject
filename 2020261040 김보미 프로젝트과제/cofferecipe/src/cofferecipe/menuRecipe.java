package cofferecipe;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class menuRecipe extends JFrame {
	//UpPanel 
		int pageNumber = 1;
		String pageText = Integer.toString(pageNumber)+"/5 Page";
		JPanel upPanel = null;
		JButton homeBt = null;
		JButton endBt = null;
		
		//Center
		JLabel webToonLabel = new JLabel();
		JLabel pageLabel = null;
		ImageIcon[] webToon = null;
		
		//DownPanel
		JPanel downPanel = new JPanel(new FlowLayout());
		JButton leftBt = null;
		JButton rightBt = null;
		
		public menuRecipe() {
			
			Container c = getContentPane();
			c.setLayout(new BorderLayout(10,10));
			Listener buttonAction = new Listener();
			
			//Up Panel
			upPanel = new JPanel(new BorderLayout(10,10));
			c.add(upPanel,BorderLayout.NORTH);
			pageLabel = new JLabel(pageText,JLabel.CENTER);
			pageLabel.setFont(new Font("Arial", Font.BOLD, 15));
			upPanel.add(pageLabel,BorderLayout.CENTER);
			
			//Center
			webToon = new ImageIcon[6];
			for(int i=1; i<webToon.length; i++) {
				String src = "img\\\\coffee\\coffee" + i+".png";
				webToon[i] = new ImageIcon(src);
			}
			webToonLabel.setIcon(webToon[pageNumber-1]);
			webToonLabel.setOpaque(true);
			webToonLabel.setBackground(Color.white);
			webToonLabel.setHorizontalAlignment(JLabel.CENTER);
			c.add(webToonLabel,BorderLayout.CENTER);
			
			// down Panel
			c.add(downPanel,BorderLayout.SOUTH);
			downPanel.setBackground(Color.pink);
			ImageIcon leftButton = new ImageIcon("img\\화살표1.png");
			ImageIcon rightButton = new ImageIcon("img\\화살표2.png");
			leftBt = new JButton(leftButton);
			rightBt = new JButton(rightButton);
			leftBt.setBackground(Color.white);
			rightBt.setBackground(Color.white);
			leftBt.addActionListener(buttonAction);
			rightBt.addActionListener(buttonAction);
			downPanel.add(leftBt);
			downPanel.add(rightBt);
			
			setTitle("커피 레시피 보기");
			setSize(1000,800);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		class Listener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton bt = (JButton)e.getSource();
				if(bt == leftBt) {
					if(pageNumber > 0) {
						pageNumber--;
						webToonLabel.setIcon(webToon[pageNumber-1]);
						pageText = Integer.toString(pageNumber)+"/6 Page";
						pageLabel.setText(pageText);
					}
				}
				else if( bt == rightBt) {
					if(pageNumber < 6) {
						pageNumber++;
						webToonLabel.setIcon(webToon[pageNumber-1]);
						pageText = Integer.toString(pageNumber)+"/6 Page";
						pageLabel.setText(pageText);
					}
					
				}	
			}
		}
		
		public static void main(String[] args) {
			new menuRecipe();
		}
	}
