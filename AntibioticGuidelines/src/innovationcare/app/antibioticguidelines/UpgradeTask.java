/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines;

import innovationcare.app.antibioticguidelines.cloud.UpdateUtils;
import innovationcare.app.antibioticguidelines.database.GuidelineDataAccess;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/*
 * Modification History
 * --------------------
 * 
 */
/**
 * @author Administrator
 * 
 */
public class UpgradeTask extends AsyncTask<Integer, Integer, String> {

	private GuidelineDataAccess dao;
	private AlertDialog.Builder adb;

	public UpgradeTask(Context context) {
		super();
		dao = new GuidelineDataAccess(context);
		adb = new AlertDialog.Builder(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected String doInBackground(Integer... arg0) {
		// TODO Auto-generated method stub
		Log.e("wow", "amazing");
		dao.upgrade();
		UpdateUtils.getAllDataFromCloud(dao);
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		adb.setTitle("Upgrade").setMessage("Upgrade Done!")
				.setPositiveButton("OK", null).show();
	}

}
