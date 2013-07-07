package com.ehdev.silent_widget;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;

/**
 * This is a receiver that will receive the intent to turn on or off sync for the phone
 * 
 * @author Elliott
 *
 */
public class SyncReceiver extends BroadcastReceiver {
	/** Action to be used when attempting to silence or volumise the phone */
	public static final String SYNC_ACTION = "sync-action";

	@Override
	public void onReceive(Context context, Intent intent) {
		 ContentResolver.setMasterSyncAutomatically(!ContentResolver.getMasterSyncAutomatically());
	}

}
