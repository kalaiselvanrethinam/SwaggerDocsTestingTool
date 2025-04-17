This project is designed to test API endpoints defined in a Swagger specification using RestAssured for sending requests and Allure for generating test reports. It fetches the Swagger API documentation (Petstore API) and performs tests on the endpoints dynamically.

Features
Fetch API details (GET, POST, PUT, DELETE) from a Swagger JSON specification.

Perform API testing using RestAssured.

Generate Allure reports with detailed test execution results.

Prerequisites
JDK 8+: Java Development Kit 8 or later.

Maven: Used for build and dependencies management.

Allure Commandline (optional, for generating reports): Allure Installation.

Installation
1. Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-username/TestingSwaggerDocs.git
cd TestingSwaggerDocs
2. Build the Project
Make sure you have Maven installed. Run the following to build the project:

bash
Copy
Edit
mvn clean install
3. Run the Tests
You can execute the tests using Maven and TestNG:

bash
Copy
Edit
mvn test
This will run the API tests and validate endpoints against the expected status codes and content types.

4. Generate Allure Reports (Optional)
If you'd like to generate reports, run:

bash
Copy
Edit
mvn allure:serve
This command will open the Allure report in your browser, showing detailed test execution results.

Project Structure
SwaggerParserService.java: Parses Swagger JSON to extract API endpoints.

EndpointInfo.java: Contains data related to API endpoints (method, path, status code, content type).

TestingSwaggerDocsApplication.java: Entry point for the Spring Boot application, responsible for fetching the Swagger URL and displaying endpoint info.

EndpointTest.java: Contains the API tests using RestAssured. It runs tests for GET, POST, PUT, DELETE operations.

pom.xml: Maven build file, including dependencies for RestAssured, TestNG, and Allure.

Running Tests
The test suite performs the following tasks:

Parse the Swagger URL to extract API endpoints.

Run tests for each endpoint using the HTTP methods (GET, POST, PUT, DELETE).

Validate response codes and content types against expected values.

Generate Allure reports for test results.

Troubleshooting
1. Error: Unable to access jarfile
If you see this error, ensure you are in the correct directory where the JAR file is located and that the file is accessible.

2. Missing Main Manifest Attribute
If you encounter the no main manifest attribute error, make sure the JAR is properly packaged with a Main-Class attribute in the manifest.

3. Endpoint Errors
For 500 Internal Server errors, check if the endpoint requires additional configurations, body content, or headers.
