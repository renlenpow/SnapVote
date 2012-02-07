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

import android.view.SurfaceHolder;
import android.hardware.Camera;
import android.graphics.PixelFormat;
import android.util.Log;
import java.io.IOException;

public class CameraSurfaceHolder implements SurfaceHolder.Callback {
	private SurfaceHolder holder;
	private Camera camera;
	private Camera.PreviewCallback previewCallback;
	private int width, height;

	public CameraSurfaceHolder(SurfaceHolder holder, int width, int height,
			Camera.PreviewCallback previewCallback) {
		this.holder = holder;
		this.holder.addCallback(this);
		this.holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		this.width = width;
		this.height = height;

		this.previewCallback = previewCallback;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(holder);
			Log.e("Camera", "Camera surface created.");
		} catch (IOException e) {
			camera.release();
			camera = null;
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Camera.Parameters para = camera.getParameters();
		para.setPreviewSize(this.width, this.height);
		para.setPictureFormat(PixelFormat.JPEG);
		camera.setParameters(para);
		camera.startPreview();
		Log.e("Camera", "Camera surface changed.");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		camera.setPreviewCallback(null);
		camera.stopPreview();
		camera = null;
		Log.e("Camera", "Camera surface destroyed.");
	}

	private Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {

		@Override
		public void onAutoFocus(boolean success, Camera camera) {
			if (success) { // if success, return callback
				camera.setOneShotPreviewCallback(previewCallback);
			}
		}
	};

	public void AutoFocusAndPreviewCallback() {
		if (camera != null) {
			camera.autoFocus(autoFocusCB);
		}
	}
}