/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.database;

import innovationcare.app.antibioticguidelines.InfectionContent;
import innovationcare.app.antibioticguidelines.CategoryMenu;
import innovationcare.app.antibioticguidelines.database.table.CategoryMenuTable;
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
	public ArrayList<InfectionContent> readInfectionsByCategory(long categoryId) {
		ArrayList<InfectionContent> infectionList = new ArrayList<InfectionContent>();
		
		//TODO: Remove mock up data.
		InfectionContent infection1 = new InfectionContent(1, "presentation 1", "organism 1", "antibiotics list 1");
		infectionList.add(infection1);
		
		InfectionContent infection2 = new InfectionContent(2, "presentation 2", "organism 2", "antibiotics list 2");
		infectionList.add(infection2);
		
		InfectionContent infection3 = new InfectionContent(3, "presentation 3", "organism 3", "antibiotics list 3");
		infectionList.add(infection3);
		
		return infectionList;
	}
	
	/**
	 * 
	 */
	public long insertCategoryMenu(CategoryMenu catMenu) {
		
		// Insert the expense to the Expense table
		ContentValues values = new ContentValues();
		values.put(CategoryMenuTable.NAME, catMenu.getName());
		long id = database.insert(CategoryMenuTable.TABLE_NAME, null, values);

		return id;
	}
	
}
