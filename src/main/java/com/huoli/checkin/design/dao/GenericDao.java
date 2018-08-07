package com.huoli.checkin.design.dao;

public interface GenericDao<Model, PK> {

	int insert(Model model);

	int deleteByPrimaryKey(PK id);

	int updateByModel(Model model);

	Model findByPrimaryKey(PK id);

}
