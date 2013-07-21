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
 * The class presentation of the Antibiotic table in the SQLite database.
 *
 */
public class AntibioticTable {
	/**
	 * Table name.
	 */
	public static final String TABLE_NAME = "Antibiotic";
	
	
	
	/**
	 * ID attribute. Primary key.
	 */
	public static final String ID = "_id";
	/**
	 * Name attribute.
	 */
	public static final String NAME="name";
	/**
	 * SummaryPDF attribute.
	 */
	public static final String SUMMARY_PDF= "summaryPDF";
	/**
	 * The renalPDF attribute.
	 */
	public static final String RENAL_PDF = "renalPDF";
	/**
	 * The infoLink1 attribute.
	 */
	public static final String INFO_LINK_ONE = "infoLink1";
	/**
	 * The infoLink2 attribute.
	 */
	public static final String INFO_LINK_TWO = "infoLink2";
	
	
	
	/**
	 * Create table SQL statement.
	 */
	public static final String CREATE_TABLE_STATEMENT = "create table "+ TABLE_NAME + "("
			+ ID + " integer primary key autoincrement, "
			+ NAME + " text unique not null, "
			+ SUMMARY_PDF + " blob, "
			+ RENAL_PDF + " blob, "
			+ INFO_LINK_ONE + " text, "
			+ INFO_LINK_TWO + " text);";
}
