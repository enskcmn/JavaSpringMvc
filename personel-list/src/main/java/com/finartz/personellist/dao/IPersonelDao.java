package com.finartz.personellist.dao;

import java.util.List;

import com.finartz.personellist.model.PersonelModel;

public interface IPersonelDao {

	public void create(PersonelModel person);
	
	public void update(PersonelModel person);

	public void delete(PersonelModel person);
	
	public List<PersonelModel> listAll();
	
	public PersonelModel findById(String id);
	
}
