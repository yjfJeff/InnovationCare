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
	 * The link title for an antibiotic.
	 */
	private String infoLink1Title;
	
	/**
	 * The link for an antibiotic.
	 */
	private String infoLink2;
	
	/**
	 * The link title for an antibiotic.
	 */
	private String infoLink2Title;



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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		
		return builder.toString();
	}



	/**
	 * @return the infoLink1Title
	 */
	public String getInfoLink1Title() {
		return infoLink1Title;
	}



	/**
	 * @param infoLink1Title the infoLink1Title to set
	 */
	public void setInfoLink1Title(String infoLink1Title) {
		this.infoLink1Title = infoLink1Title;
	}



	/**
	 * @return the infoLink2Title
	 */
	public String getInfoLink2Title() {
		return infoLink2Title;
	}



	/**
	 * @param infoLink2Title the infoLink2Title to set
	 */
	public void setInfoLink2Title(String infoLink2Title) {
		this.infoLink2Title = infoLink2Title;
	}
}
