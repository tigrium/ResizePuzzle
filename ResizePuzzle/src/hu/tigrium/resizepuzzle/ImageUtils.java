package hu.tigrium.resizepuzzle;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;

public class ImageUtils {
	public static Bitmap cropImage(Bitmap image, int top, int left, int width, int height) {
		width = Math.min(width, image.getWidth() - left);
		height = Math.min(height, image.getHeight() - top);
		return Bitmap.createBitmap(image, left, top, width, height);
	}
	
	public static Bitmap cropAndResizeImageCenter(Bitmap image, int width, int height) {
		double ratio = (double)width / height;
		if ( (double)image.getWidth() / image.getHeight() > ratio ) {
			int newWidth = (int)(ratio * image.getHeight());
			int left = (int)((image.getWidth() - newWidth) / 2);
			image = cropImage(image, 0, left, newWidth, image.getHeight());
		} else {
			int newHeight = (int)(image.getWidth() / ratio);
			int top = (int)((image.getHeight() - newHeight) / 2);
			image = cropImage(image, top, 0, image.getWidth(), newHeight);
		}
		return resizeImage(image, width, height);
	}
	
	public static Bitmap resizeImage(Bitmap image, int width, int height) {
		int oWidth = image.getWidth();
		int oHeight = image.getHeight();
		
		float scaleWidth = ((float) width) / oWidth;
		float scaleHeight = ((float) height) / oHeight;
		
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		
		return Bitmap.createBitmap(image, 0, 0, oWidth, oHeight, matrix, false);
	}
	
}
