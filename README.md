# springaws

This project is about developing Spring Boot Rest Service Project using the below

1. Spring Boot 2.0
2. Spring JPA
3. AWS RDS mysql
4. Deployment using aws Elastic BeanStalk
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

Route53 DNS name : myspringbootaws.de

Different URL's which can be accessed the Rest API is as below.

1. Get Service - This will get data from AWS RDS tables based on Id.

Http Method : Get.

Sample url : myspringbootaws.de/customer/v2/customer/12

12 is the Id.


The response will be as below.

    {
        "id": 12,
        "firstName": "Rahul",
        "lastName": "Dravid",
        "email": "rahulDr@gmail.com"
    }


Development of Spring Boot Application using JPA.

-- to be continued
