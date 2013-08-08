/*
 * 
 * HexColor is a class that creates a hexadecimal color object 
 * that allows the client to perform mathematical operations 
 * with the hexadecimal value of the color to find color patterns, 
 * similarities, differences, contrasts, and compliments.  
 * 
 */
import java.awt.Color; 

public class HexColor {
	private static final char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	private int threshold; 
	private String hexa; 
	private int decimal; 
	private int[] rgb; 
	private Color color; 

	public HexColor(String str) {
		if (!(str.length()==3 || str.length()==6)) throw new IllegalArgumentException("Make sure your "+
				"hexadecimal color contains 3 or 6 characters. ");  
		 
		this.threshold = 51; 
		if(str.length()==3) this.hexa = ""+str.charAt(0)+str.charAt(0)+str.charAt(1)+str.charAt(1)+str.charAt(2)+str.charAt(2); 
		else this.hexa = str; 
		this.decimal = this.getDecimal();  
		this.rgb = new int[3]; 
		this.rgb[0] = this.getDecimal(this.hexa.substring(0,2)); 
		this.rgb[1] = this.getDecimal(this.hexa.substring(2,4)); 
		this.rgb[2] = this.getDecimal(this.hexa.substring(4));   
		this.color = new Color(this.rgb[0],this.rgb[1],this.rgb[2]); 
	}
	
	private int getDecimal() { return getDecimal(this.hexa); } 
	private int getDecimal(String str) {
		int v = 0; 
		int k = 0; 
		char c; 
		for(int i = str.length()-1; i >= 0; i--) {
			c = str.charAt(i); 
			if(!Character.isDigit(c)) c = Character.toLowerCase(c);
			boolean flag = true;
			int j = 0; 
			while(flag) {
				if(j >= DIGITS.length) flag = false; 
				if(c==DIGITS[j]) { 
					v += (j!=0) ? j+(j*(15*k)) : j;   
					flag = false; 
				}
				j++; 
			}
			k++; 
		}
		return v; 
	}
	
	public int minusDecimal(HexColor hex2) {
		System.out.println("total: "+(this.decimal - hex2.decimal)); 
		return this.decimal - hex2.decimal; 
	}
	
	public int[] minusRGB(HexColor hex2, int tolerance) {
		if(tolerance < 0) tolerance = 0; 
		this.threshold = (tolerance>255) ? 255 : tolerance;  
		int[] result = new int[3]; 
		result[0] = Math.abs(this.rgb[0]-hex2.rgb[0]); 
		result[1] = Math.abs(this.rgb[1]-hex2.rgb[1]); 
		result[2] = Math.abs(this.rgb[2]-hex2.rgb[2]);
		System.out.println("total: rgb("+result[0]+","+result[1]+","+result[2]+")"); 
		
		int avg = (result[0]+result[1]+result[2])/3; 
		
		if(avg==0) System.out.println("Same colors"); 
		else if(avg<this.threshold) System.out.println("Similar colors"); 
		else System.out.println("Different colors"); 
		
		return result; 
	}
	
	public String toString() {
		return "#"+this.hexa+", b10: "+decimal+", rgb("+this.rgb[0]+","+this.rgb[1]+","+this.rgb[2]+")"; 
	}

}
