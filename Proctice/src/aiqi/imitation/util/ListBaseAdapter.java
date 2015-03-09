package aiqi.imitation.util;

import com.example.proctice.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListBaseAdapter extends BaseAdapter{
	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.aiqi_list_item, null);
		if (convertView == null)
		{
			Log.e(TAG.toString(), "view == null");
			return null;
		}
		TextView tv = (TextView) convertView.findViewById(R.id.aiqi_list_item_txt);
		if (tv != null && position < mContents.length) {
			tv.setText(mContents[position]);
		}
		return convertView;
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public Object getItem(int position) {
		return mContents[position];
	}
	
	@Override
	public int getCount() {
		return mContents.length;
	}
	

	public ListBaseAdapter(Context mContext, String[] mContents) {
		super();
		this.mContext = mContext;
		this.mContents = mContents;
	}


	private Context mContext;
	private String [] mContents;
	private LOG_String TAG = new LOG_String();
};

