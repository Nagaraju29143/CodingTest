package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Person;
import com.project.service.impl.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	

	@PostMapping("/person")
	public ResponseEntity<String> addPerson(@RequestBody Person person) {
		personService.addPerson(person);
		return new ResponseEntity<String>("Person added", HttpStatus.OK);
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> personList=personService.getAllPersons();
		
		return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable("id") int id){

		Person person= personService.getPerson(id);
		
		return new ResponseEntity<Person>(person, HttpStatus.OK);
		
	}


	@PutMapping("/person")
	public ResponseEntity<String> updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
		return new ResponseEntity<String>("Person updated", HttpStatus.OK);
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable("id") int id) {
		personService.deletePerson(id);
		return new ResponseEntity<String>("Person deleted", HttpStatus.OK);
	}
	
	@GetMapping("/person/count")
	public ResponseEntity<Long> getPersonsCount(){
		
		Long personsCount= personService.getPersonsCount();
		
		return new ResponseEntity<Long>(personsCount, HttpStatus.OK);
		
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") int id) {
		personService.deleteAddress(id);
		return new ResponseEntity<String>("Address deleted", HttpStatus.OK);
	}

}
