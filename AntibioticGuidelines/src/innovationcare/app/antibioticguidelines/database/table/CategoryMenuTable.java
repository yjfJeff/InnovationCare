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
 * The class presentation of the CategoryMenu table in the SQLite database.
 *
 */
public class CategoryMenuTable {
	
	/**
	 * Table name.
	 */
	public static final String TABLE_NAME = "CategoryMenu";
	
	/**
	 * id attribute.
	 */
	public static final String ID = "_id";
	
	/**
	 * name attribute.
	 */
	public static final String NAME = "name";
	
	/**
	 * Create table SQL statement.
	 */
	public static final String CREATE_TABLE_STATEMENT = "create table "+ TABLE_NAME + "("
			+ ID + " integer primary key, "
			+ NAME + " text not null);";
	
}
