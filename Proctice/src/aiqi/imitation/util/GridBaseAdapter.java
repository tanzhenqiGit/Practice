package aiqi.imitation.util;

import com.example.proctice.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridBaseAdapter extends BaseAdapter{

	@Override
	public int getCount() {
		return mContents.length;
	}

	@Override
	public String getItem(int position) {
		return mContents[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(R.layout.aiqi_search_grid_item, null);
		TextView tv = (TextView) convertView.findViewById(R.id.aiqi_search_grid_item_txt);
		if (tv != null)
		{
			tv.setText(getItem(position));
		}
		return convertView;
	}

	
	public GridBaseAdapter(Context mContext, String[] mContents) {
		super();
		this.mContext = mContext;
		this.mContents = mContents;
	}


	private Context mContext;
	private String [] mContents;
}
