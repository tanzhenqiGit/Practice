package aiqi.imitation;

import java.util.Timer;
import java.util.TimerTask;

import aiqi.imitation.util.FlowGalleryIndicator;
import aiqi.imitation.util.GalleryAdapter;
import aiqi.imitation.util.LOG_String;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proctice.R;

@SuppressWarnings("deprecation")
public class HomePageView extends Fragment{

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(mTAG.toString(), "homePageView onCreateView");
		mHomePageView = inflater.inflate(R.layout.home_page_view, null);
		mExpandListHeaderView  = inflater.inflate(R.layout.aiqi_expand_lsit_hander_view , null);

		initialize();
		return mHomePageView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(mTAG.toString(), "homePageView onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		Log.d(mTAG.toString(), "homePageView onDestroy");
		super.onDestroy();
	}
	
	

	@Override
	public void onDestroyView() {
		Log.d(mTAG.toString(), "homePageView onDestroyView");
			if (mTimer != null) {
				mTimer.cancel();
				mTimer = null;
		}
		super.onDestroyView();
	}



	private void initialize()
	{
		 mGroups = mHomePageView.getResources().getStringArray(R.array.listGroupContents);
		 mAdapter = new AiQiExpandAdapter();
		 
		if (mHomePageView != null) {
			mExpandableListView = (ExpandableListView) mHomePageView
					.findViewById(R.id.home_page_view_list);
			
			if (mExpandListHeaderView != null) {
				mGallery = (Gallery) mExpandListHeaderView
						.findViewById(R.id.aiqi_expand_list_hander_view_gallery);
				mGalleryAdapter = new GalleryAdapter(mHomePageView.getContext());
				if (mGallery != null && mGalleryAdapter != null)
				{
					mGallery.setAdapter(mGalleryAdapter);
					mExpandableListView.addHeaderView(mExpandListHeaderView);
				}
				mGalleryIndex = (FlowGalleryIndicator) mExpandListHeaderView
						.findViewById(R.id.aiqi_expand_list_hander_view_indicator);
				mGalleryIndex.setmCounts(mGalleryAdapter.getCount());
				 mGallery.setSelection(0, true);
				mGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						mGalleryIndex.setmSelected(arg2);
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				mTimer = new Timer();
				mTimer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						if (mHandler != null)
						{
							mHandler.sendEmptyMessage(MSG_GALLERY_CHANGED);
						}
					}
				}, 0, 5 * 1000);
				
			} else {
				Log.e(mTAG.toString(), "HomePageView initialize mExpandListHeaderView == null");
				return;
			}
			
			if (mExpandableListView != null || mAdapter != null) {
				mExpandableListView.setAdapter(mAdapter);
			} else {
				Log.e(mTAG.toString(), "mExpandableListView == null || mAdapter == null");
				return;
			}
	
		}
	}
	
	private void handlerMsg(Message msg)
	{
		switch (msg.what)
		{
		case MSG_GALLERY_CHANGED:
			 int curPos = mGallery.getSelectedItemPosition();
			 
			 if (curPos == mGallery.getCount() - 1){
				 mGallery.setLayoutAnimation(new LayoutAnimationController(
					  AnimationUtils.loadAnimation(this.getActivity(),
							  R.anim.gallery_in)));
			 	mGallery.setSelection(0, true);
			 } else{
				MotionEvent e1 = MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN,
						50.0f, 250f, 0);
				MotionEvent e2 = MotionEvent.obtain(SystemClock.uptimeMillis(),
						SystemClock.uptimeMillis(), MotionEvent.ACTION_UP,
						300.0f, 250.0f, 0);
		
				mGallery.onFling(e1, e2, -1800, 0);
				e1.recycle();
				e2.recycle();
				msg.recycle();
			 }
			break;
		default:
			
			break;
		}
	}
	
	private View mHomePageView;
	private LOG_String mTAG = new LOG_String();
	private View mExpandListHeaderView;
	private FlowGalleryIndicator mGalleryIndex;
	private Gallery mGallery;
	private GalleryAdapter mGalleryAdapter;
	private Timer mTimer;
	private final int MSG_GALLERY_CHANGED = 0x10;
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg) {
			handlerMsg(msg);
		}
		
	};
	private ExpandableListView mExpandableListView;
	private AiQiExpandAdapter mAdapter;
	private String[] mGroups;
	@SuppressLint("InflateParams")
	private class AiQiExpandAdapter extends BaseExpandableListAdapter
	{

		@Override
		public int getGroupCount() {
			return mGroups.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return mChilds[groupPosition].length;
		}

		@Override
		public String getGroup(int groupPosition) {
			return mGroups[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return mChilds[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return groupPosition*CHILD_LENGTH + childPosition;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			convertView = LayoutInflater.from(
				mHomePageView.getContext()).inflate(R.layout.aiqi_expand_list_group, null);
			if (convertView == null) {
				Log.e(mTAG.toString(),"getgroupView return null");
				return null;
			}
			ImageView iv = (ImageView) convertView.findViewById(R.id.aiqi_expand_list_group_img);
			TextView tv = (TextView) convertView.findViewById(R.id.aiqi_expand_list_group_txt);
			if (isExpanded)
			{
				iv.setImageResource(R.drawable.list_indecator_button_down);
			} else {
				iv.setImageResource(R.drawable.list_indecator_button);
			}
			tv.setText(getGroup(groupPosition));
			return convertView;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			return LayoutInflater.from(
					mHomePageView.getContext()).inflate(R.layout.aiqi_expand_list_child, 
							null);
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
		
		
		public AiQiExpandAdapter()
		{
			Log.d(mTAG.toString(), "AiQiExpandAdapter");
			setChildContents();
			if (mGroups == null) {
				Log.e(mTAG.toString(), "AiQiExpandAdapter mGroups == null");
			}
		}
		
		private boolean setChildContents()
		{
			mChilds = new String[GROUP_LENGTH][CHILD_LENGTH];
			for(int group = 0; group < GROUP_LENGTH; group++)
			{
				for(int child = 0; child < CHILD_LENGTH; child++)
				{
					mChilds[group][child]= group + "-" + child;
				}
			}
			return true;
		}
		


		private String[][] mChilds;
		private final int CHILD_LENGTH = 10;
		private final int GROUP_LENGTH = 5;

	
		
		
	}
}
