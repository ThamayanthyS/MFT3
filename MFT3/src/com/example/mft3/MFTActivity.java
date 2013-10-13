package com.example.mft3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MFTActivity extends Activity implements OnTabChangeListener {

	TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mft);

		/* TabHost will have Tabs */
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
		
		System.out.println("T111111111");

		/*
		 * TabSpec used to create a new tab. By using TabSpec only we can able
		 * to setContent to the tab. By using TabSpec setIndicator() we can set
		 * name to tab.
		 */

		/* tid1 is firstTabSpec Id. Its used to access outside. */
		TabSpec firstTabSpec = tabHost.newTabSpec("MAP");
		TabSpec secondTabSpec = tabHost.newTabSpec("CONTACT");
		TabSpec thirdTabSpec = tabHost.newTabSpec("SETTINGS");
		
		System.out.println("T2222222");

		/* TabSpec setIndicator() is used to set name for the tab. */
		/* TabSpec setContent() is used to set content for a particular tab. */
		firstTabSpec.setIndicator("MAP",
				getResources().getDrawable(R.drawable.maplogo));
		secondTabSpec.setIndicator("CONTACT",
				getResources().getDrawable(R.drawable.contactlogo));
		thirdTabSpec.setIndicator("SETTINGS",
				getResources().getDrawable(R.drawable.settingslogo));
		
		System.out.println("T333333");

		firstTabSpec.setContent(new Intent(this, MapView.class));
		secondTabSpec.setContent(new Intent(this, ContactTab.class));
		thirdTabSpec.setContent(new Intent(this, SettingsTab.class));
		
		
		
		System.out.println("T444444444");
		System.out.print(firstTabSpec.toString()+"FFFFFFF");

		/* Add tabSpec to the TabHost to display. */
		tabHost.addTab(firstTabSpec);
		tabHost.addTab(secondTabSpec);
		tabHost.addTab(secondTabSpec);
		
		
		System.out.println("T55555555");

		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i)
					.setBackgroundColor(Color.parseColor("#7392B5"));
		}

		tabHost.getTabWidget().setCurrentTab(1);
		tabHost.getTabWidget().getChildAt(1)
				.setBackgroundColor(Color.parseColor("#4E4E9C"));
		System.out.println("T66666666");

	}
	

	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i)
					.setBackgroundColor(Color.parseColor("#7392B5"));
		}

		tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
				.setBackgroundColor(Color.parseColor("#4E4E9C"));
		System.out.println("T77777777777");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mft, menu);
		System.out.println("T888888888");
		return true;
		
	}
	

}
