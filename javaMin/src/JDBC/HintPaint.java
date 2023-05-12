package JDBC;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class HintPaint extends JFrame {

	Image background = null;
	
	
	public HintPaint(String paintdb) {
		background=new ImageIcon("../img/"+paintdb).getImage();

		setTitle("Hint");
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		g.drawImage(background, 100, 100, null);
	}
	
	

}