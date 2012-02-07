package com.cs125.snapvote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class testCamera extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startpage);
		// Listen Button "start"
		Button start = (Button) findViewById(R.id.start_vote);

		OnClickListener startApp = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent startNextSlide = new Intent();
				startNextSlide.setClass(testCamera.this, CaptureVote.class);
				startActivity(startNextSlide);
				finish();
			}
		};

		start.setOnClickListener(startApp);
		// Listen Button "Exit"

		Button exit = (Button) findViewById(R.id.exit_app);

		OnClickListener exitApp = new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}

		};
		exit.setOnClickListener(exitApp);

	}
}