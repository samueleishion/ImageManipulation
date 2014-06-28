/*
 * Image Manipulation
 * 	Image Class
 * 
 * @author: Samuel Acuna
 * @date: 08/2013
 * 
 * Image is a class that represents an image file 
 * and processes it to perform mathematical operations
 * on the hex values of its colors per pixels to 
 * generate shapes that correspond to sections of 
 * objects represented in the images. 
 * 
 */

import javax.imageio.*; 
import java.awt.image.BufferedImage;
import java.awt.Point; 
import java.io.*; 
import java.util.*; 

public class Image {
	
	private String path; 
	private BufferedImage img; 
	private HexColor[][] colors; 
	private boolean[][] imgGrid; 
	private ArrayList<Shape> shapes; 
	private int width; 
	private int height; 
	
	public Image(String imgPathName) {
		this.path = imgPathName; 
		try {
			File file = new File(imgPathName); 
			this.img = ImageIO.read(file); 
			this.width = this.img.getWidth(); 
			this.height = this.img.getHeight(); 
			this.processColors(); 
			this.processShape(); 
			//this.printMatrix(); 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private void processColors() {
		this.colors = new HexColor[this.height][this.width]; 
		
		for(int row = 0; row<height; row++) {
			for(int col = 0; col<width; col++) {
				int rgb = img.getRGB(col, row); 
				int[] temp = new int[3]; 
				temp[0] = (rgb >> 16) & 0xFF; // red
				temp[1] = (rgb >>  8) & 0xFF; // green 
				temp[2] = (rgb      ) & 0xFF; // blue
				this.colors[row][col] = new HexColor(temp);  
			}
		}
	}
	
	private void processShape() {
		this.imgGrid = new boolean[this.height][this.width];
		this.shapes = new ArrayList<Shape>(); 
		Shape shape; 
		
		for(int i = 0; i < this.colors.length; i++) {
			for(int j = 0; j < this.colors[i].length; j++) {
				if(!this.imgGrid[i][j]) {
					shape = new Shape(); 
					this.getSimilar(i,j,shape,this.colors[i][j]); 
					this.shapes.add(shape); 
				}
			}
		}
	}
	
	public int getShapeCount() {
		return this.shapes.size(); 
	}
	
	private void getSimilar(int i, int j, Shape shape, HexColor originalColor) {
		if(isInbound(i,j) && !this.imgGrid[i][j]) {
			this.imgGrid[i][j] = true; 
			if(originalColor.isSimilar(this.colors[i][j], Constants.TOLERANCE)) {
				shape.addPixel(new Point(i,j)); 
				shape.addColor(this.colors[i][j]); 
				getSimilar(i,j-1,shape,originalColor); 
				getSimilar(i,j+1,shape,originalColor); 
				getSimilar(i-1,j-1,shape,originalColor); 
				getSimilar(i-1,j,shape,originalColor); 
				getSimilar(i-1,j+1,shape,originalColor); 
				getSimilar(i+1,j-1,shape,originalColor); 
				getSimilar(i+1,j,shape,originalColor); 
				getSimilar(i+1,j+1,shape,originalColor);
			}
		}
	}
	
	
	private boolean isInbound(int i, int j) {
		return ((i>=0 && i<this.colors.length) && (j>=0 && j<this.colors[i].length));  
	}
	
	private void printMatrix() {
//		for(int i = 0; i < this.colors.length; i++) {
//			for(int j = 0; j < this.colors[i].length; j++) {
//				System.out.print(this.colors[i][j]+",");  
//			}
//			System.out.println(); 
//		}
		for(int i = 0; i < this.imgGrid.length; i++) {
			for(int j = 0; j < this.imgGrid[i].length; j++) {
				System.out.print((imgGrid[i][j]) ? "1" : "0" + ","); 
			}
			System.out.println(); 
		}
	}
	
	public String getImageName() { return this.path; }
	public BufferedImage getImage() { return this.img; }
	public HexColor[][] getColors() { return this.colors; }
	
	public String toString() { 
		return getImageName(); 
	} 
}