package hu.tigrium.resizepuzzle.tables;

import android.graphics.Bitmap;
import android.util.Log;

public class Table1 extends AbstractTable {
	private int xEgyseg, yEgyseg;
    
	public Table1(Bitmap image, int width, int height) {
		super(image, width, height);		
	}

	@Override
	void initFields() {
		xEgyseg = (int) ((double)image.getWidth() / 12);
		yEgyseg = (int) ((double)image.getHeight() / 20);
		
		fields = new Field[11];
		
		addField(0, image,
				0, 0, 
				3 * xEgyseg, 3 * yEgyseg);
		addField(1, image, 
				0, 3 * xEgyseg, 
				3 * xEgyseg, 3 * yEgyseg);
		addField(2, image, 
				0, 6 * xEgyseg, 
				3 * xEgyseg, 3 * yEgyseg);
		addField(3, image, 0, 9 * xEgyseg, 
				image.getWidth() - 9 * xEgyseg, 7 * yEgyseg);
		addField(4, image, 
				3 * yEgyseg, 0, 
				9 * xEgyseg, 4 * yEgyseg);
		addField(5, image, 
				7 * yEgyseg, 0, 
				5 * xEgyseg, 3 * yEgyseg);
		addField(6, image, 
				7 * yEgyseg, 5 * xEgyseg, 
				3 * xEgyseg, 5 * yEgyseg);
		addField(7, image, 
				7 * yEgyseg, 8 * xEgyseg, 
				image.getWidth() - 8 * xEgyseg, 5 * yEgyseg);
		addField(8, image, 
				10 * yEgyseg, 0, 
				5 * xEgyseg, 4 * yEgyseg);
		addField(9, image, 
				14 * yEgyseg, 0, 
				5 * xEgyseg, image.getHeight() - 14 * yEgyseg);
		addField(10, image, 
				12 * yEgyseg, 5 * xEgyseg, 
				image.getWidth() - 5 * xEgyseg, image.getHeight() - 12 * yEgyseg);
	}
}
