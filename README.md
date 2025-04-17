# 🧪 Testing Swagger Documentation API Endpoints

This project provides a tool for dynamically testing API endpoints defined in Swagger (OpenAPI) documentation. It uses Swagger JSON to fetch API paths and tests them using **RestAssured** for GET, PUT, and DELETE methods. It supports dynamic path parameters, validates status codes and content types, and can be integrated with CI/CD pipelines and Allure reporting.

---

## 📌 Features

- ✅ **Swagger Parser**: Fetches and parses Swagger JSON from a given URL.
- ✅ **Dynamic Endpoint Testing**: Automatically tests GET, PUT, and DELETE endpoints using RestAssured.
- ✅ **Response Validation**: Checks status codes and content types against expected Swagger definitions.
- ✅ **Dynamic Parameter Handling**: Replaces `{id}` or other path params with valid values.
- ✅ **Optional Reporting**: Supports Allure for beautiful test reports.
- ✅ **CI/CD Compatible**: Easily integrate with Jenkins, GitLab CI, or GitHub Actions.

---

## 🔧 Prerequisites

Make sure you have the following installed:

- **Java 8+**
- **Maven** or **Gradle**
- **Spring Boot**
- **Internet connection** (for fetching Swagger JSON)

---

## ⚙️ Setup Instructions

### ✅ Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/TestingSwaggerDocs.git

### ✅ Step 2: Navigate to the Project Directory

```bash
cd TestingSwaggerDocs
mvn clean install

## 🚀 Running the Application
### ▶️ Step 1: Start the Spring Boot App
Use Maven to run the application:

mvn spring-boot:run

## 🧪 Running the Tests
### ✅ Step 2: Run the Tests
Run all tests using:

mvn test

📊 Test Coverage
✅ GET: Checks for response structure and expected values.

✅ PUT: Simulates update and validates response.

✅ DELETE: Ensures proper deletion and status.

🎁 Optional Features
📈 Allure Reporting
Enable rich test reporting with Allure.

Add Allure dependencies in pom.xml

After tests, run:

allure serve target/allure-results

🙌 Acknowledgements
Swagger / OpenAPI for API definitions

RestAssured for HTTP testing

Spring Boot

Allure for test reporting

