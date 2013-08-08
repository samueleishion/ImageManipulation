/*
 * Survey people and compare colors:
 * 	- 	#ff3333 vs #ff4d4d 
 * 		#ff0000 vs #ff3333 
 * 		#ff0000 vs #ff4d4d 
 * 		OR
 * 		#ff0000 vs #ff3333 vs #ff4d4d 
 */


public class Test {

	/**
	 * @param args
	 */
	
	private static int TOLERANCE = 51;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexColor hex = new HexColor("ff4444"); 
		HexColor hex2 = new HexColor("f00"); 
		
		System.out.println(hex); 
		System.out.println(hex2); 

		hex.minusRGB(hex2, TOLERANCE);  
		
//		Hexadecimal hex = new Hexadecimal();
//		System.out.println(hex); 
//		
//		hex = new Hexadecimal("11"); 
//		System.out.println(hex); 
//		
//		System.out.println("--"); 
//		
//		hex = new Hexadecimal("ff");  
//		System.out.println(hex); 
//		
//		Hexadecimal hex2 = new Hexadecimal("43"); 
//		System.out.println(hex2); 
//		
//		System.out.println(hex.minus(hex2)); 
//		
//		hex = new Hexadecimal("ff9900"); 
//		hex2 = new Hexadecimal("0099ff"); 
//		System.out.println("orange->lightblue "+hex.minus(hex2)); 
//		
//		hex = new Hexadecimal("ff9900"); 
//		hex2 = new Hexadecimal("ff0000"); 
//		System.out.println("orange->red "+hex.minus(hex2)); 
//		
//		hex = new Hexadecimal("0099ff"); 
//		hex2 = new Hexadecimal("0000ff"); 
//		System.out.println("lightblue->blue "+hex.minus(hex2)); 
//
//		hex = new Hexadecimal("ff9900"); 
//		hex2 = new Hexadecimal("0000ff"); 
//		System.out.println("orange->blue "+hex.minus(hex2)); 
//
//		hex = new Hexadecimal("0099ff"); 
//		hex2 = new Hexadecimal("ff0000"); 
//		System.out.println("lightblue->red "+hex.minus(hex2)); 
//		
//		hex = new Hexadecimal("ff0000"); 
//		hex2 = new Hexadecimal("9a0000"); 
//		System.out.println("red->darkerred "+hex.minus(hex2)); 
		
//		char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};  
//		Hexadecimal hex; 
//		String str; 
//		
//		for(int i = 0; i < digits.length; i++) {
//			for(int j = 0; j < digits.length; j++) {
//				str = digits[i]+""+digits[j]; 
//				hex = new Hexadecimal(str); 
//				System.out.println(hex);  
//			}
//		}
		
//		Hexadecimal hex4 = new Hexadecimal(255); 
//		System.out.println(hex4.value()); 
//		System.out.println(hex4.number()); 
	}

}
