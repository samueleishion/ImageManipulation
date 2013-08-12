import java.io.File;


public class Test {

	/**
	 * @param args
	 */
	
	private static int TOLERANCE = 15;
	
	public static void main(String[] args) {
//		System.out.println(java.lang.Runtime.getRuntime().maxMemory()); 
		System.out.println("HEXADECIMAL"); 
		System.out.println("-----------"); 
		Hexadecimal hex = new Hexadecimal("ff"); 
		System.out.println(hex);  
		Hexadecimal hex2 = new Hexadecimal("1"); 
		System.out.println(hex2); 
		System.out.println(hex.plus(hex2)); 
		System.out.println(hex.minus(hex2)); 
		System.out.println(hex2.plus(hex)); 
		try{ 
			System.out.println(hex2.minus(hex)); 
		} catch(IllegalArgumentException e) {
			System.out.println(e); 
		}
		
		System.out.println("\nHEXCOLOR");
		System.out.println("--------"); 
		
		HexColor hc = new HexColor("9e0b0f"); 
		HexColor hc2 = new HexColor("ee1c24"); 
		System.out.println(hc.getColor()); 
		System.out.println(hc2.getColor()); 
		if(hc.isSimilar(hc2,TOLERANCE)) System.out.println("Similar colors"); 
		else System.out.println("Different colors"); 
		
		System.out.println("\nIMAGE"); 
		System.out.println("-----"); 

		String path = System.getProperty("user.dir")+File.separator; 
		String uri = path+"iphone.png";
		Image img = new Image(uri); 
		System.out.println(img); 
		System.out.println("=+=+=+=+=+=+=+=+=+"); 
		
		uri = path+"kant.jpg"; 
		img = new Image(uri); 
		System.out.println(img); 
	}

}
