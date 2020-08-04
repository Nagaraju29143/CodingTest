package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.model.CustomerResponse;
import com.project.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping(value="/api/rest")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl cutService;
	
	@PostMapping("/customer/{custid}/rate")
	public ResponseEntity<String> addRating(@PathVariable("custid") int custid,@RequestBody Customer customer) {
		
		customer.setCustId(custid);
		
		cutService.addRating(customer);
		
		return new ResponseEntity<String>("Rating saved", HttpStatus.OK);
	}
	
	@GetMapping("/customer/hrmovie")
	public ResponseEntity<String> getHighestRatedMovie() {
		    
		String highestRatedMovie=cutService.getHighestRatedMovie();
		
		return new ResponseEntity<String>(highestRatedMovie, HttpStatus.OK);
	}
	
	@GetMapping("/customer/avgrating/{custid}")
	public ResponseEntity<CustomerResponse> getAverageRating(@PathVariable("custid") int custid) {
		    
		CustomerResponse custResponse=cutService.getAverageRating(custid);
		
		return new ResponseEntity<CustomerResponse>(custResponse, HttpStatus.OK);
	}
}
