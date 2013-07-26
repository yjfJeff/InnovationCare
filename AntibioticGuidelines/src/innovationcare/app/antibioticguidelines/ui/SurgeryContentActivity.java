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
import innovationcare.app.antibioticguidelines.SurgeryContent;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import innovationcare.app.antibioticguidelines.ui.adapter.InfectionContentListAdapter;
import innovationcare.app.antibioticguidelines.ui.adapter.SurgeryContentListAdapter;
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
public class SurgeryContentActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surgery_content);
		
		Intent intent = getIntent();
		String menuName = intent.getStringExtra("menuName");
		long menuId = intent.getLongExtra("menuId", 0);
		setTitle(menuName);
		
		// TODO
		final ListView surgeryContentListView = 
				(ListView) findViewById(R.id.surgeryContentList);
		GuidelineDataAccess dao = new GuidelineDataAccess(this);
		// Open the database.
		dao.open();
		
		ArrayList<SurgeryContent> surgeryContentList = 
				dao.readSurgeryContentByMenu(menuId);
		dao.close();
		
//		SurgeryContent newSurgeryContent1 = new SurgeryContent(
//				1, 
//				"operation mock up data", 
//				"antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"duration mock up data", 
//				"This a a comments for this particular surgery",
//				1);
//		SurgeryContent newSurgeryContent2 = new SurgeryContent(
//				2, 
//				"operation mock up data", 
//				"antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"duration mock up data", 
//				"This a a comments for this particular surgery",
//				2);
//		SurgeryContent newSurgeryContent3 = new SurgeryContent(
//				3, 
//				"operation mock up data", 
//				"antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"duration mock up data", 
//				"This a a comments for this particular surgery",
//				3);
//		SurgeryContent newSurgeryContent4 = new SurgeryContent(
//				4, 
//				"operation mock up data", 
//				"antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4", 
//				"duration mock up data", 
//				"This a a comments for this particular surgery",
//				4);
//		
//		
//		surgeryContentList.add(newSurgeryContent1);
//		surgeryContentList.add(newSurgeryContent2);
//		surgeryContentList.add(newSurgeryContent3);
//		surgeryContentList.add(newSurgeryContent4);
		
		final SurgeryContentListAdapter<SurgeryContent> adapter = 
				new SurgeryContentListAdapter<SurgeryContent>(
						this, R.layout.surgery_content_list_row, surgeryContentList);
		
		surgeryContentListView.setAdapter(adapter);
		
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
