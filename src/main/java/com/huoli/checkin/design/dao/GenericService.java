package com.huoli.checkin.design.dao;

public interface GenericService<Model, PK> {

	int insert(Model model);

	int delete(PK id);

	int update(Model model);

	Model findById(PK id);

}