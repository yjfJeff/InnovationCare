/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 */
package innovationcare.app.antibioticguidelines;

import java.util.ArrayList;



/*
 * Modification History
 * --------------------
 * 15-Jul-2013  Jiefeng  Initial version.
 * 
 */
/**
 * The class representation of the infection.
 *
 */
public class InfectionContent {
	/**
	 * Infection id, which corresponds with the id in SQLite table.
	 */
	private long _id;
	
	/**
	 * Infection presentation.
	 */
	private String presentation;
	
	/**
	 * The likely organism of an infection.
	 */
	private String organism;
	
	/**
	 * The antibiotic therapy of an infection. TODO. might just be a simple String variable.
	 */
//	private ArrayList<Antibiotic> antibioticList = new ArrayList<Antibiotic>();
	private String antibioticList;
	
	/**
	 * comments.
	 */
	private String comments;
	
	/**
	 * the id of the menu.
	 */
	private long menuId;
	
	/**
	 * Constructor.
	 */
	public InfectionContent() {
		// Empty.
	}
	
	/**
	 * Constructor.
	 *
	 * @param _id Infection id.
	 * @param presentation The presentation of an infection.
	 * @param organism The organism of an infection.
	 * @param antibioticList The list of antibiotics that can be used for
	 *                       an infection.
	 */
	public InfectionContent(long _id, String presentation, 
			String organism, String antibioticList) {
		
		this._id = _id;
		this.presentation = presentation;
		this.organism = organism;
		this.antibioticList = antibioticList;
	}
		

}
