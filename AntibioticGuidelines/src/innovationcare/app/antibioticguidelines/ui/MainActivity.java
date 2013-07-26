/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.cloud.UpdateUtils;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

		Kumulos.initWithAPIKeyAndSecretKey("z1y3x0sjyvsqwykcmpq0fd05rhcxr7zx",
				"r5dsh8d8", this);
		
		// Store the update info in the shared preferences.
		SharedPreferences settings = getSharedPreferences(
				"AntibioticAppSettings", 0);
		boolean isUpdateRequired = settings.getBoolean("isUpdateRequired", true);
		if (isUpdateRequired) {

			GuidelineDataAccess dao = new GuidelineDataAccess(MainActivity.this);
			UpdateUtils.getAllDataFromCloud(dao);	
			
			dao.close();

			//Resetting to false.
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("isUpdateRequired", false);
			// Commit the edits!
			editor.commit();
		}
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
		GuidelineDataAccess dao = new GuidelineDataAccess(this);
		dao.upgrade();
		
        UpdateUtils.getAllDataFromCloud(dao);
		new AlertDialog.Builder(this).setTitle("Upgrade").setMessage("Upgrade Done!").setPositiveButton("OK",null).show();
	}

}
