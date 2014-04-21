package com.example.tpb_sb;

import android.app.Fragment;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	private SoundPool soundPool1;
	private SoundPool soundPool2;
	private SoundPool soundPool3;
	private SoundPool soundPool4;
	private SoundPool soundPool5;
	private SoundPool soundPool6;
	private int soundID1;
	private int soundID2;	
	private int soundID3;	
	private int soundID4;	
	private int soundID5;	
	private int soundID6;	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        
        soundPool1 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID1 = soundPool1.load(MainActivity.this, R.raw.sound, 1);
        /*
        soundPool2 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID2 = soundPool2.load(MainActivity.this, R.raw.sound2, 1);
        
        soundPool3 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID3 = soundPool3.load(MainActivity.this, R.raw.sound3, 1);
        
        soundPool4 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID4 = soundPool4.load(MainActivity.this, R.raw.sound4, 1);
        
        soundPool5 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID5 = soundPool5.load(MainActivity.this, R.raw.sound5, 1);
        
        soundPool6 = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundID6 = soundPool6.load(MainActivity.this, R.raw.sound6, 1);
*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void playSound(SoundPool sp, int soundId) {
    	Log.e("Test", "got here");
    	AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
    	float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    	float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    	float volume = actualVolume / maxVolume;
    	Log.e("Test", "Played Sound");
    	sp.play(soundId, volume, volume, 1, 0, 1f);
    }
    
    public void playFirst(View view)
    {
    	playSound(soundPool1, soundID1);
    }

}
