package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

public class Pixel implements Serializable{
	public int x;
	public int y;
	public Color color;

	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;

		color = Color.WHITE;
	}
}
