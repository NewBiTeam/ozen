package org.ozen.core.util;

import java.io.Serializable;

public class ForPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private Page page;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
