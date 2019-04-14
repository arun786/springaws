# Spring Boot application deployed in AWS as a Jar file or War file

This project is about developing Spring Boot Rest Service Project using the below

1. Spring Boot 2.0
2. Spring JPA
3. AWS RDS mysql
4. Deployment using AWS Elastic BeanStalk
5. AWS Route53


Deployment Process :
 
steps 

1. Create RDS MySQL database in AWS, connect to your local Mysql WorkBench.
2. Create required Tables in MySQL Workbench. 
3. Connect the Spring boot application to the aws RDS mySQL database.
4. Build the spring boot Rest application using Maven tool. It should be a war file. The good thing about war file is that 
we can choose port of our choice, if we want the spring boot application to be deployed as jar file, that can be done by defining
the port as 5000 in application.properties.
5. Use Elastic Bean Stalk, to deploy the war file to aws.

## Elastic Bean Stalk

    1. We need to create Application first
    2. Once Application is created, we create an Environment using Select Environment tier.
    3. We get 2 options
        1. Web Server Environment
        2. Worker Environment
    4. Select the Web Server Environment.
    5. Add the necessary details and in the Application Code. There will be an option of upload your code. Upload the war or jar file.
    

Route53 DNS name : myspringbootaws.de

Different URL's which can be accessed via Rest API is as below.

1. Get Service - This will get data from AWS RDS tables based on Id.

Http Method : Get.

Sample url : 
[myspringbootaws.de/customer/v2/customer/12](myspringbootaws.de/customer/v2/customer/12)

12 is the Id.


The response will be as below.

    {
        "id": 12,
        "firstName": "Rahul",
        "lastName": "Dravid",
        "email": "rahulDr@gmail.com"
    }

--to be continued 



Development of Spring Boot Application using JPA.

-- to be continued
