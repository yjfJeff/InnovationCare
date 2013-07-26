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
import innovationcare.app.antibioticguidelines.ui.adapter.InfectionContentListAdapter;
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
		long menuId = intent.getLongExtra("menuId", 0);
		setTitle(menuName);
		
		// TODO
		final ListView infectionContentListView = 
				(ListView) findViewById(R.id.infectionContentList);

		GuidelineDataAccess dao = new GuidelineDataAccess(this);
		// Open the database.
		dao.open();
		
		ArrayList<InfectionContent> infectionContentList = 
				dao.readInfectionContentsByMenu(menuId);
		dao.close();
		
//		InfectionContent newInfectionContent1 = new InfectionContent(
//				1, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				1);
//		InfectionContent newInfectionContent2 = new InfectionContent(
//				2, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				2);
//		
//		InfectionContent newInfectionContent3 = new InfectionContent(
//				3, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				3);
//		InfectionContent newInfectionContent4 = new InfectionContent(
//				4, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				4);
//		InfectionContent newInfectionContent5 = new InfectionContent(
//				5, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				5);
//		InfectionContent newInfectionContent6 = new InfectionContent(
//				6, 
//				"presentation mock up data", 
//				"organism mock up data", "antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"This a a comments for this particular infection",
//				6);
//		infectionContentList.add(newInfectionContent1);
//		infectionContentList.add(newInfectionContent2);
//		infectionContentList.add(newInfectionContent3);
//		infectionContentList.add(newInfectionContent4);
//		infectionContentList.add(newInfectionContent5);
//		infectionContentList.add(newInfectionContent6);
		
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
