1.Run the application locally:

  Execute the main method in the com.project.CodingTestApplication class from your IDE.

2.End point to add a rating using the path /api/rest/customer/<customer.id>/rate/<rating> and store this in the database

  EndPoint: http://localhost:2020/CodingTest/api/rest/customer/100/rate
  RequestMethod: POST
  RequestBody: 
  
           {
    "firstName":"nag",
    "lastName":"revalla",
    "movie":[
    	{
    	"name":"test1",
    	"rating":
    		{
    		"rating":5
    		}
    		
    	},
    	{
    	"name":"test2",
    	"rating":
    		{
    		"rating":4
    		}
    	}
    	
    ]
}

3. End point that returns the highest rated movie

   EndPoint: http://localhost:2020/CodingTest/api/rest/customer/hrmovie
   RequestMethod: GET

4. End point that returns the customer with the average rating of that customer 

   EndPoint: http://localhost:2020/CodingTest/api/rest/customer/avgrating/100
   RequestMethod: GET 
  
  