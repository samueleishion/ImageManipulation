public class Hexadecimal {
	private static final char[] DIGITS = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};   
	
	private int value; 
	private String number; 
	private int[] rgb; 
	
	public Hexadecimal() {
		this.value = 0; 
		this.number = "0";  
		this.rgb = new int[3]; 
		System.out.println(this); 
	}
	
	public Hexadecimal(String str) { 
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

		this.rgb = new int[3]; 
		this.value = v;  
		this.number = str; 
//		if(this.number.length()==3 || this.number.length()==6) setRGB(); 
		System.out.println(this); 
	}
	
	private void setRGB() {
		String r,g,b;  
		if(this.number.length()==3) {
			r = this.number.charAt(0) + "" + this.number.charAt(0);
			g = this.number.charAt(1) + "" + this.number.charAt(1);
			b = this.number.charAt(2) + "" + this.number.charAt(2);
		} else if(this.number.length()==6) {
			r = this.number.charAt(0) + "" + this.number.charAt(1);
			g = this.number.charAt(2) + "" + this.number.charAt(3);
			b = this.number.charAt(4) + "" + this.number.charAt(5);
		} else {
			r = "00";
			g = "00";
			b = "00"; 
		}
		
		this.rgb[0] = new Hexadecimal(r).value(); 
		this.rgb[1] = new Hexadecimal(g).value(); 
		this.rgb[2] = new Hexadecimal(b).value(); 
	}
	
	public int value() {
		return this.value; 
	}
	
	public String number() {
		return this.number; 
	}
	
	public int minus(Hexadecimal hex2) {
		return this.value()-hex2.value(); 
	}
	
	public int minusRGB(Hexadecimal hex2) {
		return 0; 
	}
	
	public String rgb() {
		return this.rgb[0]+", "+this.rgb[1]+", "+this.rgb[2];  
	}
	
	public String toString() {
		return "number: "+this.number()+", value: "+this.value()+"\n"+this.rgb(); 
	}
}
