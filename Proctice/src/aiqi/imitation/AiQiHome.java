package aiqi.imitation;

import com.example.proctice.R;

import aiqi.imitation.util.LOG_String;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.OnTabChangeListener;
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
		    setmTabView();
		    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getTabItemView(0)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getTabItemView(1)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getTabItemView(2)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(getTabItemView(3)) ,HomePageView.class, null);
		    mTabHost.addTab(mTabHost.newTabSpec("tab5").setIndicator(getTabItemView(4)) ,HomePageView.class, null);
		    mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
				
				@Override
				public void onTabChanged(String tabId) {
					updateTabImage();
				}
			});
		    updateTabImage();
		} else {
			Log.d(mTAG.toString(), "initialize get mTAbHost return null");
		}

	}
	
	private void setmTabView()
	{
		if (mTabHost == null) 
		{
			Log.e(mTAG.toString(), "setmTabView mTabHost == null");
			return;
		}
		mTabView = new View [5];
		Log.d(mTAG.toString(), "setmTabView size = " + mTabView.length);
		for (int i = 0; i < mTabView.length; i++)
		{
			mTabView[i] = mLayoutInflater.inflate(R.layout.tab_item_view, null);
		}
	}
	
	private void updateTabImage()
	{
		int selectTab = mTabHost.getCurrentTab();
		Log.d(mTAG.toString(), "updateTabImage selectTab=" + selectTab);
		for (int index = 0; index < mTabView.length; index++)
		{
			ImageView iv = (ImageView) mTabView[index].findViewById(R.id.tab_item_view_img);
			TextView tv = (TextView) mTabView[index].findViewById(R.id.tab_item_view_txt);
			if (iv == null && tv != null){
				Log.e(mTAG.toString(), "updateTabImage iv == null or tv == null");
				return;
			}
			if (selectTab == index) {
				iv.setImageResource(mTabSelectImgs[index]);
				tv.setTextColor(Color.parseColor("#57810f"));
			} else {
				iv.setImageResource(mTabImgs[index]);
				tv.setTextColor(Color.parseColor("#ffffff"));
			}
		}
	}
	
	private View getTabItemView(int index)
	{
		View view = mTabView[index];
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
	private View mTabView[];
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
	
	private int [] mTabSelectImgs = new int [] {
		R.drawable.icon_1_c,
		R.drawable.icon_2_c,
		R.drawable.icon_3_c,
		R.drawable.icon_4_c,
		R.drawable.icon_5_c,
	};
	

}
