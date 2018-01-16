package epood;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.plaf.PanelUI;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	public Product p = new Product("PrOne",15,0,1);
	public BufferedImage bg;
	public MyFrame() {
		try {
			bg = ImageIO.read(new File("bg.jpg"));
		} catch (IOException e) {
		}
		EShop shop = new EShop();	
		shop.setSize(1000,1000);
		this.add(shop);
		
//		this.getContentPane().add(BorderLayout.PAGE_START,l);
//		this.getContentPane().add(BorderLayout.LINE_START, l1);
//		this.getContentPane().add(BorderLayout.LINE_START, l2);
//		this.getContentPane().add(BorderLayout.CENTER, pane);
//		this.getContentPane().add(BorderLayout.CENTER,shop);
//		this.getContentPane().add(BorderLayout.PAGE_START,l1);
//		this.getContentPane().add(BorderLayout.PAGE_END,l2);

		this.setFocusable(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.setResizable(false);
	}
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		g.drawImage(bg, 0, 0,getWidth(),getHeight(),null);
//	}
}
