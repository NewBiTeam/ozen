package org.ozen.front.service.impl;

import org.ozen.front.dao.TbUserMapper;
import org.ozen.front.entity.TbUser;
import org.ozen.front.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired private TbUserMapper userDao;
	
	@Override
	public TbUser selectLogin(TbUser user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
