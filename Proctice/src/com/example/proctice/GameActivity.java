package com.example.proctice;

import com.example.proctice.gameview.GameView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class GameActivity extends Activity {
	private GameView mGv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGv = new GameView(this);
		setContentView(mGv);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO 自动生成的方法存根
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		return super.onKeyUp(keyCode, event);
	}
	

	
}
