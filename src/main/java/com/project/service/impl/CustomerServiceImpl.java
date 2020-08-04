package com.project.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Customer;
import com.project.entity.Movie;
import com.project.entity.Rating;
import com.project.model.CustomerResponse;
import com.project.repository.CustomerRepository;
import com.project.repository.MovieRepository;
import com.project.repository.RatingRepository;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	private CustomerRepository custRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public void addRating(Customer customer) {
		try {
			custRepository.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getHighestRatedMovie() {
		String highestRatedMovie="";
		List<Rating> ratingList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();
		
		try {
			
			ratingRepository.findAll().forEach(rating -> ratingList.add(rating));
	        Rating rating= ratingList.stream().max(Comparator.comparing( Rating::getRating )).get();
	        
	        
	        movieRepository.findAll().forEach(movie -> movieList.add(movie));
	        highestRatedMovie =  movieList.stream()
	        		  .filter(movie ->rating.getRating()==(movie.getRating().getRating()))
	        		  .findAny().map(Movie::getName)
	        		  .orElse(null);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return highestRatedMovie;
		
	}
	
	public CustomerResponse getAverageRating(int custId) {
		CustomerResponse custResponse=null;
		List<Customer> custList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();
		List<Rating> ratingList = new ArrayList<>();
		
		try {
			double averageRating=0.0;
			custRepository.findAll().forEach(cust -> custList.add(cust));
			
	         movieList =  custList.stream()
	        		  .filter(cust ->custId==cust.getCustId())
	        		  .findAny().map(Customer::getMovie)
	        		  .orElse(null);
			
			
			
			ratingList=movieList.stream().map(Movie::getRating).collect(Collectors.toList());
	        
			 averageRating = ratingList.stream()
		            .mapToDouble(Rating::getRating)
		            .filter(rating -> rating > 0.0)
		            .summaryStatistics().getAverage();
			 
			 custResponse=new CustomerResponse(custList.get(0).getCustId(),custList.get(0).getFirstName(),custList.get(0).getLastName(),averageRating)	; 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return custResponse;
		
	}

}
