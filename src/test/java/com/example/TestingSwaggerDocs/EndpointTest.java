package com.example.TestingSwaggerDocs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class EndpointTest {


    private String replacePathParamsIfNeeded(String url) {
        if (url.contains("{petId}")) {
            return url.replace("{petId}", "12345"); // Use the ID you used in POST
        }
        return url;
    }


    private String addQueryParamsIfNeeded(String url) {
        if (url.contains("/findByStatus")) {
            return url + "?status=available";
        } else if (url.contains("/findByTags")) {
            return url + "?tags=tag1";
        }
        return url;
    }


    @Test
    public void testSwaggerEndpoints() throws Exception {
        SwaggerParserService parser = new SwaggerParserService();
        String swaggerUrl = "https://petstore3.swagger.io/api/v3/openapi.json";

        List<EndpointInfo> endpoints = parser.parseSwagger(swaggerUrl);

        for (EndpointInfo endpoint : endpoints) {
            String url = "https://petstore3.swagger.io/api/v3" + endpoint.getPath();
            String method = endpoint.getMethod();

            System.out.println("Testing " + method + " " + url);

            Response response = null;

            switch (method) {
                case "GET":
                    url = replacePathParamsIfNeeded(url);
                    url = addQueryParamsIfNeeded(url);
                    response = RestAssured.get(url);
                    break;

                case "DELETE":
                    url = replacePathParamsIfNeeded(url);
                    response = RestAssured.delete(url);
                    break;

                case "PUT":
                    // Step 1: Ensure the pet exists
                    RestAssured.given()
                            .header("Content-Type", "application/json")
                            .body("{ \"id\": 12345, \"name\": \"Doggie\", \"photoUrls\": [\"string\"], \"status\": \"available\" }")
                            .post("https://petstore3.swagger.io/api/v3/pet");

                    // Step 2: Run PUT on the dynamic URL
                    response = RestAssured.given()
                            .header("Content-Type", "application/json")
                            .body("{ \"id\": 12345, \"name\": \"DoggieUpdated\", \"status\": \"sold\" }")
                            .put(url); // use dynamic url
                    break;
            }

            if (response != null) {
                assertEquals(response.getStatusCode(), endpoint.getExpectedStatusCode(), "Status code mismatch");
                assertEquals(response.getContentType().contains(endpoint.getContentType()), true, "Content type mismatch");
            }
        }
    }
}