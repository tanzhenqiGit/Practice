package aiqi.imitation;

import com.example.proctice.R;

import aiqi.imitation.util.GridBaseAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class SearchPageView extends Fragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mSearchPageView = inflater.inflate(R.layout.aiqi_search, null);
		mHotSearchView = (GridView) mSearchPageView.findViewById(R.id.aiqi_serach_hot_search_grid);
		mHistoryView = (GridView) mSearchPageView.findViewById(R.id.aiqi_serach_history_search_grid);
		mContents = mSearchPageView.getResources().getStringArray(R.array.searchInfoContents);
		GridBaseAdapter adapter = new GridBaseAdapter(mSearchPageView.getContext(), mContents);
		mHotSearchView.setAdapter(adapter);
		mHistoryView.setAdapter(adapter);
		return mSearchPageView;
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

	private View mSearchPageView;
	private GridView mHotSearchView, mHistoryView; 
	private String[] mContents;
}
