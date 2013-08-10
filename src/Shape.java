/*
 * Image Manipulation
 * 	Shape Class
 * 
 * @author: Samuel Acuna
 * @date: 07/2013
 * 
 * Representation of shape that is bounded by the 
 * difference of hexadecimal (or decimal) values 
 * of colors.  
 * 
 */

import java.util.Stack;
import java.awt.Point; 

public class Shape {

	private Stack<Point> boundaries; 
	private HexColor color; 
	
	public Shape(HexColor color) {
		this.color = color;  
	}
	
	public Shape(Point firstPoint) { 
		this.boundaries = new Stack<Point>(); 
		this.addBoundary(firstPoint); 
	}

	public void addBoundary(Point boundaryPoint) {
		this.boundaries.push(boundaryPoint); 
	}
}
