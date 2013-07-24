/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.CategoryMenu;
import innovationcare.app.antibioticguidelines.R;
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

		Kumulos.initWithAPIKeyAndSecretKey("34nq1hbm7rzzjzdcn45mp74618hvfbp0",
				"6vynjkcq", this);

//		// Create the database and populate the data for only once.
//		GuidelineDataAccess dao = new GuidelineDataAccess(this);
//		dao.open();
//		dao.close();
		
		// Store the settings in the shared preference as (key, value).
		SharedPreferences settings = getSharedPreferences(
				"settings", 0);
		boolean isUpdateRequired = settings.getBoolean("isUpdateRequired", true);
		if (isUpdateRequired) {
			//					// Create the database and populate the data for only once.
			//					HashMap<String, String> param = new HashMap<String, String>();
			//					Kumulos.call("getAllCategoryMenus", param, new ResponseHandler() {
			//						@Override
			//						public void didCompleteWithResult(Object result) {
			//							ArrayList<Object> resultSet = (ArrayList<Object>) result;
			//							GuidelineDataAccess dao = new GuidelineDataAccess(MainActivity.this);
			//							dao.open();
			//							for (Object object : resultSet) {
			//								LinkedHashMap<String,Object> objectHashMap = (LinkedHashMap<String,Object>) object;
			//								String name = objectHashMap.get("name").toString();
			//								String id = objectHashMap.get("categoryMenuID").toString();
			//								CategoryMenu newCateMenu = 
			//										new CategoryMenu(Long.parseLong(id), name);
			//								dao.insertCategoryMenu(newCateMenu);
			//
			//							}
			//							dao.close();
			//						}
			//					});

			//					HashMap<String, String> param2 = new HashMap<String, String>();
			//					Kumulos.call("getAllMenus", param2, new ResponseHandler() {
			//						@Override
			//						public void didCompleteWithResult(Object result) {
			//							
			//							ArrayList<Object> resultSet = (ArrayList<Object>) result;
			//							GuidelineDataAccess dao = new GuidelineDataAccess(MainActivity.this);
			//							dao.open();
			//							for (Object object : resultSet) {
			//								LinkedHashMap<String,Object> objectDetails = (LinkedHashMap<String,Object>) object;
			//								String id = objectDetails.get("menuID").toString();
			//								String name = objectDetails.get("name").toString();
			//								String type = objectDetails.get("type").toString();
			//								String categoryMenuId = objectDetails.get("categoryId").toString();
			//								innovationcare.app.antibioticguidelines.Menu newMenu = 
			//										new innovationcare.app.antibioticguidelines.Menu(
			//												Long.parseLong(id), name, type, Long.parseLong(categoryMenuId));
			//								dao.insertMenu(newMenu);
			//							}
			//							dao.close();
			//						}
			//					});

			GuidelineDataAccess dao = new GuidelineDataAccess(MainActivity.this);
			dao.open();
			dao.insertCategoryMenu(new CategoryMenu(1, "Bone And Joint Infections"));
			dao.insertCategoryMenu(new CategoryMenu(2, "Cardiovascular Infections"));
			dao.insertCategoryMenu(new CategoryMenu(3, "Encephalitis And Meningitis"));
			dao.insertCategoryMenu(new CategoryMenu(4, "Gastroentestinal Infections"));
			dao.insertCategoryMenu(new CategoryMenu(5, "GU/Uniary Tract Infections GU/ Uniary"));


			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(1, "Osteomyelitis", "infection", 1));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(2, "Septic arthritis", "infection", 1));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(3, "Endocarditis", "infection", 2));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(4, "Septic arthritis", "infection", 2));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(5, "Bacterial Meningitis, acute	", "infection", 3));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(6, "Encephalitis", "infection", 3));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(7, "Viral Meningitis", "infection", 3));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(8, "Viral Meningitis", "infection", 4));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(9, "Gastroenteritis, Acute", "infection", 4));
			dao.insertMenu(new innovationcare.app.antibioticguidelines.Menu(10, "H. Pylori", "infection", 4));
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
//		GuidelineDataAccess dao = new GuidelineDataAccess(this, true);
//		dao.open();
//		dao.close();
		new AlertDialog.Builder(this).setTitle("Upgrade").setMessage("Upgrade Done!").setPositiveButton("OK",null).show();
	}

}
