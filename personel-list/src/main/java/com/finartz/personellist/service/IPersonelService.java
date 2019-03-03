package com.finartz.personellist.service;

import java.util.List;


import com.finartz.personellist.model.PersonelModel;

public interface IPersonelService {
	
	public void create(PersonelModel person);

	public void update(PersonelModel person);

	public void delete(PersonelModel person);

	public PersonelModel findById(String id);

	public List<PersonelModel> list();
}
