/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.kumulos.android.jsonclient.Kumulos;

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

		Kumulos.initWithAPIKeyAndSecretKey("34nq1hbm7rzzjzdcn45mp74618hvfbp0",
				"6vynjkcq", this);

		// Create the database and populate the data for only once.
		GuidelineDataAccess dao = new GuidelineDataAccess(this);
		dao.open();
		dao.close();
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
	public void openContactUsScreen(View v) {
		Intent intent = new Intent(this, ContactUsActivity.class);
		startActivity(intent);
	}

	public void openInfectionCategoryScreen(View v) {
		Intent intent = new Intent(this, InfectionCategoryListActivity.class);
		startActivity(intent);
	}

	public void openInteractionScreen(View v) {
		Intent intent = new Intent(this, InteractionActivity.class);
		startActivity(intent);
	}

	public void openAntibioticListScreen(View v) {
		Intent intent = new Intent(this, AntibioticListActivity.class);
		startActivity(intent);
	}

	public void onUpgrade(View v) {
		GuidelineDataAccess dao = new GuidelineDataAccess(this, true);
		dao.open();
		dao.close();
		new AlertDialog.Builder(this).setTitle("Upgrade").setMessage("Upgrade Done!").setPositiveButton("OK",null).show();
	}

}
