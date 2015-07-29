package demo.mgs.com.slidingmenudemo;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class BaseActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected ListFragment mFrag;
	TextView headerText;

	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);


		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);


		android.support.v7.app.ActionBar mActionBar = getSupportActionBar();
		/*mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);*/
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);

		 headerText  =   (TextView)mCustomView.findViewById(R.id.app_title);

		ImageView homeImg  = (ImageView) mCustomView.findViewById(R.id.my_home);

		ImageView msgImg  = (ImageView) mCustomView.findViewById(R.id.msg_img);

		homeImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();
			}
		});

		msgImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),"Under development",Toast.LENGTH_SHORT).show();

			}
		});



		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	//	getSupportActionBar().setDisplayShowHomeEnabled(true);

		//getActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	public void setHeader(String header){
		headerText.setText(header);
	}
}
