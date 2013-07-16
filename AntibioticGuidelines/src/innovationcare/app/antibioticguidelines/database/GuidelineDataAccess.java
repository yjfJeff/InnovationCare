/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines.database;

import innovationcare.app.antibioticguidelines.Infection;
import innovationcare.app.antibioticguidelines.InfectionCategory;

import java.util.ArrayList;

import android.content.Context;
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
	public ArrayList<InfectionCategory> readAllInfectionCategories() {
		final ArrayList<InfectionCategory> infectionCategoryList = 
				new ArrayList<InfectionCategory>();
		
		InfectionCategory infectionCat1 = new InfectionCategory(1, "infection category 1");
		infectionCategoryList.add(infectionCat1);
		
		InfectionCategory infectionCat2 = new InfectionCategory(2, "infection category 2");
		infectionCategoryList.add(infectionCat2);
		
		InfectionCategory infectionCat3 = new InfectionCategory(3, "infection category 3");
		infectionCategoryList.add(infectionCat3);
		
		return infectionCategoryList;
	}
	
	/**
	 * Reads a list of infections for a certain infection category from the
	 * database.
	 * 
	 * @return
	 */
	public ArrayList<Infection> readInfectionsByCategory(long categoryId) {
		ArrayList<Infection> infectionList = new ArrayList<Infection>();
		
		//TODO: Remove mock up data.
		Infection infection1 = new Infection(1, "infection 1", "presentation 1", "organism 1", "antibiotics list 1");
		infectionList.add(infection1);
		
		Infection infection2 = new Infection(2, "infection 2", "presentation 2", "organism 2", "antibiotics list 2");
		infectionList.add(infection2);
		
		Infection infection3 = new Infection(3, "infection 3", "presentation 3", "organism 3", "antibiotics list 3");
		infectionList.add(infection3);
		
		return infectionList;
	}
	
}
