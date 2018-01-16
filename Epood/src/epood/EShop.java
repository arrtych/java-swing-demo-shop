package epood;
import epood.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class EShop extends JPanel implements ActionListener{
	Product product = new Product("Samsung Galaxy",0,250,1);
	Product product1 = new Product("Samsung GX",1,400,1);
	Product product2 = new Product("Samsung SII",2,330,1);
	public Font font = new Font("serif", Font.BOLD, 24);
	public JPanel box,imageBox,imagesBox,dataBox,priceBox,countBox,middleBox,resultBox;
	public JLabel l,nameLabel,priceLabel,countLabel,cartLabel;
	public JButton l1,l2,l3;
	public JTextField nameField,priceField,countField;
	public JTextArea result;
	public JButton plus,minus,addToCart;
	public Cart cart = new Cart();
	public BufferedImage x;
	public EShop() {
//-------Image Components creating
		
		ImageIcon icon = new ImageIcon(product.products.get(product.index));
		ImageIcon icon_sm = new ImageIcon(product.sm_products.get(product.index));
		ImageIcon icon1_sm = new ImageIcon(product.sm_products.get(product1.index));
		ImageIcon icon2_sm = new ImageIcon(product.sm_products.get(product2.index));
		JPanel imageArea = new JPanel();
		imageArea.setLayout(new BoxLayout(imageArea, BoxLayout.PAGE_AXIS));
		JPanel box =new JPanel();
		JPanel imageBox = new JPanel();
		imageBox.setLayout(new BoxLayout(imageBox, BoxLayout.X_AXIS));
		l = new JLabel();		
		l.setIcon(icon);
		imageBox.add(l);
//		imageBox.add(Box.createRigidArea(new Dimension(0, 30)));
		
		JPanel imagesBox = new JPanel();
		imagesBox.setLayout(new BoxLayout(imagesBox, BoxLayout.LINE_AXIS));
		l1 = new JButton();
		l1.setIcon(icon_sm);
		l1.setPreferredSize(new Dimension(100, 100));
		imagesBox.add(l1);
		l2 = new JButton();
		l2.setIcon(icon1_sm);
		l2.setPreferredSize(new Dimension(100, 100));
		imagesBox.add(l2);
		l3 = new JButton();
		l3.setIcon(icon2_sm);
		l3.setPreferredSize(new Dimension(100, 100));
		imagesBox.add(l3);
		imageArea.add(imageBox);
		imageArea.add(imagesBox);
		box.add(imageArea);
//		this.add(imageArea);
		
		
//------ Data Components Creating
		
		JPanel dataBox = new JPanel();
		dataBox.setLayout(new BoxLayout(dataBox,BoxLayout.PAGE_AXIS));
		JPanel nameBox = new JPanel();
		nameBox.setLayout(new BoxLayout(nameBox, BoxLayout.LINE_AXIS));
		nameLabel = new JLabel();		
		nameLabel.setText(" Name: ");
		nameLabel.setFont(font);
		nameBox.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setText(product.name);
		nameField.setFont(font);
		nameBox.add(nameField);
		nameBox.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel priceBox = new JPanel();
		priceBox.setLayout(new BoxLayout(priceBox, BoxLayout.LINE_AXIS));
		priceLabel = new JLabel();		
		priceLabel.setText(" Price:  ");
		priceLabel.setFont(font);
		priceBox.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setText(product.price+ " $");
		priceField.setFont(font);
		priceField.setSize(20,10);
		priceBox.add(priceField);
		priceBox.add(Box.createRigidArea(new Dimension(0, 40)));
		
		JPanel countBox = new JPanel();
		countBox.setLayout(new BoxLayout(countBox, BoxLayout.LINE_AXIS));
		countLabel = new JLabel();
		countLabel.setText("Count: ");
		countLabel.setFont(font);
		countBox.add(countLabel);
		
		countField = new JTextField();
		countField.setText(""+product.count);
		countField.setFont(font);		
		countBox.add(countField);	
		
		plus = new JButton();
		plus.setText("+");
		plus.setFont(font);
		countBox.add(plus);
		
		minus = new JButton();
		minus.setText("-");
		minus.setFont(font);
		countBox.add(minus);
		
		JPanel middleBox = new JPanel();
		middleBox.setLayout(new BoxLayout(middleBox, BoxLayout.LINE_AXIS));		
		addToCart = new JButton();
		addToCart.setText("Add to cart ");
		addToCart.setFont(font);
		middleBox.add(addToCart);
		middleBox.add(Box.createHorizontalGlue());
		middleBox.add(Box.createRigidArea(new Dimension(0, 40)));
		JPanel resultBox = new JPanel();
		resultBox.setLayout(new BoxLayout(resultBox, BoxLayout.PAGE_AXIS));
		cartLabel = new JLabel();
		cartLabel.setText("Cart");
		cartLabel.setFont(font);
		resultBox.add(cartLabel);
		
		result = new JTextArea(10,30);
	    JScrollPane scroll = new JScrollPane (result,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		result.setLineWrap(true);
		result.setWrapStyleWord(true);
		result.setFont(font);
		resultBox.add(scroll);
		
		dataBox.add(nameBox);
		dataBox.add(priceBox);
		dataBox.add(countBox);
		dataBox.add(middleBox);
		dataBox.add(resultBox);
		box.add(dataBox);
//		box.setBackground(Color.GRAY);
		this.add(box);
		
//---------Listenters
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		l1.addActionListener(this);
		l2.addActionListener(this);
		l3.addActionListener(this);
		addToCart.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == plus){
			checkPlusBtn(nameField.getText());			
		}
		else if (e.getSource() == minus) {
			checkMinusBtn(nameField.getText());
		}
		else if(e.getSource() == l1){
			ImageIcon currentImg =  new ImageIcon(product.products.get(product.index));
			l.setIcon(currentImg);
			nameField.setText(product.name);
			priceField.setText(product.price + " $");
			countField.setText(product.count+"");
		}
		else if(e.getSource() == l2){
			ImageIcon currentImg =  new ImageIcon(product.products.get(product1.index));
			l.setIcon(currentImg);
			nameField.setText(product1.name);
			priceField.setText(product1.price + " $");
			countField.setText(product1.count+"");
			
		}
		else if(e.getSource() == l3){
			ImageIcon currentImg =  new ImageIcon(product.products.get(product2.index));
			l.setIcon(currentImg);
			nameField.setText(product2.name);
			priceField.setText(product2.price + " $");
			countField.setText(product2.count+"");
		}
		else if(e.getSource() == addToCart){
			try {
				checkCart(nameField.getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}

	}
	public void checkPlusBtn(String id){
		if(id.equals(product.name)){
			product.count+=1;
			product.totalPrice = product.getTotalSum();
			priceField.setText(product.totalPrice + " $");
			countField.setText(product.count+"");
		}
		else if(id.equals(product1.name)){
			product1.count+=1;
			product1.totalPrice = product1.getTotalSum();
			priceField.setText(product1.totalPrice + " $");
			countField.setText(product1.count+"");
		}
		else if(id.equals(product2.name)){
			product2.count+=1;
			product2.totalPrice = product2.getTotalSum();
			priceField.setText(product2.totalPrice + " $");
			countField.setText(product2.count+"");
		}
		
	}
	public void checkMinusBtn(String id){
		if(id.equals(product.name)){
			product.count-=1;
			product.totalPrice = product.getTotalSum();
			priceField.setText(product.totalPrice + " $");
			countField.setText(""+product.count);			
		}
		else if(id.equals(product1.name)){
			product1.count-=1;
			product1.totalPrice = product1.getTotalSum();
			priceField.setText(product1.totalPrice + " $");
			countField.setText(""+product1.count);
		}
		else if(id.equals(product2.name)){
			product2.count-=1;
			product2.totalPrice = product2.getTotalSum();
			priceField.setText(product2.totalPrice + " $");
			countField.setText(""+product2.count);
		}
	}
	public void checkCart(String id) throws FileNotFoundException, UnsupportedEncodingException{
		String filepath = "data.txt";
	    BufferedReader br = new BufferedReader(new FileReader(filepath));
	    PrintStream writer = new PrintStream(new FileOutputStream(filepath, true), true);
        StringBuilder sb = new StringBuilder();
		try{
	        String line = br.readLine();
		   
		    Date dNow = new Date();
		    writer.println("#Order : " + dNow);			
			if(id.equals(product.name)){
				product.getTotalSum();
				 cart.cart.add(product);
				 writer.println(product.toString());
			}
			if(id.equals(product1.name)){
				product1.getTotalSum();
				cart.cart.add(product1);
				writer.println(product1.toString());
			}
			if(id.equals(product2.name)){
				product2.getTotalSum();
				cart.cart.add(product2);
				writer.println(product2.toString());
			}
		    writer.close();
			//reading from file
			while((line = br.readLine())!=null){
				sb.append(line);
				sb.append("\n");
			}
			result.setText(sb.toString());
			
		} catch (IOException e1) {
		   e1.printStackTrace();
		}
	}
	
}
