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
	/** Action to be used when attempting to silence or volumise the phone */
	public static final String SILENT_ACTION = "volume-action";

	@Override
	public void onReceive(Context context, Intent intent) {
		 AudioManager audioMan = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		 if (audioMan.getRingerMode() == AudioManager.RINGER_MODE_SILENT) {
			 audioMan.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		 } else {
			 audioMan.setRingerMode(AudioManager.RINGER_MODE_SILENT); 
		 }
	}

}
