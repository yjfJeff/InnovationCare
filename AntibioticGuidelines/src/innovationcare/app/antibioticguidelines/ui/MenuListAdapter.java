/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.ui;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

/*
 * Modification History
 * --------------------
 * 
 */
/**
 * @author I73933
 *
 */
public class MenuListAdapter<T> extends ArrayAdapter {

	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public MenuListAdapter(Context context, int textViewResourceId, List objects) {
		super(context, textViewResourceId, objects);
	}

}
