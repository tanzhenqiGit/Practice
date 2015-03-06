/** 
* Copyright 2015 TanZhenqi's Studio.
* All Right Reserved.
* @author author E-mail: tan_zhenqi@163.com.
* @version create time:2015-3-4 ����9:36:46.
*/ 
package com.example.proctice.common;

import com.example.proctice.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Administrator
 * @date
 */
public abstract class CommonListActivity<T> extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	public abstract void onListItemClicked(
			AdapterView<?> parent, View view, int position, long id);
	public abstract T [] getListContents();
	public abstract T getTAG();
	
	private void initialize()
	{
		Log.d(getTAG().toString(),"initialize");
		setContentView(R.layout.common_llist_main);
		mList = (ListView) findViewById(R.id.common_list_main_list);
		mContents = getListContents();
		if (mList == null || mContents == null) {
			Log.e(getTAG().toString(), "mList == null or mContents == NULL");
			return;
		}
		ArrayAdapter<T> adapter = new ArrayAdapter<T>(
				CommonListActivity.this,
				android.R.layout.simple_list_item_1,
				mContents);
		if (mList != null) {
			mList.setAdapter(adapter);
			mList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> adapterView, View view,
						int position, long id) {
					onListItemClicked(adapterView,view,position,id);
				}
				
			});
		}

	}	
	private ListView mList;
	private T[] mContents = null;
}
