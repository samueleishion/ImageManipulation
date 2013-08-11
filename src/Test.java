
public class Test {

	/**
	 * @param args
	 */
	
	private static int TOLERANCE = 51;
	
	public static void main(String[] args) {
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
	}

}
