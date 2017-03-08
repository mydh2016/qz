package com.qazit.sysmanager.web.security;

import com.qazit.sysmanager.web.model.User;


public class CurrentUser {
	
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
