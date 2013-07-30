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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.kumulos.android.jsonclient.Kumulos;
import com.kumulos.android.jsonclient.ResponseHandler;

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
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		adb.setTitle("Upgrade")
				.setMessage("Upgrade Done!Current version is:" + curVersion)
				.setPositiveButton("OK", null).show();
		Log.e("3", "" + curVersion);
		super.onPostExecute(result);
	}

}
