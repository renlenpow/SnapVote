/**
 * 
 * Copyright (C) 2011	Yalan Meng <mengyalan@gmail.com>,
 * 						Wei Chen <eternalcharlie@gmail.com>
 * 
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                     Version 2, December 2004
 *  Everyone is permitted to copy and distribute verbatim or modified
 *  copies of this license document, and changing it is allowed as long
 *  as the name is changed.
 * 
 *             DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *  TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *  
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 */

// @author ymeng7

package com.cs125.snapvote;

import java.util.TimerTask;

//import com.cs125.snapvote.R;
import com.google.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import java.util.*;
import android.app.*;
import android.content.Intent;
import android.graphics.*;
import android.hardware.Camera;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class CaptureVote extends Activity {
	private CameraSurfaceHolder CameraSFHolder;
	private SurfaceView cameraSufaceView;
	private View foco;
	private ImageView scannedImg;
	private TextView result, screenShow;
	private Button submit;
	private Timer timer;
	private CameraTimerTask timerTask;
	private boolean decoded = false;
	final static int w = 480;
	final static int h = 320;
	boolean runned = false;
	int left, top, width, height;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		this.setTitle("Capture Your Vote, please");

		cameraSufaceView = (SurfaceView) this.findViewById(R.id.cameraSFV);
		foco = (View) this.findViewById(R.id.centerView);
		// foco.setVisibility(View.INVISIBLE);
		scannedImg = (ImageView) this.findViewById(R.id.ImageView);
		scannedImg.setVisibility(View.INVISIBLE);
		result = (TextView) this.findViewById(R.id.result);
		result.setTextColor(Color.RED);
		result.setVisibility(View.INVISIBLE);
		screenShow = (TextView) this.findViewById(R.id.screenShow);
		screenShow.setTextColor(Color.RED);
		CameraSFHolder = new CameraSurfaceHolder(cameraSufaceView.getHolder(), w,
				h, previewCallback);
		submit = (Button) this.findViewById(R.id.submitButton);
		submit.setVisibility(View.GONE);
		submit.setOnClickListener(submitListener);
		// Initialize timer
		timer = new Timer();
		timerTask = new CameraTimerTask();
		timer.schedule(timerTask, 0, 200);

	}

	private OnClickListener submitListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(CaptureVote.this, SubmitResult.class);
			Bundle bundle = new Bundle();
			bundle.putString("result", result.getText().toString());
			intent.putExtras(bundle);
			startActivity(intent);
			finish();
		}
	};

	class CameraTimerTask extends TimerTask {

		@Override
		public void run() {
			if (left == 0) {
				left = foco.getLeft() * w
						/ getWindowManager().getDefaultDisplay().getWidth();
				top = foco.getTop() * h
						/ getWindowManager().getDefaultDisplay().getHeight();
				width = (foco.getRight() - foco.getLeft()) * w
						/ getWindowManager().getDefaultDisplay().getWidth();
				height = (foco.getBottom() - foco.getTop()) * h
						/ getWindowManager().getDefaultDisplay().getHeight();
			}
			CameraSFHolder.AutoFocusAndPreviewCallback();

		}
	}

	private Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() {

		@Override
		public void onPreviewFrame(byte[] data, Camera camera) {
			PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
					data, w, h, left, top, width, height, false);
			Bitmap bitmap = source.renderCroppedGreyscaleBitmap();
			scannedImg.setImageBitmap(bitmap);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					source));
			MultiFormatReader reader = new MultiFormatReader();
			try {
				Result decodeResult = reader.decode(binaryBitmap);
				String tmpResult = "" + decodeResult.getText();
				String votenum = "" + tmpResult.charAt(0);
				String poll_id = tmpResult.substring(1);

				result.setText(tmpResult);
				result.setVisibility(View.INVISIBLE);

				screenShow.setText("You are voting for Option Number "
						+ votenum + " for Poll ID " + poll_id);

				decoded = true;
			} catch (Exception e) {
				submit.setVisibility(View.GONE);
				screenShow.setText("Please vote :-)");
			}
			if (decoded) {
				submit.setVisibility(View.VISIBLE);
			}

		}
	};
}