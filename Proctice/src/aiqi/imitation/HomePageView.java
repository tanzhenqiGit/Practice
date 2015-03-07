package aiqi.imitation;

import aiqi.imitation.util.GalleryAdapter;
import aiqi.imitation.util.LOG_String;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
				GalleryAdapter adapter = new GalleryAdapter(mHomePageView.getContext());
				if (mGallery != null && adapter != null)
				{
					mGallery.setAdapter(adapter);
					mExpandableListView.addHeaderView(mExpandListHeaderView);
				}
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
	
	private View mHomePageView;
	private LOG_String mTAG = new LOG_String();
	private View mExpandListHeaderView;
	private Gallery mGallery;
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
