/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.ui;

import java.util.ArrayList;
import java.util.Collection;

import innovationcare.app.antibioticguidelines.Antibiotic;
import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import innovationcare.app.antibioticguidelines.ui.adapter.MenuListAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/*
 * Modification History
 * --------------------
 * 
 */
/**
 *
 */
public class SearchableActivity extends  Activity {
	
	private ListView searchResultListView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_searchable);
	    
	    setTitle("Search Results");
	    
	    searchResultListView = 
	    		(ListView) findViewById(R.id.searchResultList);
	    
	    handleIntent(getIntent());
	}

	@Override
	protected void onNewIntent(Intent intent) {
	    setIntent(intent);
	    handleIntent(intent);
	}

	private void handleIntent(Intent intent) {
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	      String query = intent.getStringExtra(SearchManager.QUERY);
	      doMySearch(query);
	    }
	}
	
	public void doMySearch(String query) {
		GuidelineDataAccess dao = new GuidelineDataAccess(this);
		
		dao.open();
		ArrayList<innovationcare.app.antibioticguidelines.Menu> menuList = 
				dao.readMenusBySearch(query);
		ArrayList<Antibiotic> antibioticList = 
				dao.readAntibioticBySearch(query);
		dao.close();
		
		ArrayList<Object> jointList = new ArrayList<Object>();
		jointList.addAll(menuList);
		jointList.addAll(antibioticList);
		
		final MenuListAdapter<innovationcare.app.antibioticguidelines.Menu> adapter = 
				new MenuListAdapter<innovationcare.app.antibioticguidelines.Menu>(
						this, R.layout.list_item_row, jointList);
		
		searchResultListView.setAdapter(adapter);
		
		searchResultListView.setOnItemClickListener(
				new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, 
					int position, long id) {
				Object item = parent.getItemAtPosition(position);
				if (item instanceof innovationcare.app.antibioticguidelines.Menu) {
					final innovationcare.app.antibioticguidelines.Menu menu = 
							 (innovationcare.app.antibioticguidelines.Menu) item;
					 
					 /**
					  * Check the type to determine to open the infection content list,
					  * or surgery content list.
					  */
					 String type = menu.getType();
					 
					 if ("infection".equalsIgnoreCase(type)) {
						 Intent intent = new Intent(parent.getContext(), 
								 InfectionActivity.class);
						 intent.putExtra("menuId", menu.getId());
						 intent.putExtra("menuName", menu.getName());
						 startActivity(intent);
					 } else if ("surgery".equalsIgnoreCase(type)) {
						 Intent intent = new Intent(parent.getContext(), 
								 SurgeryContentActivity.class);
						 intent.putExtra("menuId", menu.getId());
						 intent.putExtra("menuName", menu.getName());
						 startActivity(intent);
					 } else {
						 // Do nothing. The type not supported. Couldn't open.
					 }
				} else if (item instanceof Antibiotic) {
					final Antibiotic antibiotic = 
							 (Antibiotic) item;
					 
					 Intent intent = new Intent(parent.getContext(), 
							 DisplayAntibioticActivity.class);
					 intent.putExtra("id", String.valueOf(antibiotic.getId()));
					 startActivity(intent);
				} else {
					// Do nothing.
				}
			}
					
		});
		
	}
}
