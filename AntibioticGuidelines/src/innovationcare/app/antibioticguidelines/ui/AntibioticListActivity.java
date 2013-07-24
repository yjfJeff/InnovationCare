/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.Antibiotic;
import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/*
 * Modification History
 * --------------------
 * 17-Jul-2013  Meng  Initial version.
 * 
 */
/**
 * The activity class for the antibiotic list page.
 *
 */
public class AntibioticListActivity extends Activity {

	private final GuidelineDataAccess dao = new GuidelineDataAccess(this);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antibiotic_list);
        setTitle("Antimicrobial List");

        final ListView infectionCategoryListView = 
				(ListView) findViewById(R.id.AntibioticList);
		
		// Open the database.
		dao.open();
		
		final ArrayList<Antibiotic> AntibioticList = 
				dao.readAllAntibiotics();
		
		// Close the database;
		dao.close();
		
		final ArrayAdapter<Antibiotic> adapter = new ArrayAdapter<Antibiotic>(this, 
				android.R.layout.simple_list_item_1, 
				AntibioticList);
		
		infectionCategoryListView.setAdapter(adapter);
		
		// Click handler.
		infectionCategoryListView.setOnItemClickListener(
				new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, 
					int position, long id) {
				
				 final Antibiotic antibiotic = 
						 (Antibiotic) parent.getItemAtPosition(position);
				 
				 Intent intent = new Intent(parent.getContext(), 
						 DisplayAntibioticActivity.class);
				 intent.putExtra("id", String.valueOf(antibiotic.get_id()));
				 startActivity(intent);
			}
			
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
