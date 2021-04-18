# Calculator using Spring Boot with embedded H2 Database: Description and Assumptions

This application is written in Java 11 with Spring Boot so that it can be run as a Jar with embedded server.   The application uses an H2 database.

(i) the RESTful endpoints are invoked by using resource URIs as follows:

      (a) http://localhost:8080/math/sum/x/y to invoke MathExpressionController.getASum(x,y) endpoint which does calculation x + y and stores record in H2 MATHEXPRESSION table and returns the MathExpression object in JSON form representing the record.
      
      (b) http://localhost:8080/math/product/a to invoke MathExpressionController.getAProduct(a) endpoint which does calculation a * 2 and stores record in H2 MATHEXPRESSION table and returns the MathExpression object in JSON form representing the record
      
      (c) http://localhost:8080/math/power/s to invoke MathExpressionController.getAPower(s) endpoint which does the calculation s * s and stores record in H2 MATHEXPRESSION table and returns the MathExpression object in JSON form representing the record
      
(ii) the endpoint methods in MathExpressionController invoke service methods in MathExpressionService class which in turn uses the MathExpressionRepository (implementing Spring's JPARespository) for H2 MATHEXPRESSION table insertions

(iii) the "web application" is an HTML file math.html (in the downloaded Git project) which uses JavaScript with AJAX to sequentially call the endpoints in  (a),(b),(c) of (i) above with the arguments passed in the results of the previous stage.   When clicking on the "Calculate" button then do_Calcs() is invoked if there are valid X & Y values and this calls getASum(x,y) and with the result from that calls getAProduct(a) and with the result from that calls getAPower(s).   The Result is passed to the HTML via the JavaScript under the field labeled: "The Result Is".
		   

# Steps to Build and Run the application

(assumes Maven and Java 11 is installed)

(i) download the maven project (assumes Maven is installed on your machine)

(ii) Run the RESTful API Spring Boot application by going to the maven directory (with the pom.xml file) and entering the command:

   mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080
   
(iii) Test the application as below

# Testing RESTful API
 
 This can be done via Curl or more easily in the browser by trying the following commands:
 
 (i) for getASum(8,23) try in browser:  http://localhost:8080/math/sum/8/23
  
     - this will display the JSON representation of the record inserted in MATHEXPRESSION: {"id":16,"operationDesc":"8 + 23","result":31}
       where ID is the primary ID key,OperationDesc is the mathematical operation and Result is the calculated result.
       
(ii) for getAProd(5) try in browser: http://localhost:8080/math/product/31

     - this will display the JSON representation of the record inserted in MATHEXPRESSION: {"id":17,"operationDesc":"31 * 2","result":62}
       where ID is the primary ID key,OperationDesc is the mathematical operation and Result is the calculated result.
       
(iii) for getAPower(62) try in browser: http://localhost:8080/math/power/62


     - this will display the JSON representation of the record inserted in MATHEXPRESSION: {"id":18,"operationDesc":"62 * 62","result":3844}
       where ID is the primary ID key,OperationDesc is the mathematical operation and Result is the calculated result.
 
 
 
# Testing the "Web Application" which access the RESTful API:
 
 (i) open up math.html (found in the downloaded Maven project) in a browser:
 
 (ii) enter in X-val and Y-val
 
 (iii) click "Calculate" button
 
 (iv) the process will show alerts (dialog pop-ups) with the JSON representation of the MATHEXPRESSION H2 database table insertions from getASum(x,y), getAProduct(x+y), getAPower((x+y)*2)
 
 (v) the calculated Result will be displayed on the Math.html page in the box labeled "The Result Is:".
