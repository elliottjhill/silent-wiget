package com.ehdev.silent_widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

/**
 * This is a receiver that will receive the intent to make the silence or unsilence the phone.s
 * 
 * @author Elliott
 *
 */
public class SilentReceiver extends BroadcastReceiver {
	/** Action to be used when attempting to silence the phone */
	public static final String SILENT_ACTION = "silent";
	/** Action to be used when attempting to unsilence the phone */
	public static final String LOUD_ACTION = "loud";

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(SILENT_ACTION)) {
			 AudioManager audioMan = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			 audioMan.setRingerMode(AudioManager.RINGER_MODE_SILENT);	
		} else if (intent.getAction().equals(LOUD_ACTION)) {
			 AudioManager audioMan = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			 audioMan.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		}
		
	}

}
