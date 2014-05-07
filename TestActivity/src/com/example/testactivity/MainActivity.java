package com.example.testactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "Aplicacion";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e(TAG, "Estoy en create");

		Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(new MiListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void finish() {
		super.finish();
		Log.e(TAG, "Estoy en Finish");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "Estoy en Destroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG, "Estoy en Pause");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e(TAG, "Estoy en Restart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG, "Estoy en Resume");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e(TAG, "Estoy en Start");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG, "Estoy en Stop");
	}

	class MiListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Toast.makeText(getApplicationContext(), "Me hicieron click :)",
					Toast.LENGTH_SHORT).show();
			Log.e(TAG, "Me hicieron click");

		}

	}
}