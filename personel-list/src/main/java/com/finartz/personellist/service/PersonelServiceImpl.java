package com.finartz.personellist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.personellist.dao.IPersonelDao;
import com.finartz.personellist.model.PersonelModel;

@Service("iPersonService")
public class PersonelServiceImpl implements IPersonelService {

	
	@Autowired
	IPersonelDao personelDao;
	
	public void create(PersonelModel person) {
		personelDao.create(person);
	}

	public void update(PersonelModel person) {
		personelDao.update(person);		
	}

	public void delete(PersonelModel person) {
		personelDao.delete(person);
	}

	public PersonelModel findById(String id) {
		return personelDao.findById(id);
	}

	public List<PersonelModel> list() {
		return personelDao.listAll();
	}

}
