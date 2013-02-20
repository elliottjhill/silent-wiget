package com.ehdev.silent_widget;

import android.media.AudioManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SilencePhone extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silence_phone);
        
        Button silentButton = (Button) findViewById(R.id.silent_button);
        silentButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 AudioManager audioMan = (AudioManager) getSystemService(AUDIO_SERVICE);
				 audioMan.setRingerMode(AudioManager.RINGER_MODE_SILENT);				
			}
		});
        
        Button volButton = (Button) findViewById(R.id.full_volume);
        volButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 AudioManager audioMan = (AudioManager) getSystemService(AUDIO_SERVICE);
				 audioMan.setRingerMode(AudioManager.RINGER_MODE_NORMAL);				
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
