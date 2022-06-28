package cofferecipe;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class menuChoice extends JFrame {
	private String [] coffee = {"에스프레소", "아메리카노", "카페라떼", "바닐라라떼", "카페모카"};
	private ImageIcon [] images = { new ImageIcon("img/에스프레소1.png"),
			new ImageIcon("img/아메리카노1.png"),
			new ImageIcon("img/카페라떼1.png"),
			new ImageIcon("img/바닐라라떼1.png"),
			new ImageIcon("img/카페모카1.png")};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(coffee);
	public menuChoice() {
		setTitle("커피 레시피");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		Button btn = new Button("Let's go look at the recipe!");
		c.add(btn);
        
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuRecipe();
			}
		});
		setSize(300,500);
		setVisible(true);
	}
public static void main(String [] args) {
	new menuChoice();
	}
}