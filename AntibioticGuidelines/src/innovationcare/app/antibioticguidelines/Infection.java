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
public class Infection {
	/**
	 * Infection id, which corresponds with the id in SQLite table.
	 */
	private long _id;
	
	/**
	 * Infection name.
	 */
	private String name;
	
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
	 * Constructor.
	 */
	public Infection() {
		// Empty.
	}
	
	/**
	 * Constructor.
	 * 
	 * 
	 * @param _id Infection id.
	 * @param name Infection name.
	 * @param presentation The presentation of an infection.
	 * @param organism The organism of an infection.
	 * @param antibioticList The list of antibiotics that can be used for
	 *                       an infection.
	 */
	public Infection(long _id, String name, String presentation, 
			String organism, String antibioticList) {
		
		this._id = _id;
		this.name = name;
		this.presentation = presentation;
		this.organism = organism;
		this.antibioticList = antibioticList;
	}
	
	// TODO: Getter and Setter methods.
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		
		return builder.toString();
	}
}
