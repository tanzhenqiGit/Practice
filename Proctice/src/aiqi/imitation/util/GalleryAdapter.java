/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-3-7 ÏÂÎç3:24:27.
*/ 
package aiqi.imitation.util;

import com.example.proctice.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * @author Administrator
 * @date
 */
public class GalleryAdapter extends BaseAdapter{


	@Override
	public int getCount() {
		return mImages.length;
	}


	@Override
	public Object getItem(int pos) {
		return mImages[pos];
	}


	@Override
	public long getItemId(int position) {
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = null;
		if (mContext != null)
		{
			v = LayoutInflater.from(mContext).inflate(R.layout.aiqi_gallery_item_view, null);
			if (v != null && mImages != null && mImages.length >= position) {
				ImageView iv = (ImageView) v.findViewById(R.id.aiqi_gallery_item_view_img);
				iv.setImageResource(mImages[position]);
			} else {
				Log.e(TAG.toString(), "GalleryAdapter LayoutInflater.form is null");
			}
		}
		return v;
	}
	
	public GalleryAdapter(Context c)
	{
		mContext = c;
	}
	
	private LOG_String TAG = new LOG_String();
	private Context mContext;
	private int[] mImages = new int[]
	{
		R.drawable.t1,
		R.drawable.t2,
		R.drawable.t3,
		R.drawable.t1,
		R.drawable.t2,
		R.drawable.t3,
	};
			
}
