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
import android.content.ContentValues;
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

	public static final String DATABASE_NAME = "AntibioticApp.db";

	public static final int DATABASE_VERSION = 1;

	private Context context;

	public GuidelineSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	public GuidelineSQLiteHelper(Context context, int newDatabaseVersion) {
		super(context, DATABASE_NAME, null, newDatabaseVersion);
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

//		GuidelineDataAccess dao = new GuidelineDataAccess(context);
//		UpdateUtils.getAllDataFromCloud(dao);

//		ContentValues values = new ContentValues();
//		values.put(AntibioticTable.ID, 1);
//		values.put(AntibioticTable.NAME, "test");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//
//		values.put(AntibioticTable.ID, 2);
//		values.put(AntibioticTable.NAME, "test2");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 3);
//		values.put(AntibioticTable.NAME, "test3");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 4);
//		values.put(AntibioticTable.NAME, "test4");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 5);
//		values.put(AntibioticTable.NAME, "test5");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 6);
//		values.put(AntibioticTable.NAME, "test6");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 7);
//		values.put(AntibioticTable.NAME, "test7");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 8);
//		values.put(AntibioticTable.NAME, "test8");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
//		
//		values.put(AntibioticTable.ID, 9);
//		values.put(AntibioticTable.NAME, "test9");
//		values.put(AntibioticTable.INFO_LINK_ONE, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_TWO, "www.google.ie");
//		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, "google");
//		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, "ie");
//		database.insert(AntibioticTable.TABLE_NAME, null, values);
		
	}

	@Override
	public void onDowngrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		// DO NOTHING!
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		
		database.execSQL(CategoryMenuTable.DROP_TABLE_STATEMENT);
		database.execSQL(AntibioticTable.DROP_TABLE_STATEMENT);
		database.execSQL(MenuTable.DROP_TABLE_STATEMENT);
		database.execSQL(InfectionContentTable.DROP_TABLE_STATEMENT);
		database.execSQL(SurgeryContentTable.DROP_TABLE_STATEMENT);
		this.onCreate(database);
	}

}