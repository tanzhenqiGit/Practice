package com.example.proctice;

import com.example.proctice.common.CommonListActivity;


import aiqi.imitation.AiQiHome;
import aiqi.imitation.util.LOG_String;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

public class HomeActivity extends CommonListActivity<String> {

	@Override
	public void onListItemClicked(AdapterView<?> parent, View view,
			int position, long id) {
		switch(position)
		{
		case AIQI:
			Intent aiqiIntent = new Intent(HomeActivity.this, AiQiHome.class);
			startActivity(aiqiIntent);
			break;
		default:
			break;
		}
	}

	@Override
	public String[] getListContents() {
		mContents = getResources().getStringArray(R.array.projectContents);
		return mContents;
	}

	@Override
	public String getTAG() {
		return TAG.toString();
	}

	private String[] mContents;
	private LOG_String TAG = new LOG_String();
	public final int AIQI = 0;
}
