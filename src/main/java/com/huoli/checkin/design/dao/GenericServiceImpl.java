package com.huoli.checkin.design.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GenericServiceImpl<Model, PK> extends JdbcDaoSupport implements GenericService<Model, PK> {

	@Override
	public int insert(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PK id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Model model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Model findById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

}
