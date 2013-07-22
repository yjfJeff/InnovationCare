/*
 * Innovation Care Team confidential
 * 
 * Source Materials
 * 
 * Copyright Innovation Care 2013, all rights reserved.
 *
 */
package innovationcare.app.antibioticguidelines;

/*
 * Modification History
 * --------------------
 * 20-Jul-2013
 */
/**
 * The class representation of a menu.
 *
 */
public class Menu {
	
	private long _id;
	
	/**
	 * The name of the menu.
	 */
	private String name;
	
	/**
	 * The content type that the menu stores.
	 */
	private String type;
	
	/**
	 * The id of the category menu.
	 */
	private long categoryMenuId;
	
	public Menu() {
		// Empty.
	}
	
	public Menu(long _id, String name, String type, long categoryId) {
		this._id = _id;
		this.name = name;
		this.type = type;
		this.categoryMenuId = categoryId;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the categoryId
	 */
	public long getCategoryMenuId() {
		return categoryMenuId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryMenuId(long categoryId) {
		this.categoryMenuId = categoryId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		
		return builder.toString();
	}
	
}
