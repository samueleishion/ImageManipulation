import javax.imageio.*;
import java.awt.image.*; 
import java.io.*; 

public class ImageTest { 
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		// TODO Auto-generated method stub 1
		String uri = System.getProperty("user.dir")+File.separator+"iphone.png"; 
		BufferedImage img = loadImage(uri); 
	} 
	
	private static BufferedImage loadImage(String ref) { 
		BufferedImage img = null; 
		try { 
			File file = new File(ref); 
			System.out.println(file);  
			img = ImageIO.read(file); 
		} catch (Exception e) { 
			e.printStackTrace();  
		} 
		return img;  
	} 
} 