/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.Infection;
import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.R.id;
import innovationcare.app.antibioticguidelines.R.layout;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The activity class for the infection list screen.
 *
 */
public class InfectionListActivity extends Activity {

	/**
	 * Data access object.
	 */
	private final GuidelineDataAccess dao = new GuidelineDataAccess(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_infection_list);
		
		Intent intent = getIntent();
		// TODO: change the default id.
		long categoryId = intent.getLongExtra("categoryId", 1);
		String categoryName = intent.getStringExtra("categoryName");
		
		// Set the screen title to the category name.
		setTitle(categoryName);
		
		final ListView infectionListView = 
				(ListView) findViewById(R.id.infectionList);
		
		// Open the database.
		dao.open();
		
		// Read all infections from a certain category.
		ArrayList<Infection> infectionList = 
				dao.readInfectionsByCategory(categoryId);
		dao.close();
		
		final ArrayAdapter<Infection> adapter = new ArrayAdapter<Infection>(
				this, android.R.layout.simple_list_item_1, 
				infectionList);
		
		infectionListView.setAdapter(adapter);
		
		//TODO: add the on click event to open the infection details page.
		
	}

}
