package epood;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Product {
	public ArrayList<BufferedImage> products = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> sm_products = new ArrayList<BufferedImage>();
	public String name;
	public int count,index;
	public double price,totalPrice= 0;
	public File file1 = new File("s-l500.jpg");
	public File file2 = new File("s-l500-2.jpg");
	public File file3 = new File("s-l500-3.jpg");
	public File file1s = new File("s-l500-sm.jpg");
	public File file2s = new File("s-l500-2-sm.jpg");
	public File file3s = new File("s-l500-3-sm.jpg");
	public Product(String name,int index,double price,int count) {
		try {
			this.name = name;
			this.price = price;
			this.count = count;
			for (int i = 1; i < products.size()-1; i++) {
				index = products.indexOf(i);
				
			}
			this.index = index;
			products.add(ImageIO.read(file1));
			products.add(ImageIO.read(file2));
			products.add(ImageIO.read(file3));
			
			sm_products.add(ImageIO.read(file1s));
			sm_products.add(ImageIO.read(file2s));
			sm_products.add(ImageIO.read(file3s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "Product: "+ this.name + 
			   " Image id:  " + this.index + 
			   " Price: " + this.price +
			   " Count: " + this.count + 
			   " Total: " + this.totalPrice + " ";
	}
	
	public double getTotalSum(){
		this.totalPrice = this.count * this.price;
		return this.totalPrice;
	}
	
}
