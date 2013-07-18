/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines;



/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The class representation of the antibiotic.
 *
 */
public class Antibiotic {
	
	/**
	 * Infection id, which corresponds with the id in SQLite table.
	 */
	private long _id;
	
	/**
	 * The name of an antibiotic.
	 */
	private String name;
	
	/**
	 * The PDF file link for an antibiotic.
	 */
	private String pdfLink;
	
	public Antibiotic() {
		// Empty.
	}
	
	// TODO. Getter and Setter methods.
}
