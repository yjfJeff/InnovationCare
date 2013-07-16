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
 * The class representation of the infection category.
 *
 */
public class InfectionCategory {
	/**
	 * The id of an infection category.
	 */
	private long _id;
	
	/**
	 * The name of an infection category.
	 */
	private String name;
	
	
	/**
	 * Constructor.
	 */
	public InfectionCategory() {
		// Empty.
	}
	
	/**
	 * Constructor.
	 * 
	 * @param _id The id of the infection category.
	 * @param name The name of the infection category.
	 */
	public InfectionCategory(long _id, String name) {
		this._id = _id;
		this.name = name;
	}
	
	/**
	 * Sets the id of an infection category.
	 * 
	 * @param _id The id of an infection category.
	 */
	public void setId(long _id) {
		this._id = _id;
	}
	
	/**
	 * Sets the name of an infection category.
	 * 
	 * @param name The name of an infection category.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the id of an infection category.
	 * 
	 * @return The id of an infection category.
	 */
	public long getId() {
		return _id;
	}
	
	/**
	 * Gets the name of an infection category.
	 * 
	 * @return The name of an infection category.
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		
		return builder.toString();
	}
	
}