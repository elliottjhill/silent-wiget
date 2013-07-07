package com.ehdev.silent_widget;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SilencePhone extends Activity {
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silence_phone);
        
        Button silentButton = (Button) findViewById(R.id.volume);
        silentButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 AudioManager audioMan = (AudioManager) getSystemService(AUDIO_SERVICE);
				 if (audioMan.getRingerMode() == AudioManager.RINGER_MODE_SILENT) {
					 audioMan.setRingerMode(AudioManager.RINGER_MODE_NORMAL);				
				 } else {
					 audioMan.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				 }
			}
		});
        
        Button volButton = (Button) findViewById(R.id.sync);
        volButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 ContentResolver.setMasterSyncAutomatically(!ContentResolver.getMasterSyncAutomatically());			
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.silence_phone, menu);
        return true;
    }
    
}
