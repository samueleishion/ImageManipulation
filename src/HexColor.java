/*
 * Image Manipulation
 * 	HexColor Class
 * 
 * @author: Samuel Acuna
 * @date: 08/2013
 * 
 * HexColor is a class that creates a hexadecimal color object 
 * that allows the client to perform mathematical operations 
 * with the hexadecimal value of the color to find color patterns, 
 * similarities, differences, contrasts, and compliments.    
 * 
 */

import java.awt.Color; 

public class HexColor {
	
	private int[] rgbdec;
	private Hexadecimal[] rgbhex; 
	private Color color; 
	
	public HexColor(String str) {
		if (!(str.length()==3 || str.length()==6)) 
			throw new IllegalArgumentException("Make sure your "+
				"hexadecimal color contains 3 or 6 characters.");
		
		this.clear(); 
		if(str.length()==3) {
			this.rgbhex[0] = new Hexadecimal(str.charAt(0)+""+str.charAt(0)); 
			this.rgbhex[1] = new Hexadecimal(str.charAt(1)+""+str.charAt(1)); 
			this.rgbhex[2] = new Hexadecimal(str.charAt(2)+""+str.charAt(2));
		} else {
			this.rgbhex[0] = new Hexadecimal(str.charAt(0)+""+str.charAt(1)); 
			this.rgbhex[1] = new Hexadecimal(str.charAt(2)+""+str.charAt(3)); 
			this.rgbhex[2] = new Hexadecimal(str.charAt(4)+""+str.charAt(5));
		}
		this.rgbdec[0] = this.rgbhex[0].getDecimal(); 
		this.rgbdec[1] = this.rgbhex[1].getDecimal(); 
		this.rgbdec[2] = this.rgbhex[2].getDecimal(); 
		this.color = new Color(rgbdec[0],rgbdec[1],rgbdec[2]); 
	}
	
	public HexColor(int[] rgbDecimal) {
		if(rgbDecimal.length != 3) 
			throw new IllegalArgumentException("Please make sure your "+
					"list contains 3 values (rgb)"); 
		this.clear(); 
		this.rgbdec = rgbDecimal; 
		//System.out.println("colors: "+rgbdec[0]+','+rgbdec[1]+','+rgbdec[2]);  
		this.rgbhex[0] = new Hexadecimal(this.rgbdec[0]);
		this.rgbhex[1] = new Hexadecimal(this.rgbdec[1]); 
		this.rgbhex[2] = new Hexadecimal(this.rgbdec[2]); 
		this.color = new Color(rgbdec[0],rgbdec[1],rgbdec[2]);   
	}
	
	public HexColor(String[] rgbHexadecimal) {
		this(rgbHexadecimal[0]+rgbHexadecimal[1]+rgbHexadecimal[2]); 
	}
	
	public void clear() {
		this.rgbdec = new int[3];
		this.rgbhex = new Hexadecimal[3];
	}
	
	public Color getColor() {
		return this.color; 
	}
	
	public Hexadecimal getRed() {
		return this.rgbhex[0]; 
	}
	
	public Hexadecimal getGreen() {
		return this.rgbhex[1]; 
	}
	
	public Hexadecimal getBlue() {
		return this.rgbhex[2]; 
	}
	
	public boolean isSimilar(HexColor hex, int treshold) {
		int dred,dgrn,dblu; 
		dred = this.getRed().minus(hex.getRed()).getDecimal(); 
		dgrn = this.getGreen().minus(hex.getGreen()).getDecimal(); 
		dblu = this.getBlue().minus(hex.getBlue()).getDecimal();
//		System.out.println(dred+"+"+dgrn+"+"+dblu+"="+((dred+dgrn+dblu)/3)); 
		return ((dred+dgrn+dblu)/3) <= treshold; 
	}
	
	public String toString() {
//		return rgbhex[0]+","+rgbhex[1]+","+rgbhex[2];
		return rgbhex[0]+""+rgbhex[1]+""+rgbhex[2]; 
	}
}