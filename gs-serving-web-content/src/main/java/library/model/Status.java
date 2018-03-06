package library.model;

import java.io.Serializable;

public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8329636941284880606L;
	private boolean status;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
