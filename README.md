webshop_ap
===============================

Technology 
===============================
Java 8 \
Maven  \
Spring(Spring boot, web, data) \
H2 (Memory database, data file location:src/main/resources/data.sql) \

Instructions
==============================
1. Clone the source code from : https://github.com/rezaul3025/webshop_api  
2. Go to the folder webshop_api and run : \
	2.1. Build -> $ mvn clean install 
	\
	2.1. Run -> $ mvn spring-boot:run
3. Test API API endpoints : \
	3.1. Create product: 
	
	    URL: http://localhost:7070/api/v1/product    
	                            
	    Method: POST
	    
	    Request body: 	   {"name":"Product 3","price":99.87 }                
	    
	    Response: { 
                      "id": 3,
                      "name": "Product 3",
                      "price": 99.87
                  }
                  
    3.2. Get all products                   
    
        URL: http://localhost:7070/api/v1/products
        
        Method: GET                        
        
        Response : [
                       {
                           "id": 1,
                           "name": "Product 1",
                           "price": 99.98
                       },
                       {
                           "id": 2,
                           "name": "Product 2",
                           "price": 99.87
                       },
                       {
                           "id": 3,
                           "name": "Product 3",
                           "price": 99.87
                       }
                   ]
    
    3.3. Update product :   
    
         URL: http://localhost:7070/api/v1/product                           
         
         Method: PUT
         
         Request body : 
           {"id":1,
             "name":"Product 3",
           "price":100.99
           }
           
         Response :
         {
             "id": 1,
             "name": "Product 3",
             "price": 100.99
         }  
         
    3.4. Place order    
    
         URL: http://localhost:7070/api/v1/order
         
         Method: POST
         
         Request body :
                {
                  "customerId":3001,
                  "customerEmail":"customer_em@gtm.com",
                  "orderDate":"2018-12-05T17:40:58.699",
                  "orderLines":[
                    {
                      "productId":1,
                      "title":"Product 1",
                      "price":99.98,
                      "quantity":2
                    }
                    ]
                } 
                
                
         Response:
         {
             "id": 3,
             "orderDate": "2018-12-05T17:40:58.699+0000",
             "customerId": 3001,
             "customerEmail": "customer_em@gtm.com",
             "orderLines": [
                 {
                     "id": 3,
                     "title": "Product 3",
                     "price": 100.99,
                     "quantity": 2
                 }
             ]
         }    
         
     3.5. Find orders in given time period  
     
        URL: http://localhost:7070/api/v1/orders?from=2018-12-01T18:47:52.692&to=2018-12-02T14:30:50.672
        
        Method: GET 
        
        Response:
        [
            {
                "id": 1,
                "orderDate": "2018-12-01T17:47:52.692+0000",
                "customerId": 2001,
                "customerEmail": "customer_em@text.com",
                "orderLines": [
                    {
                        "id": 1,
                        "title": "Product 1",
                        "price": 99.98,
                        "quantity": 2
                    }
                ]
            },
            {
                "id": 2,
                "orderDate": "2018-12-02T13:30:50.672+0000",
                "customerId": 2002,
                "customerEmail": "customer_em1@text76.com",
                "orderLines": [
                    {
                        "id": 2,
                        "title": "Product 2",
                        "price": 99.87,
                        "quantity": 2
                    }
                ]
            }
        ]       