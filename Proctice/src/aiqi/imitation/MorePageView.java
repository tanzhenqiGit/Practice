package aiqi.imitation;

import com.example.proctice.R;

import aiqi.imitation.util.LOG_String;
import aiqi.imitation.util.ListBaseAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

@SuppressLint("InflateParams")
public class MorePageView extends Fragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG.toString(), "MorePageView onCreateView");
		mMorePageView = inflater.inflate(R.layout.aiqi_more, null);
		mList = (ListView) mMorePageView.findViewById(R.id.aiqi_more_list);
		mContents = mMorePageView.getResources().getStringArray(R.array.listMoreInfoContents);
		ListBaseAdapter adapter = new ListBaseAdapter(mMorePageView.getContext(), mContents);
		if (mList != null)
		{
			mList.setAdapter(adapter);
		}
		return mMorePageView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}
	
	private LOG_String TAG = new LOG_String();
	private View mMorePageView;
	private ListView mList;
	private String[] mContents;

}
