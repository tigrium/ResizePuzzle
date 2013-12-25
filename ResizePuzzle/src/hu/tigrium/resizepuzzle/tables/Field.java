package hu.tigrium.resizepuzzle.tables;

import hu.tigrium.resizepuzzle.ImageUtils;
import android.graphics.Bitmap;

public class Field {
	private int originalIndex;
	private int width;
	private int height;
	private int top;
	private int left;
	private Bitmap image;
	
	public Field(int originalIndex, int top, int left, int width, int height, Bitmap image) {
		super();
		this.originalIndex = originalIndex;
		this.width = width;
		this.height = height;
		this.top = top;
		this.left = left;
		this.image = image;
	}

	public int getOriginalIndex() {
		return originalIndex;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}

	public Bitmap getImage() {
		return image;
	}
	
	public Bitmap getImage(int width, int height) {
		return ImageUtils.resizeImage(image, width, height);
	}
	
//	public boolean isIn(int x, int y) {
//		return ( x > left && x < left + width ) && ( y > top && y < top + height );
//	}
	
	@Override
	public String toString() {
		return originalIndex + ". left: " + left + " top: " + top + "; " + width + " x " + height 
				+ " [" + image.toString() + "]";
	}
}
