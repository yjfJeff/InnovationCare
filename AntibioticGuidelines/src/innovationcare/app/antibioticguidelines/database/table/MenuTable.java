/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines.database.table;

/*
 * Modification History
 * --------------------
 * 20-Jul-2013  JY  Intial Version.
 */
/**
 * The class presentation of the Menu table in the SQLite database.
 *
 */
public class MenuTable {
	/**
	 * Table name.
	 */
	public static final String TABLE_NAME = "Menu";
	
	/**
	 * id attribute.
	 */
	public static final String ID = "_id";
	
	/**
	 * name attribute.
	 */
	public static final String NAME = "name";
	
	/**
	 * type attribute.
	 */
	public static final String TYPE = "type";
	
	/**
	 * categoryMenuId attribute.
	 */
	public static final String CATEGORYMENUID = "categorymenuid";
	
	
	/**
	 * Create table SQL statement.
	 */
	public static final String CREATE_TABLE_STATEMENT = "create table "+ TABLE_NAME + "("
			+ ID + " integer primary key, "
			+ NAME + " text not null, "
			+ TYPE + " text, "
			+ CATEGORYMENUID + " integer, "
			+ "foreign key(" + CATEGORYMENUID + ") REFERENCES " + CategoryMenuTable.TABLE_NAME + "(" + CategoryMenuTable.ID + "));";
	
}
