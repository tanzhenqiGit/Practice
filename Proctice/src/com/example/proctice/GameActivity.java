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
		// TODO �Զ����ɵķ������
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO �Զ����ɵķ������
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO �Զ����ɵķ������
		return super.onKeyUp(keyCode, event);
	}
	

	
}
