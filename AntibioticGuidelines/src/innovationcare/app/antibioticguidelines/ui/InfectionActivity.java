/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.ui;

import innovationcare.app.antibioticguidelines.R;
import android.app.Activity;
import android.os.Bundle;
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
		
		TextView presentationDisplay = 
				(TextView) findViewById(R.id.presentationDisplay);
		
		TextView organismDisplay = 
				(TextView) findViewById(R.id.organismDisplay);
		
		TextView antibioticListDisplay = 
				(TextView) findViewById(R.id.antibioticListDisplay);
		
		presentationDisplay.setText("presentation mock up data");
		organismDisplay.setText("organism mock up data");
		antibioticListDisplay.setText("antimicrobial 1, antimicrobial 2, antimicrobial 3, antimicrobial 4");
	}
}
