/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.R.layout;
import innovationcare.app.antibioticguidelines.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The activity class for the home screen.
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * The on-click method for the "Contact Us" button to open the Contact Us
	 * screen.
	 * 
	 */
	public void openContactUsScreen (View v) {
		Intent intent = new Intent(this, ContactUsActivity.class);
		startActivity(intent);
	}
	
	public void openInfectionCategoryScreen(View v) {
		Intent intent = new Intent(this, InfectionCategoryListActivity.class);
		startActivity(intent);
	}
}
