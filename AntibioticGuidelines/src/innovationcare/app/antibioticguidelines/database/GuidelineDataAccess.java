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
import innovationcare.app.antibioticguidelines.database.table.AntibioticTable;
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
	private Context context;

	public GuidelineDataAccess(Context context) {
		dbHelper = new GuidelineSQLiteHelper(context);
		this.context = context;
	}
	
	public void upgrade() {
		
		database = dbHelper.getWritableDatabase();
		int version = database.getVersion();
		dbHelper.close();
		dbHelper = new GuidelineSQLiteHelper(context, version+1);
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

	public ArrayList<InfectionContent> readInfectionContentsByMenu(long menuId) {
		final ArrayList<InfectionContent> infectionContentList = 
				new ArrayList<InfectionContent>();

		Cursor cursor = database.rawQuery("select * from " + InfectionContentTable.TABLE_NAME + " where " + InfectionContentTable.MENUID + " = ?", new String[] {Long.toString(menuId)});

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			InfectionContent infectionContent = new InfectionContent();
			infectionContent.setId(cursor.getLong(0));
			infectionContent.setPresentation(cursor.getString(1));
			infectionContent.setOrganism(cursor.getString(2));
			infectionContent.setAntibioticList(cursor.getString(3));
			infectionContent.setComments(cursor.getString(4));
			infectionContent.setMenuId(cursor.getLong(5));
			
			infectionContentList.add(infectionContent);

			cursor.moveToNext();
		}

		// Close the cursor
		cursor.close();

		return infectionContentList;
	}
	
	public ArrayList<SurgeryContent> readSurgeryContentByMenu(long menuId) {
		ArrayList<SurgeryContent> surgeryContentList = new ArrayList<SurgeryContent>();
		
		Cursor cursor = database.rawQuery("select * from " + SurgeryContentTable.TABLE_NAME + " where " + SurgeryContentTable.MENUID + " = ?", new String[] {Long.toString(menuId)});

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			SurgeryContent surgeryContent = new SurgeryContent();
			surgeryContent.setId(cursor.getLong(0));
			surgeryContent.setOperation(cursor.getString(1));
			surgeryContent.setAntibioticList(cursor.getString(2));
			surgeryContent.setDuration(cursor.getString(3));
			surgeryContent.setComments(cursor.getString(4));
			surgeryContent.setMenuId(cursor.getLong(5));
			
			surgeryContentList.add(surgeryContent);

			cursor.moveToNext();
		}

		// Close the cursor
		cursor.close();
		
		return surgeryContentList;
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
		
		values.put(InfectionContentTable.ID, infectionContent.getId());
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

		values.put(SurgeryContentTable.ID, surgeryContent.getId());
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
		
		values.put(AntibioticTable.ID, antibiotic.getId());
		//TODO change the attributes name.
		values.put(AntibioticTable.NAME, antibiotic.getName());
		values.put(AntibioticTable.INFO_LINK_ONE, antibiotic.getInfoLink1());
		values.put(AntibioticTable.INFO_LINK_ONE_TITLE, antibiotic.getInfoLink1Title());
		values.put(AntibioticTable.INFO_LINK_TWO, antibiotic.getInfoLink2());
		values.put(AntibioticTable.INFO_LINK_TWO_TITLE, antibiotic.getInfoLink2Title());

		long id = database.insert(AntibioticTable.TABLE_NAME, null, values);

		return id;
	}

	/**
	 * Reads a list of all antibiotics from the database.
	 * 
	 * @return A list of the <code>Antibiotic</code> objects.
	 */
	public ArrayList<Antibiotic> readAllAntibiotics() {
		final ArrayList<Antibiotic> AntibioticList = 
				new ArrayList<Antibiotic>();

		Cursor cursor = database.rawQuery("select " + AntibioticTable.ID + "," + AntibioticTable.NAME + " from " + AntibioticTable.TABLE_NAME, new String[] {});
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Antibiotic antibiotic = new Antibiotic();
			antibiotic.setId(cursor.getLong(0));
			antibiotic.setName(cursor.getString(1));

			AntibioticList.add(antibiotic);

			cursor.moveToNext();
		}

		// Close the cursor
		cursor.close();

		return AntibioticList;
	}

	/**
	 * Reads an antibiotic from the database.
	 * 
	 * @return An instance of the <code>Antibiotic</code> objects.
	 */
	public Antibiotic readAntibiotic(String id) {

		Cursor cursor = database.rawQuery("select " + AntibioticTable.ID + "," + AntibioticTable.NAME + "," + AntibioticTable.INFO_LINK_ONE + "," + AntibioticTable.INFO_LINK_ONE_TITLE + "," + AntibioticTable.INFO_LINK_TWO_TITLE + "," + AntibioticTable.INFO_LINK_TWO + " from " + 
				AntibioticTable.TABLE_NAME + " where " + AntibioticTable.ID + " = ?", new String[] {id});
		cursor.moveToFirst();

		Antibiotic antibiotic = new Antibiotic();
		antibiotic.setId(cursor.getLong(0));
		antibiotic.setName(cursor.getString(1));
		antibiotic.setInfoLink1(cursor.getString(2));
		antibiotic.setInfoLink1Title(cursor.getString(3));
		antibiotic.setInfoLink2Title(cursor.getString(4));
		antibiotic.setInfoLink2(cursor.getString(5));

		// Close the cursor
		cursor.close();

		return antibiotic;
	}
	
	public ArrayList<Menu> readMenusBySearch(String query) {
		String queryToken = "%" + query + "%";
		// TODO: locale
		queryToken = queryToken.toLowerCase();
		
		final ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		Cursor cursor = database.rawQuery("select * from " + MenuTable.TABLE_NAME + " where " + MenuTable.NAME + " like ?", new String[] {queryToken});

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
	
	public ArrayList<Antibiotic> readAntibioticBySearch(String query) {
		String queryToken = "%" + query + "%";
		// TODO: locale
		queryToken = queryToken.toLowerCase();
		
		final ArrayList<Antibiotic> AntibioticList = 
				new ArrayList<Antibiotic>();

		Cursor cursor = database.rawQuery("select " + AntibioticTable.ID + "," + AntibioticTable.NAME + " from " + AntibioticTable.TABLE_NAME + " where " + AntibioticTable.NAME + " like ?", new String[] {queryToken});
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Antibiotic antibiotic = new Antibiotic();
			antibiotic.setId(cursor.getLong(0));
			antibiotic.setName(cursor.getString(1));

			AntibioticList.add(antibiotic);

			cursor.moveToNext();
		}

		// Close the cursor
		cursor.close();

		return AntibioticList;
	}
}
