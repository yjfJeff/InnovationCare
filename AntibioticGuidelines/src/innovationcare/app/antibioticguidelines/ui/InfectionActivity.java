/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import java.util.ArrayList;

import innovationcare.app.antibioticguidelines.InfectionContent;
import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/*
 * Modification History
 * --------------------
 * 18-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The activity class for the contact us screen.
 *
 */
public class InfectionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_infection);
		
		Intent intent = getIntent();
		String menuName = intent.getStringExtra("menuName");
		setTitle(menuName);
		
		// TODO
		final ListView infectionContentListView = 
				(ListView) findViewById(R.id.infectionContentList);
//		GuidelineDataAccess dao = new GuidelineDataAccess(this);
//		// Open the database.
//		dao.open();
//		
//		// Read all menus from a certain category.
//		ArrayList<innovationcare.app.antibioticguidelines.Menu> menuList = 
//				dao.readMenusByCategory(categoryMenuId);
//		dao.close();
		ArrayList<InfectionContent> infectionContentList = new ArrayList<InfectionContent>();
		
		InfectionContent newInfectionContent1 = new InfectionContent(
				1, 
				"presentation mock up data", 
				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
				1);
		InfectionContent newInfectionContent2 = new InfectionContent(
				2, 
				"presentation mock up data", 
				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
				2);
		
		InfectionContent newInfectionContent3 = new InfectionContent(
				3, 
				"presentation mock up data", 
				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
				3);
		infectionContentList.add(newInfectionContent1);
		infectionContentList.add(newInfectionContent2);
		infectionContentList.add(newInfectionContent3);
		
		final InfectionContentListAdapter<InfectionContent> adapter = 
				new InfectionContentListAdapter<InfectionContent>(
						this, R.layout.infection_content_list_row, infectionContentList);
		
		infectionContentListView.setAdapter(adapter);
		
//		// Click handler.
//		infectionContentListView.setOnItemClickListener(
//				new AdapterView.OnItemClickListener(){
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, 
//					int position, long id) {
//						
//				 final innovationcare.app.antibioticguidelines.Menu menu = 
//						 (innovationcare.app.antibioticguidelines.Menu) parent.getItemAtPosition(position);
//						 
//				 Intent intent = new Intent(parent.getContext(), 
//						 InfectionActivity.class);
//				 intent.putExtra("menuId", menu.getId());
//				 intent.putExtra("menuName", menu.getName());
//				 startActivity(intent);
//			}
//					
//		});
	}
}
