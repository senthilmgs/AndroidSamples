package demo.mgs.com.slidingmenudemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ColorMenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);


		String[] colors = getResources().getStringArray(R.array.color_names);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		Bundle b =  new Bundle();
		switch (position) {
		case 0:
			newContent = new ColorFragment(android.R.color.holo_red_dark);
			b.putString("headerTitle","Red");
			break;
		case 1:
			newContent = new GreenFragment(android.R.color.holo_green_dark);

			b.putString("headerTitle","Green");
			break;
		case 2:
			newContent = new GreenFragment(android.R.color.darker_gray);
			b.putString("headerTitle","Gray");
			break;
		case 3:
			newContent = new ColorFragment(android.R.color.white);
			b.putString("headerTitle","White");
			break;
		case 4:
			newContent = new ColorFragment(android.R.color.black);
			b.putString("headerTitle","Black");
			break;
		}
		newContent.setArguments(b);
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		}

	}


}
