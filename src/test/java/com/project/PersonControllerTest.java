package com.project;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.controller.PersonController;
import com.project.entity.Address;
import com.project.entity.Person;
import com.project.service.impl.PersonServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private PersonServiceImpl personService;
    

    @Test
	public void addPersonTest() throws Exception {
    	
    	List<Address> addrList=new ArrayList<>();
    	
    	Address address1=new Address();
    	address1.setStreet("mpur");address1.setCity("hyderabad");address1.setState("telangana");address1.setPostalCode("500084");
    	
    	Address address2=new Address();
    	address2.setStreet("mpalem");address2.setCity("vizag");address2.setState("ap");address2.setPostalCode("535006");
    	
    	addrList.add(address1);addrList.add(address2);
    	
		Person person=new Person();
		person.setId(100);
		person.setFirstName("nag");
		person.setLastName("revalla");
		person.setAddressList(addrList);
		
		String personJson = toJson(person);
		
		
		mockMvc.perform(
				post("/person")
				.accept(MediaType.APPLICATION_JSON)
				.content(personJson)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
		         .andDo(MockMvcResultHandlers.print())
		         .andExpect(content().string(containsString("Person added")));
		  
	}

	@Test
	public void getAllPersonsTest() throws Exception {
		
		mockMvc.perform(
				get("/person")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
		         .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void updatePerson() throws Exception {
		
        List<Address> addrList=new ArrayList<>();
    	
    	Address address1=new Address();
    	address1.setStreet("test");address1.setCity("hyderabad");address1.setState("telangana");address1.setPostalCode("500084");
    	addrList.add(address1);
    	
		Person person=new Person();
		person.setFirstName("nag");
		person.setLastName("revalla");
		person.setAddressList(addrList);
		
		String personJson = toJson(person);
		
		
		mockMvc.perform(
				put("/person")
				.accept(MediaType.APPLICATION_JSON)
				.content(personJson)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
		         .andExpect(content().string(containsString("Person updated")));
	}
	
	@Test
	public void deletePersonTest() throws Exception {
		
		mockMvc.perform(
				delete("/person/{id}",100)
				).andExpect(status().isOk())
		         .andExpect(content().string(containsString("Person deleted")));
	}
	
	
	

	 private String toJson(Object obj) throws Exception {
	        ObjectMapper map = new ObjectMapper();
	        return map.writeValueAsString(obj);
	    }
}
