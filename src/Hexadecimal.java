/*
 * Image Manipulation
 * 	Hexadecimal Class
 * 
 * @author: Samuel Acuna
 * @date: 07/2013
 * 
 * Representation of hexadecimal number that is able to 
 * perform some mathematical operations both hexa-decimally 
 * and decimally.  
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
		if(num<0) throw new IllegalArgumentException("Hexadecimals cannot be negative. "); 
		this.decnum = num; 
		this.hexnum = decToHex(num);
	}
	
	private int hexToDec(String str) {
		int num = 0; 
		int k = 0;
		char ch; 
		for(int i = str.length()-1; i>=0; i--) {
			ch = str.charAt(i); 
			if(!Character.isDigit(ch)) ch = Character.toLowerCase(ch); 
			boolean flag = true; 
			int j = 0; 
			while(flag) {
				if(j>=Constants.DIGITS.length) flag = false;
				else {
					if(ch==Constants.DIGITS[j]) {
						num += (j!=0) ? j+(j*(15*k)) : j; 
					}
				}
				j++; 
			}
			k++; 
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
		return new Hexadecimal(this.decnum-hex.getDecimal()); 
	}
	
	public String toString() {
		return this.decnum+" => #"+this.hexnum; 
	}
}