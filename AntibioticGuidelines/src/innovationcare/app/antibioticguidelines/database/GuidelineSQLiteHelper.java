/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.database;

import innovationcare.app.antibioticguidelines.cloud.UpdateUtils;
import innovationcare.app.antibioticguidelines.database.table.AntibioticTable;
import innovationcare.app.antibioticguidelines.database.table.CategoryMenuTable;
import innovationcare.app.antibioticguidelines.database.table.InfectionContentTable;
import innovationcare.app.antibioticguidelines.database.table.MenuTable;
import innovationcare.app.antibioticguidelines.database.table.SurgeryContentTable;
import innovationcare.app.antibioticguidelines.ui.MainActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * A class to customize the SQLiteOpenHelper and handle the database connection.
 * 
 */
public class GuidelineSQLiteHelper extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME="AntibioticApp.db";
	
	public static final int DATABASE_VERSION = 1;
	
	private Context context;
	
	public GuidelineSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO: create database table here.
		database.execSQL(CategoryMenuTable.CREATE_TABLE_STATEMENT);
		database.execSQL(AntibioticTable.CREATE_TABLE_STATEMENT);
		database.execSQL(MenuTable.CREATE_TABLE_STATEMENT);
		database.execSQL(InfectionContentTable.CREATE_TABLE_STATEMENT);
		database.execSQL(SurgeryContentTable.CREATE_TABLE_STATEMENT);
		
		GuidelineDataAccess dao = new GuidelineDataAccess(context);
		UpdateUtils.getAllDataFromCloud(dao);
	}

	@Override
	public void onUpgrade(SQLiteDatabase datebase,  int oldVersion, int newVersion) {
		// Do nothing.
	}
	
}
