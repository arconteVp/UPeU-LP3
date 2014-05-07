package com.example.testlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class NameDetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_detail);

		Intent i = getIntent();

		String name = i.getStringExtra(MainActivity.NAME_TAG);
		FragmentManager fm = getSupportFragmentManager();
		NameDetailFragment frag = (NameDetailFragment) fm
				.findFragmentById(R.id.detail_fragment);
		frag.setName(name);

	}

}
