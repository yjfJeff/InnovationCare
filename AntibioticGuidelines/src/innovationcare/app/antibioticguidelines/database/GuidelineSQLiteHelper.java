/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.database;

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
	
	public GuidelineSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO: create database table here.
//		database.execSQL(ExpenseTable.CREATE_TABLE_STATEMENT);
//		database.execSQL(OneDayExpenseTable.CREATE_TABLE_STATEMENT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase datebase, int arg1, int arg2) {
		// Do nothing.
	}
	
}
