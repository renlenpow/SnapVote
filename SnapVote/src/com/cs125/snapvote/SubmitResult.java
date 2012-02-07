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

// @author weichen7

package com.cs125.snapvote;

import java.util.UUID;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import android.widget.TextView;

public class SubmitResult extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit);
		// Get decoded result and parse into String
		Bundle bundle = this.getIntent().getExtras();
		String result = bundle.getString("result");
		String votenum = ""+result.charAt(0);
		String poll_id = result.substring(1);
   		

		// Get Device Unique ID
		final TelephonyManager tm = (TelephonyManager) getBaseContext()
				.getSystemService(Context.TELEPHONY_SERVICE);

		final String tmDevice, tmSerial, androidId;
		tmDevice = "" + tm.getDeviceId();
		tmSerial = "" + tm.getSimSerialNumber();
		androidId = ""
				+ android.provider.Settings.Secure.getString(
						getContentResolver(),
						android.provider.Settings.Secure.ANDROID_ID);

		UUID deviceUuid = new UUID(androidId.hashCode(),
				((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
		String deviceId = deviceUuid.toString();
//
		/**
		 * Get decoded result and submit it alone with Machine IMEI to a certain
		 * website
		 */
//		WebView mWebView;
		String url = getString(R.string.wheretosubmit)
				+ "?f=vote&poll_id=" + poll_id + "&votenum=" + votenum + "&sc=" + deviceId;
//		 mWebView = (WebView) findViewById(R.id.webview);
//		    mWebView.getSettings().setJavaScriptEnabled(true);
//		    mWebView.loadUrl(url);
		Uri address = Uri.parse(url);
		Intent submitResult = new Intent(Intent.ACTION_VIEW, address);
		startActivity(submitResult);
		finish();

	}
//	private TextView text;
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
//
//        text = (TextView) this.findViewById(R.id.text);
//        
//        Bundle bundle = this.getIntent().getExtras();
//		String result = bundle.getString("result");
//		String votenum = "" + result.charAt(0);
//		String poll_id = result.substring(1);
//		text.setText("Vote Num: "+votenum+"\n poll id: "+poll_id);
//		}
    }