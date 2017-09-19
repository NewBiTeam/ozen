package org.ozen.front.service;

import org.ozen.front.entity.TbUser;

public interface LoginService {

	TbUser selectLogin(TbUser user);
	
	void add(TbUser user);
}
