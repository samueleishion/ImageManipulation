import java.awt.Point;
import java.io.File;

public class Test {

	/**
	 * @param args
	 */
	
	private static int TOLERANCE = 15;
	private static int total = 0; 
	private static int passed = 0; 
	
	public static void main(String[] args) {
		
		// ###############
		// # HEXADECIMAL
		// ############### 

		// getDecimal 
		Hexadecimal hex = new Hexadecimal("01"); 
		int actual = 1; 
		int result = hex.getDecimal(); 
		evalResult(actual==result, "PASSED", "FAILED: "+actual+"!="+result); 
		
		// getHexadecimal 
		hex = new Hexadecimal(255); 
		String actual_string = "ff";
		String result_string = hex.getHexadecimal(); 
		evalResult(actual_string.equals(result_string), "PASSED", "FAILED: "+actual_string+"!="+result_string); 
		
		// plus 
		Hexadecimal hex2 = new Hexadecimal("0a");
		hex = new Hexadecimal("0a"); 
		actual = 20; 
		result = hex.plus(hex2).getDecimal(); 
		evalResult(actual==result, "PASSED", "FAILED: "+actual+"!="+result); 
		
		// minus 
		hex = new Hexadecimal("ff"); 
		hex2 = new Hexadecimal("0a"); 
		actual = 245; 
		result = hex.minus(hex2).getDecimal(); 
		evalResult(actual==result, "PASSED", "FAILED: "+actual+"!="+result); 

		// ###############
		// # IMAGE 
		// ###############
		String path = System.getProperty("user.dir")+File.separator; 
		String uri = path+"img1.png"; 
		Image img = new Image(uri); 
		actual = 2; 
		result = img.getShapeCount(); 
		evalResult(actual==result, "PASSED", "FAILED"); 
		
		showResult(); 
	}
	
	public static void evalResult(Boolean test, String pass, String fail) { 
		total++; 
		
		if(test) {
			System.out.println(total+" "+pass);
			passed++; 
		} else System.out.println(total+" "+fail); 
		
	}
	
	public static void showResult() {
		System.out.println(); 
		System.out.println("Total: "+passed+"/"+total+" "+((passed/total)*100)+"%"); 
	}

}
