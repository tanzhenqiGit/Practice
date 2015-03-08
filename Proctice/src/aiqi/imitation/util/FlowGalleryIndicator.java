/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-3-7 ÏÂÎç4:20:39.
*/ 
package aiqi.imitation.util;

import com.example.proctice.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Administrator
 * @date
 */
public class FlowGalleryIndicator extends View{

	/**
	 * @param context
	 * @param attrs
	 */
	public FlowGalleryIndicator(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typeArray 
			= context.obtainStyledAttributes(attrs, R.styleable.FlowGalleryIndicator);
		mCounts = typeArray.getInteger(R.styleable.FlowGalleryIndicator_count, 0);
		mRadius = typeArray.getDimension(R.styleable.FlowGalleryIndicator_point_radius, 1);
		mSpace = typeArray.getDimension(R.styleable.FlowGalleryIndicator_space, 1);
		mNormalColor = typeArray.getColor(R.styleable.FlowGalleryIndicator_point_normal_color, 0x000000);
		mSelectColour = typeArray.getColor(R.styleable.FlowGalleryIndicator_point_seleted_color, 0x000000);
		
	
		if (TAG.DEBUG) {
			int sum = attrs.getAttributeCount();
			String str = "";
			for (int i = 0; i < sum; i++) {
				String name = attrs.getAttributeName(i);
				String value = attrs.getAttributeValue(i);
				str += "attr_name :" + name + ": " + value + "\n";
			}
			Log.i(TAG.toString(), str);
		}
		typeArray.recycle();
		invalidate();
		Log.d(TAG.toString(), "draw height:" + getHeight() +
				"width:" + getWidth());
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.d(TAG.toString(), "widthMeasureSpec=" + widthMeasureSpec
				+ "heightMeasureSpec=" + heightMeasureSpec);

		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint paint = new Paint();
		float width = (getWidth() - (mRadius * 2) * mCounts - mSpace * (mCounts - 1))/2f;
		for (int index = 0; index < mCounts; index++)
		{
			if (index == mSelected)
			{
				paint.setColor(mSelectColour);
			} else {
				paint.setColor(mNormalColor);
			}
			canvas.drawCircle(width + getPaddingLeft() + index *(mRadius*2 + mSpace), 
					getHeight()/2,
					mRadius, 
					paint);
		}
		Log.d(TAG.toString(), "view height:" + getHeight() +
				"and width:" + getWidth());

		
	}
	
	public void setmCounts(int mCounts) {
		this.mCounts = mCounts;
		invalidate();
	}

	public void setmSelected(int mSelected) {
		this.mSelected = mSelected;
		invalidate();
	}
	
	public void next()
	{
		mSelected++;
		if (mSelected >= mCounts - 1)
		{
			mSelected = 0;
		}
		invalidate();
	}
	
	public void previous()
	{
		if (mSelected == 0) {
			mSelected = mCounts - 1;
		}
		mSelected--;
		invalidate();
	}
	
	private int measureHeight(int HeightMeasureSpec)
	{
		int mode = MeasureSpec.getMode(HeightMeasureSpec);
		int size = MeasureSpec.getSize(HeightMeasureSpec);
		Log.d(TAG.toString(), "measureWidth mode = " + mode + ",size=" + size);
		int result = 0;
		if (mode == MeasureSpec.EXACTLY)
		{
			result = size;
		} else {
			result = (int)(getPaddingTop()
					+ getPaddingBottom()
					+ mRadius*2 + 1) ;
			if (mode == MeasureSpec.AT_MOST)
			{
				result = Math.min(HeightMeasureSpec, result);
			}
		}
		Log.d(TAG.toString(), "measureHeight result = " + result);
		return result;
		
	}
	
	private int measureWidth(int WidthMeasureSpec)
	{
		int mode = MeasureSpec.getMode(WidthMeasureSpec);
		int size = MeasureSpec.getSize(WidthMeasureSpec);
		Log.d(TAG.toString(), "measureWidth mode = " + mode + ",size=" + size);
		int result = 0;
		if (mode == MeasureSpec.EXACTLY)
		{
			result = size;
		} else {
			result = (int)(getPaddingLeft() 
					+ getPaddingRight()
					+ mRadius*2*mCounts
					+ mSpace*(mCounts - 1));
			if (mode == MeasureSpec.AT_MOST)
			{
				result = Math.min(WidthMeasureSpec, result);
			}
		}
		Log.d(TAG.toString(), "measureWidth result = " + result);
		return result;
	}
	
	private LOG_String TAG = new LOG_String();
	private int mCounts, mSelected = 0;
	private int mSelectColour, mNormalColor;
	private float mRadius, mSpace;
}
