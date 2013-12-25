package hu.tigrium.resizepuzzle.tables;

import android.hardware.Camera.Size;


public interface Table {
	
	public int getFieldNumber();
	public int getFieldTop(int index);
	public int getFieldLeft(int index);
	public int getFieldWidth(int index);
	public int getFieldHeight(int index);
//	public Bitmap getFieldImage(int index);
	public Field getField(int index);
	public int getFieldIndex(int x, int y);
//	public int getFieldWidth(int index);
//	public int getFieldHeight(int index);
	public boolean isCorrectOrder();
	public void setSize(int width, int height, String imgPath);
	
	public void mixFields();
	public void changeFields(int index1, int index2);
}
