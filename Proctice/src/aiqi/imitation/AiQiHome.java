package aiqi.imitation;

import com.example.proctice.R;

import aiqi.imitation.util.LOG_String;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("InflateParams")
public class AiQiHome extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		initialize();
	}
	
	private void initialize()
	{
		setContentView(R.layout.aiqi_home);
		mLayoutInflater = LayoutInflater.from(this);
		mTabContents  = getResources().getStringArray(R.array.aiqiTabContents);
		setFragmentTabHost();
	}
	
	private void setFragmentTabHost()
	{
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		if (mTabHost != null) {
			mTabHost.setup(this, getSupportFragmentManager(),R.id.realtabcontent);
		    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getTabItemView(0)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getTabItemView(1)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getTabItemView(2)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(getTabItemView(3)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab5").setIndicator(getTabItemView(4)) ,HomePageView.class, null);
		} else {
			Log.d(mTAG.toString(), "initialize get mTAbHost return null");
		}
	}
	
	
	private View getTabItemView(int index)
	{
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView iv = (ImageView) view.findViewById(R.id.tab_item_view_img);
		TextView tv = (TextView) view.findViewById(R.id.tab_item_view_txt);
		if (iv == null || tv == null) {
			Log.e(mTAG.toString(), "getTabItemView return null");
			return null;
		}
		if (index < mTabContents.length && index < mTabImgs.length) {
			tv.setText(mTabContents[index]);
			iv.setImageResource(mTabImgs[index]);
			Log.d(mTAG.toString(),mTabContents[index]);
		} else {
			tv.setText(mTabContents[0]);
			iv.setImageResource(mTabImgs[0]);
		}
		return view;
	}
	
	private FragmentTabHost mTabHost;
	private LOG_String mTAG = new LOG_String();
	private LayoutInflater mLayoutInflater;
	private String[] mTabContents;
	private int[] mTabImgs = new int [] {
		R.drawable.icon_1_n,
		R.drawable.icon_2_n,
		R.drawable.icon_3_n,
		R.drawable.icon_4_n,
		R.drawable.icon_5_n,
	};

}
