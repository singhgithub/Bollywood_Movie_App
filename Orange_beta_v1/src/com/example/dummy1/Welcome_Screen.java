package com.example.dummy1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class Welcome_Screen extends Activity {
	
	MediaPlayer welcome_sound;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome__screen);
		
		welcome_sound = MediaPlayer.create(Welcome_Screen.this, R.raw.welcome_sound_mp3);
		welcome_sound.start();
		
		
		//thread class is a java timing class
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					System.out.println("welcome screen class called");
					//intent is used to go a desired activity or page
					Intent intent_name = new Intent(Welcome_Screen.this, MainActivity.class);
					startActivity(intent_name);
				}
			}
		};
		
		timer.start();
		
		}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		welcome_sound.pause(); 		//this stop the music from playing after the welcomoe screen
		finish(); // this will kill the welcome_screen activity onces it has been displayed
					// so when i press the back button i wouldn't see the welcomescreen activity again
		
		
	
	}
	

}

	
