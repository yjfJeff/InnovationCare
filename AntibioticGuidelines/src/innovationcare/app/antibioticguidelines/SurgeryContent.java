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
 * 
 */
/**
 * @author I73933
 *
 */
public class SurgeryContent {
	
	private long _id;
	private String operation;
	private String antibioticList;
	private String duration;
	private String comments;
	private long menuId;
	
	/**
	 * Constructor.
	 */
	public SurgeryContent() {
		// Empty.
	}
	
	/**
	 * @param _id
	 * @param operation
	 * @param antibioticList
	 * @param duration
	 * @param comments
	 * @param menuId
	 */
	public SurgeryContent(long _id, String operation, String antibioticList,
			String duration, String comments, long menuId) {
		this._id = _id;
		this.operation = operation;
		this.antibioticList = antibioticList;
		this.duration = duration;
		this.comments = comments;
		this.menuId = menuId;
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
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * @return the antibioticList
	 */
	public String getAntibioticList() {
		return antibioticList;
	}
	/**
	 * @param antibioticList the antibioticList to set
	 */
	public void setAntibioticList(String antibioticList) {
		this.antibioticList = antibioticList;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	
}
