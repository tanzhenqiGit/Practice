package com.example.proctice.gameview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

@SuppressLint("DrawAllocation") public class GameView extends View {

	private int mY = 0;
	private int mCount = 0;
	public GameView(Context context) {
		super(context);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (mCount <= 100) {
			mCount++;
		} else {
			mCount = 0;
		}
		Paint paint = new Paint();
		switch (mCount % 4)
		{
		case 0: paint.setColor(Color.BLACK); break;
		case 1: paint.setColor(Color.BLUE); break;
		case 2: paint.setColor(Color.CYAN); break;
		case 3: paint.setColor(Color.DKGRAY); break;
		default:paint.setColor(Color.GREEN); break;
		}
		if (canvas != null) {
			canvas.drawRect(50, mY, 350, mY + 100, paint);
		}
	}
	

}
