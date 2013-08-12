import javax.imageio.*; 
import java.awt.image.BufferedImage; 
import java.io.*; 

public class Image {
	
	private String path; 
	private BufferedImage img; 
	private HexColor[][] colors; 
	
	public Image(String imgPathName) {
		this.path = imgPathName; 
		try {
			File file = new File(imgPathName); 
			this.img = ImageIO.read(file); 
			this.processColors(); 
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private void processColors() {
		int width = this.img.getWidth(); 
		int height = this.img.getHeight(); 
		this.colors = new HexColor[height][width]; 
		
		for(int row = 0; row<height; row++) {
			for(int col = 0; col<width; col++) {
				int rgb = img.getRGB(col, row); 
				int[] temp = new int[3]; 
				temp[0] = (rgb >> 16) & 0xFF; // red
				temp[1] = (rgb >>  8) & 0xFF; // green 
				temp[2] = (rgb      ) & 0xFF; // blue
				this.colors[row][col] = new HexColor(temp);  
			}
		}
	}
	
	public String getImageName() { return this.path; }
	public BufferedImage getImage() { return this.img; }
	public HexColor[][] getColors() { return this.colors; }
	
	public String toString() { 
		return getImageName(); 
	} 
}