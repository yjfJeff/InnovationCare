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
<<<<<<< HEAD
=======

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

<<<<<<< HEAD
=======
import com.kumulos.android.jsonclient.Kumulos;
import com.kumulos.android.jsonclient.ResponseHandler;

>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
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
<<<<<<< HEAD

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
=======
	private int curVersion;

	public UpgradeTask(Context context, int version) {
		super();
		dao = new GuidelineDataAccess(context);
		adb = new AlertDialog.Builder(context);
		curVersion = version;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Log.e("1", "" + curVersion);
	}

	@Override
	protected String doInBackground(Integer... arg0) {
		// TODO Auto-generated method stub
		try {

			dao.upgrade(curVersion);
			UpdateUtils.getAllDataFromCloud(dao);

		} catch (Exception e) {
		}
		dao.close();
		Log.e("2", "" + curVersion);
>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
<<<<<<< HEAD
		adb.setTitle("Upgrade").setMessage("Upgrade Done!")
				.setPositiveButton("OK", null).show();
=======
		adb.setTitle("Upgrade")
				.setMessage("Upgrade Done!Current version is:" + curVersion)
				.setPositiveButton("OK", null).show();
		Log.e("3", "" + curVersion);
		super.onPostExecute(result);
>>>>>>> bac665e2a53258f4685a4814cf9b48a49db1fac1
	}

}
