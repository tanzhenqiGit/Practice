package aiqi.imitation;

import com.example.proctice.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ClassifyPageView extends Fragment{

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mClassifyView = inflater.inflate(R.layout.aiqi_classify, null);
		return mClassifyView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mClassifyView = null;
	}

	private View mClassifyView;
}
