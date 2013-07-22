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
	
	
	//TODO: update the attributes according to the new database schema.
	
	
	/**
	 * Infection id, which corresponds with the id in SQLite table.
	 */
	private long _id;
	
	/**
	 * The name of an antibiotic.
	 */
	private String name;
	
	/**
	 * The link for an antibiotic.
	 */
	private String infoLink1;
	
	/**
	 * The link for an antibiotic.
	 */
	private String infoLink2;
	
	
	
	public Antibiotic(long id, String name, String link1, String link2) {
		this._id = id;
		this.name = name;
		this.infoLink1 = link1;
		this.infoLink2 = link2;
	}



	/**
	 * @return the _id
	 */
	public long getId() {
		return _id;
	}



	/**
	 * @param _id the _id to set
	 */
	public void setId(long _id) {
		this._id = _id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the infoLink1
	 */
	public String getInfoLink1() {
		return infoLink1;
	}



	/**
	 * @param infoLink1 the infoLink1 to set
	 */
	public void setInfoLink1(String infoLink1) {
		this.infoLink1 = infoLink1;
	}



	/**
	 * @return the infoLink2
	 */
	public String getInfoLink2() {
		return infoLink2;
	}



	/**
	 * @param infoLink2 the infoLink2 to set
	 */
	public void setInfoLink2(String infoLink2) {
		this.infoLink2 = infoLink2;
	}
	
	// TODO. Getter and Setter methods.
}
