/*
 * Image Manipulation
 * 	Hexadecimal Class
 * 
 * @author: Samuel Acuna
 * @date: 08/2013
 * 
 * Representation of hexadecimal number that is able to 
 * perform some mathematical operations. 
 * 
 */

public class Hexadecimal { 	
	
	private int decnum; 
	private String hexnum; 
	
	public Hexadecimal() {
		this.decnum= 0; 
		this.hexnum = "0"; 
		System.out.println(this); 
	}
	
	public Hexadecimal(String str) { 
		this.hexnum = str; 
		this.decnum = hexToDec(str); 
	}
	
	public Hexadecimal(int num) {
//		if(num<0) throw new IllegalArgumentException("Hexadecimals cannot be negative. ");
		if(num<0) num = 0; 
		this.decnum = num; 
		this.hexnum = decToHex(num);
	}
	
	private int hexToDec(String str) {
		int num = 0; 
		int k = 0;
		char ch; 
//		System.out.println(str+" ===="); 
		for(int i = str.length()-1; i>=0; i--) {
			ch = str.charAt(str.length()-(i+1)); 
			if(!Character.isDigit(ch)) ch = Character.toLowerCase(ch); 
			for(int j = 0; j < Constants.DIGITS.length; j++) {
				if(Constants.DIGITS[j]==ch) {
					k=j;
					break; 
				}
			} 
			num += k*(Math.pow(16, i)); 
		}
		return num; 
	}
	private String decToHex(int num) {
		String hex = "";  
		int temp = num%16; 
		if(num-temp==0) hex += Constants.DIGITS[temp]; 
		else hex += decToHex((num-temp)/16)+Constants.DIGITS[temp]; 
		return hex; 
	}
	
	public int getDecimal() {
		return this.decnum; 
	}
	public String getHexadecimal() {
		return this.hexnum; 
	}
	
	public Hexadecimal plus(Hexadecimal hex) {
		return new Hexadecimal(this.decnum+hex.getDecimal()); 
	}
	public Hexadecimal minus(Hexadecimal hex) {
		if(this.decnum>hex.getDecimal())
			return new Hexadecimal(this.decnum-hex.getDecimal()); 
		return new Hexadecimal(hex.getDecimal()-this.decnum); 
	}
	
	public String toString() {
		return this.decnum+" => #"+this.hexnum; 
	}
}