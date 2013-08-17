/*
 * Image Manipulation
 * 	Shape Class
 * 
 * @author: Samuel Acuna
 * @date: 08/2013
 * 
 * Representation shapes in an image of 
 * similar colors. 
 * 
 */

import java.awt.Point;
import java.util.ArrayList; 

public class Shape { 	
	
	private ArrayList<Point> pixels; 
	private ArrayList<HexColor> colors;
	public HexColor baseColor; 
	
	public Shape() { 
		this.pixels = new ArrayList<Point>();   
		this.colors = new ArrayList<HexColor>(); 
	} 
	
	public void addPixel(Point p) {
		this.pixels.add(p); 
	}
	
	public void addColor(HexColor c) {
		this.colors.add(c);  
	}
	
	public void calculateBaseColor() {
		HexColor prov; 
		int[] temp = new int[3]; 
		int size = colors.size(); 
		for(int i=0; i<size; i++) {
			prov = colors.get(i); 
			temp[0]+=prov.getRed().getDecimal();
			temp[1]+=prov.getGreen().getDecimal(); 
			temp[2]+=prov.getBlue().getDecimal(); 
		}
		temp[0] = temp[0]/size;
		temp[1] = temp[1]/size; 
		temp[2] = temp[2]/size; 
		baseColor = new HexColor(temp); 
	}
}