/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.ui.adapter;

import innovationcare.app.antibioticguidelines.R;

import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
public class MenuListAdapter<T> extends ArrayAdapter<T> {
	
	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public MenuListAdapter(Context context, int textViewResourceId, List objects) {
		super(context, textViewResourceId, objects);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			LayoutInflater inf = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = inf.inflate(R.layout.list_item_row, null);
		}
		
		RelativeLayout listItemRow = 
				(RelativeLayout) convertView.findViewById(R.id.listItemRow);
		
		if (position % 2 == 1) {
			listItemRow.setBackgroundResource(R.drawable.menu_list_odd_selector);
		} else {
			listItemRow.setBackgroundResource(R.drawable.menu_list_even_selector);
		}
		
		TextView menuListContentView = 
				(TextView) convertView.findViewById(R.id.menuListContentView);
		
		menuListContentView.setText(getItem(position).toString());
		
		return convertView;
		
	}

}
