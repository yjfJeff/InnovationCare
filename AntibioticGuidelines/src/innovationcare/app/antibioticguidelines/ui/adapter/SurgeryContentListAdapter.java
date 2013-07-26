/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.ui.adapter;

import innovationcare.app.antibioticguidelines.InfectionContent;
import innovationcare.app.antibioticguidelines.R;
import innovationcare.app.antibioticguidelines.SurgeryContent;

import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
 * Modification History
 * --------------------
 * 
 */
/**
 * @author I73933
 *
 */
public class SurgeryContentListAdapter<T> extends ArrayAdapter<T> {
	
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public SurgeryContentListAdapter(Context context, int textViewResourceId, List objects) {
		super(context, textViewResourceId, objects);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = inf.inflate(R.layout.surgery_content_list_row, null);
		}
		
		LinearLayout infectionContentListRow = 
				(LinearLayout) convertView.findViewById(R.id.surgeryContentListRow);
		
		if (position % 2 == 1) {
			infectionContentListRow.setBackgroundResource(R.drawable.menu_list_odd_selector);
		} else {
			infectionContentListRow.setBackgroundResource(R.drawable.menu_list_even_selector);
		}
		
		TextView operationDisplay = 
				(TextView) convertView.findViewById(R.id.operationDisplay);
		
		TextView antibioticDisplay = 
				(TextView) convertView.findViewById(R.id.antibioticDisplay);
		
		TextView durationDisplay = 
				(TextView) convertView.findViewById(R.id.durationDisplay);
		
		TextView commentsDisplay = 
				(TextView) convertView.findViewById(R.id.commentsDisplay);
		
		SurgeryContent surgeryContent = (SurgeryContent) getItem(position);
		
		operationDisplay.setText(surgeryContent.getOperation());
		antibioticDisplay.setText(surgeryContent.getAntibioticList());
		durationDisplay.setText(surgeryContent.getDuration());
		commentsDisplay.setText(surgeryContent.getComments());
		
		
		return convertView;
		
	}

}
