package com.example.upeuactionbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseMenuActivity extends Activity {

	private boolean esFavorito = false;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.base_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Configuraciones", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_share:
			String msg = getResources().getString(R.string.msg_compartir);
			Uri img_res = Uri.parse("android.resource://" + getPackageName()
					+ "/drawable/" + R.drawable.dn);
			Intent share = new Intent();
			share.setAction(Intent.ACTION_SEND);
			share.putExtra(Intent.EXTRA_TEXT, msg);
			share.putExtra(Intent.EXTRA_STREAM, img_res);
			share.setType("image/jpeg");

			startActivity(Intent.createChooser(share, "Compartir"));

			return true;
		case R.id.action_favorite:
			Drawable icon = null;
			if (esFavorito) {
				icon = getResources().getDrawable(
						R.drawable.ic_action_not_important);
			} else {
				icon = getResources().getDrawable(
						R.drawable.ic_action_important);
			}

			esFavorito = !esFavorito;

			item.setIcon(icon);

			return true;
		case R.id.action_activitySecond:
			Intent i = new Intent(getApplicationContext(), SecondActivity.class);
			startActivity(i);
			return true;

		default:
			Toast.makeText(this, "Otros", Toast.LENGTH_SHORT).show();
			return true;
		}

	}
}
