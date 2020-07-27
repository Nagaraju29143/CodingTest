package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Person;
import com.project.repository.AddressRepository;
import com.project.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	

	public void addPerson(Person person) {
		try {
			personRepository.save(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Person> getAllPersons() {
		List<Person> personList = new ArrayList<>();
		
		try {
		personRepository.findAll().forEach(person -> personList.add(person));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return personList;
	}

	public Person getPerson(int id) {
		Optional<Person> person = null;
		try {
			person = personRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person.get();
	}

	public void updatePerson(Person person) {
		try {
			
			Person per = personRepository.findById(person.getId()).get();
			if(per!=null) {
					personRepository.save(person);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePerson(int id) {
		try {
			personRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public long getPersonsCount() {
		long personsCount=0;
		try { 
			 personsCount=personRepository.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personsCount;
	}
	
	public void deleteAddress(int id) {
		try {
			addressRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
