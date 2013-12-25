package hu.tigrium.resizepuzzle.tables;

import hu.tigrium.resizepuzzle.ImageUtils;

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.util.Log;

public abstract class AbstractTable implements Table {
	private Random rnd;
	
	Bitmap image;
	Field[] fields;
	private int[] indexes;
	
	public AbstractTable(Bitmap image, int width, int height) {
		super();
		this.image = image;
		rnd = new Random(System.currentTimeMillis());
		
		this.image = ImageUtils.cropAndResizeImageCenter(image, width, height);
		initFields();
		indexes = new int[fields.length];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = i;
		}
	}
	
	abstract void initFields();

	@Override
	public void mixFields() {
		ArrayList<Integer> ind = new ArrayList<Integer>();
        ArrayList<Integer> randomIndexes = new ArrayList<Integer>();

        for ( int i = 0; i < getFieldNumber(); i++ ) {
            ind.add(i);
        }
        
        while ( ind.size() > 0 ) {
            int size = ind.size();
            int index = rnd.nextInt(size);
            randomIndexes.add(ind.get(index));
            ind.remove(index);
        }
        
        indexes = new int[randomIndexes.size()];
        for ( int i = 0; i < randomIndexes.size(); i++ ) {
        	indexes[i] = randomIndexes.get(i);
        }
	}

	@Override
	public void changeFields(int index1, int index2) {
		int index = indexes[index1];
		indexes[index1] = indexes[index2];
		indexes[index2] = index;
	}
	
	@Override
	public boolean isCorrectOrder() {
		for ( int i = 0; i < fields.length; i++ ) {
//			Log.i("# isCorrectOrder", i + " " + getField(i));
			if ( i != getField(i).getOriginalIndex() ) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int getFieldNumber() {
		return fields.length;
	}

	@Override
	public int getFieldTop(int index) {
		return fields[index].getTop();
	}

	@Override
	public int getFieldLeft(int index) {
		return fields[index].getLeft();
	}

	@Override
	public int getFieldWidth(int index) {
		return fields[index].getWidth();
	}

	@Override
	public int getFieldHeight(int index) {
		return fields[index].getHeight();
	}
	
	@Override
	public Field getField(int index) {
		return fields[indexes[index]];
	}
	
	@Override
	public int getFieldIndex(int x, int y) {
		for ( int i = 0; i < fields.length; i++ ) {
			int left = getFieldLeft(i);
			int top = getFieldTop(i);
			int width = getFieldWidth(i);
			int height = getFieldHeight(i);
			if (( x > left && x < left + width ) && ( y > top && y < top + height )) {
				return i;
			}
		}
		return -1;
	}

	void addField(int index, Bitmap image, int top, int left, int width, int height) {
		fields[index] = new Field(index, top, left, width, height, 
				ImageUtils.cropImage(image, top, left, width, height));
	}
	
}
