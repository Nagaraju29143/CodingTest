package com.project.service.impl;

import java.util.List;

import com.project.entity.Person;

public interface PersonService {

	public void addPerson(Person person);

	public List<Person> getAllPersons();

	public Person getPerson(int id);
	
	public void updatePerson(Person person);
	
	public void deletePerson(int id);
	
	public long getPersonsCount() ;
	
	public void deleteAddress(int id);
}
