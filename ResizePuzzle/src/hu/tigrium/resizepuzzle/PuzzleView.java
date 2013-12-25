package hu.tigrium.resizepuzzle;

import hu.tigrium.resizepuzzle.tables.Table;
import hu.tigrium.resizepuzzle.tables.Table1;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class PuzzleView extends View implements OnTouchListener {
	private Context context;
    private Paint paint = new Paint();
    private Table table;
    private int selected = -1;
    private boolean paintLines = true;
    private String imgPath;
    
    public PuzzleView(Context context, String imgPath, int width, int height) {
        super(context);
        setOnTouchListener(this);
        
        this.context = context;
        this.imgPath = imgPath;
        
        table = new Table1(imgPath, width, height);
    	table.mixFields();
    }

    @Override
    public void onDraw(Canvas canvas) {
    	for ( int i = 0; i < table.getFieldNumber(); i++) {
	    	drawImage(canvas, i);
	    	if ( paintLines ) {
	    		drawLines(canvas, i, Color.BLUE);
	    	}
    	}
    	
    	drawLines(canvas, selected, Color.YELLOW, true);
    }
    
    private void drawImage(Canvas canvas, int index) {
		int top = table.getFieldTop(index);
		int left = table.getFieldLeft(index);
		int width = table.getFieldWidth(index);
		int height = table.getFieldHeight(index);
    	canvas.drawBitmap(table.getField(index).getImage(width, height), left, top, paint);
    }
    
    private void drawLines(Canvas canvas, int index, int color) {
    	drawLines(canvas, index, color, false);
    }
    
    private void drawLines(Canvas canvas, int index, int color, boolean drawBorder) {
    	if ( index < 0 || index >= table.getFieldNumber() ) {
//        	Log.i("# index", index + "");
    		return;
    	}
		paint.setColor(color);
    	paint.setStrokeWidth(3);
    	
    	int minX = table.getFieldLeft(index);
    	int minY = table.getFieldTop(index);
    	int maxX = minX + table.getFieldWidth(index);
    	int maxY = minY + table.getFieldHeight(index);
    	
    	if ( minY != 0 || drawBorder ) {	// top
    		canvas.drawLine(minX, minY, maxX, minY, paint);
    	}
    	if ( maxX != canvas.getWidth() || drawBorder ) {	// right
    		canvas.drawLine(maxX, minY, maxX, maxY, paint);
    	}
    	if ( maxY != canvas.getHeight() || drawBorder ) {	// bottom
    		canvas.drawLine(minX, maxY, maxX, maxY, paint);
    	}
    	if ( minX != 0 || drawBorder ) {	// left
    		canvas.drawLine(minX, minY, minX, maxY, paint);
    	}
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		if ( action == MotionEvent.ACTION_UP ) {
			int selIndex = table.getFieldIndex((int)event.getRawX(), (int)event.getRawY());
			if ( selected == -1 ) {
				selected = selIndex;
			} else {
				if ( selected != selIndex ) {
					if ( change(selected, selIndex) ) {
						AlertDialog alertDialog = new AlertDialog.Builder(
								getContext()).create();
						paintLines = false;
						alertDialog.setMessage(getResources().getString(
								R.string.congratulations));
						alertDialog.setButton(Dialog.BUTTON_NEUTRAL, "OK", 
								new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								
							}
						});
						alertDialog.show();
					}
				}
				selected = -1;
			}
		}
		
		invalidate();
		return true;
	}
	
	private boolean change(int i1, int i2) {
		table.changeFields(i1, i2);
		return table.isCorrectOrder();
	}
	
	public void setSize(int width, int height) {
		table.setSize(width, height, imgPath);
	}

}