package com.finartz.personellist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.finartz.personellist.model.PersonelModel;


@Repository("iPersonelDao")
public class PersonelDaoImpl implements IPersonelDao {
	@Autowired
	MongoTemplate mongoTemplate;

	private static final String collection_name = "personel";

	public void create(PersonelModel person) {
		try {
			mongoTemplate.insert(person, collection_name);
		}
		catch(Exception e){
			System.out.println(e.getMessage());	
		}
	}

	public void update(PersonelModel person) {
		mongoTemplate.save(person, collection_name);
	}

	public void delete(PersonelModel person) {
		mongoTemplate.remove(person, collection_name);
	}

	public PersonelModel findById(String id) {
		return mongoTemplate.findById(id, PersonelModel.class);
	}

	public List<PersonelModel> listAll() {
		return mongoTemplate.findAll(PersonelModel.class, collection_name);
	}

}
