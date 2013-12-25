package hu.tigrium.resizepuzzle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.widget.Toast;

public class GameActivity extends Activity {
	private PuzzleView puzzleView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        
		Intent intent = getIntent();
		String path = intent.getStringExtra("imgPath");
		puzzleView = new PuzzleView(this, path, 
				displaymetrics.widthPixels, displaymetrics.heightPixels);
        
		setContentView(puzzleView);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		puzzleView.setSize(displaymetrics.widthPixels, displaymetrics.heightPixels);
	}
}
