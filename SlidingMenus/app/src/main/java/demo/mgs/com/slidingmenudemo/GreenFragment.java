package demo.mgs.com.slidingmenudemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class GreenFragment extends Fragment {

    private int mColorRes = -1;
    private Activity mActivity;

    public GreenFragment() {
        this(R.color.white);
    }

    @SuppressLint("ValidFragment")
    public GreenFragment(int colorRes) {
        mColorRes = colorRes;
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null)
            mColorRes = savedInstanceState.getInt("mColorRes");
        int color = getResources().getColor(mColorRes);
        // construct the RelativeLayout
        RelativeLayout v = new RelativeLayout(getActivity());
        v.setBackgroundColor(color);

        mActivity.setTitle("Green Color");
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mColorRes", mColorRes);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity =activity;
    }
}
