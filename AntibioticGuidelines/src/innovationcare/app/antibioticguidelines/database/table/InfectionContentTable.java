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
 * 
 */
/**
 * @author I73933
 *
 */
public class InfectionContentTable {
	/**
	 * Table name.
	 */
	public static final String TABLE_NAME = "InfectionContent";
	
	/**
	 * id attribute.
	 */
	public static final String ID = "_id";
	
	/**
	 * name attribute.
	 */
	public static final String PRESENTATION = "presentation";
	
	/**
	 * type attribute.
	 */
	public static final String ORGANISM = "organism";

	/**
	 * type attribute.
	 */
	public static final String ANTIBIOTIC = "antibiotic";

	/**
	 * type attribute.
	 */
	public static final String COMMENTS = "comments";
	
	/**
	 * categoryMenuId attribute.
	 */
	public static final String MENUID = "menuid";
	
	/**
	 * Drop table SQL statement.
	 */
	public static final String DROP_TABLE_STATEMENT = "drop table "
			+ TABLE_NAME + ";";
	/**
	 * Create table SQL statement.
	 */
	public static final String CREATE_TABLE_STATEMENT = "create table "+ TABLE_NAME + "("
			+ ID + " integer primary key, "
			+ PRESENTATION + " text, "
			+ ORGANISM + " text, "
			+ ANTIBIOTIC + "text, "
			+ COMMENTS + "text, "
			+ MENUID + " integer, "
			+ "foreign key(" + MENUID + ") REFERENCES " + MenuTable.TABLE_NAME + "(" + MenuTable.ID + "));";
	
}
