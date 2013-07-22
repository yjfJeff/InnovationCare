/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.database;

import innovationcare.app.antibioticguidelines.Antibiotic;
import innovationcare.app.antibioticguidelines.InfectionContent;
import innovationcare.app.antibioticguidelines.CategoryMenu;
import innovationcare.app.antibioticguidelines.Menu;
import innovationcare.app.antibioticguidelines.SurgeryContent;
import innovationcare.app.antibioticguidelines.database.table.CategoryMenuTable;
import innovationcare.app.antibioticguidelines.database.table.InfectionContentTable;
import innovationcare.app.antibioticguidelines.database.table.MenuTable;
import innovationcare.app.antibioticguidelines.database.table.SurgeryContentTable;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The data access object to interact with the SQLite database in the Android
 * phone.
 *
 */
public class GuidelineDataAccess {
	
	private GuidelineSQLiteHelper dbHelper;
	private SQLiteDatabase database;

	public GuidelineDataAccess(Context context) {
		dbHelper = new GuidelineSQLiteHelper(context);
	}

	public void open() {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public SQLiteDatabase getWritableDatabase() {
		return database;
	}
	
	/**
	 * Reads a list of all infection categories from the database.
	 * 
	 * @return A list of the <code>InfectionCategory</code> objects.
	 */
	public ArrayList<CategoryMenu> readAllCategoryMenus() {
		final ArrayList<CategoryMenu> catMenuList = 
				new ArrayList<CategoryMenu>();
		
		Cursor cursor = database.rawQuery("select * from " + CategoryMenuTable.TABLE_NAME, new String[] {});
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			CategoryMenu catMenu = new CategoryMenu();
			catMenu.setId(cursor.getLong(0));
			catMenu.setName(cursor.getString(1));

			catMenuList.add(catMenu);

			cursor.moveToNext();
		}
		
		// Close the cursor
		cursor.close();
		
		return catMenuList;
	}
	
	/**
	 * Reads a list of infections for a certain infection category from the
	 * database.
	 * 
	 * @return
	 */
	public ArrayList<Menu> readMenusByCategory(long categoryMenuId) {
		final ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		Cursor cursor = database.rawQuery("select * from " + MenuTable.TABLE_NAME + " where " + MenuTable.CATEGORYMENUID + " = ?", new String[] {Long.toString(categoryMenuId)});
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Menu menu = new Menu();
			menu.setId(cursor.getLong(0));
			menu.setName(cursor.getString(1));
			menu.setType(cursor.getString(2));
			menu.setCategoryMenuId(cursor.getLong(3));
			
			menuList.add(menu);

			cursor.moveToNext();
		}
		
		// Close the cursor
		cursor.close();
		
		return menuList;
	}
	
	/**
	 * 
	 */
	public long insertCategoryMenu(CategoryMenu catMenu) {
		
		ContentValues values = new ContentValues();
		values.put(CategoryMenuTable.ID, catMenu.getId());
		values.put(CategoryMenuTable.NAME, catMenu.getName());
		long id = database.insert(CategoryMenuTable.TABLE_NAME, null, values);

		return id;
	}
	
	public long insertMenu(Menu menu) {
		ContentValues values = new ContentValues();
		values.put(MenuTable.ID, menu.getId());
		values.put(MenuTable.NAME, menu.getName());
		values.put(MenuTable.TYPE, menu.getType());
		values.put(MenuTable.CATEGORYMENUID, menu.getCategoryMenuId());
		
		long _id = database.insert(MenuTable.TABLE_NAME, null, values);
		
		return _id;
	}
	
	public long insertInfectionContent(InfectionContent infectionContent) {
		ContentValues values = new ContentValues();
		
		values.put(InfectionContentTable.PRESENTATION, infectionContent.getPresentation());
		values.put(InfectionContentTable.ORGANISM, infectionContent.getOrganism());
		values.put(InfectionContentTable.ANTIBIOTIC, infectionContent.getAntibioticList());
		values.put(InfectionContentTable.COMMENTS, infectionContent.getComments());
		values.put(InfectionContentTable.MENUID, infectionContent.getMenuId());
		
		long _id = database.insert(InfectionContentTable.TABLE_NAME, null, values);
		
		return _id;
	}
	
	public long insertSurgeryContent(SurgeryContent surgeryContent) {
		ContentValues values = new ContentValues();
		
		values.put(SurgeryContentTable.OPERATION, surgeryContent.getOperation());
		values.put(SurgeryContentTable.ANTIBIOTIC, surgeryContent.getAntibioticList());
		values.put(SurgeryContentTable.DURATION, surgeryContent.getDuration());
		values.put(SurgeryContentTable.COMMENTS, surgeryContent.getComments());
		values.put(SurgeryContentTable.MENUID, surgeryContent.getMenuId());
		
		long _id = database.insert(SurgeryContentTable.TABLE_NAME, null, values);
		
		return _id;
	}
	
	/**
	 * Insert an Antibiotic object into the database
	 */
	public long insertAntibiotic(Antibiotic antibiotic) {
		
		ContentValues values = new ContentValues();
		values.put(CategoryMenuTable.NAME, antibiotic.getName());
		
		long id = database.insert(CategoryMenuTable.TABLE_NAME, null, values);

		return id;
	}
	
}
