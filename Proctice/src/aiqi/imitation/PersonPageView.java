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

public class PersonPageView extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}


	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mPersonPageView = inflater.inflate(R.layout.aiqi_person, null);
		mList = (ListView) mPersonPageView.findViewById(R.id.aiqi_person_list);
		mAccountContents = mPersonPageView.getResources().getStringArray(R.array.listAccountContents);
		Log.d(TAG.toString(), "PersonPageView onCreateView mAccountContents:size="+ mAccountContents.length);
		ListBaseAdapter adapter = new ListBaseAdapter(mPersonPageView.getContext(),mAccountContents);
		
		if (mList != null && adapter != null)
		{
			mList.setAdapter(adapter);
		}
		return mPersonPageView;
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
	private View mPersonPageView;
	private ListView mList;
	private String[] mAccountContents;
}
