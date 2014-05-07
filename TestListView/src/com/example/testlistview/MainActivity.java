package com.example.testlistview;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {

	private static final ArrayList<String> names = new ArrayList<String>();
	public static final String NAME_TAG = "name";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText input_name = (EditText) findViewById(R.id.txt_nombre);
		ListView list = (ListView) findViewById(R.id.lt_names);
		Button btn_submit = (Button) findViewById(R.id.btn_enviar);

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				names);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				String name = adapter.getItem(arg2);
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
					Intent action = new Intent(getApplicationContext(),
							NameDetailActivity.class);
					action.putExtra(NAME_TAG, name);
					startActivity(action);
				} else {
					FragmentManager fm = getSupportFragmentManager();
					NameDetailFragment frag = (NameDetailFragment) fm
							.findFragmentById(R.id.detail_fragment);
					frag.setName(name);
				}

			}
		});

		btn_submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = input_name.getText().toString();
				Log.e("TAG", "Nuevo item");
				if (!names.contains(name)) {
					names.add(name);
					adapter.notifyDataSetChanged();
				}

			}
		});
	}

}
