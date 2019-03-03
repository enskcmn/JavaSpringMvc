package com.finartz.personellist.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finartz.personellist.model.PersonelModel;
import com.finartz.personellist.service.IPersonelService;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/")
public class PersonelController {
	@Autowired
	IPersonelService personService;

	@RequestMapping(value = "/list")
	public @ResponseBody String list() {
		Gson gson = new Gson();
		List<PersonelModel> list = personService.list();
		String jsonString = gson.toJson(list); //Serializing..
		return jsonString;
	}

	@RequestMapping(value = "/delete_",consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.DELETE)
	public @ResponseBody void del(@RequestBody PersonelModel person) 
			throws JSONException {
		
		personService.delete(personService.findById(person.getId()));
	}

	@RequestMapping(value = "/add_",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody void save(@RequestBody PersonelModel personel)throws JSONException
	{
		personService.create(new PersonelModel(personel.getFirstName(), 
				personel.getLastName(),
				personel.getPhoneNumber()));
	}

	@RequestMapping(value = "/edit_")
	public @ResponseBody void edit(@RequestBody PersonelModel person) throws JSONException 
	{
		
		personService.update(person);

	}
}
