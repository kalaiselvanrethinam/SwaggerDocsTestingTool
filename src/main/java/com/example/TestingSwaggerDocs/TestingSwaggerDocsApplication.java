package com.example.TestingSwaggerDocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TestingSwaggerDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSwaggerDocsApplication.class, args);

		SwaggerParserService parser = new SwaggerParserService();
		try {
			String swaggerUrl = "https://petstore3.swagger.io/api/v3/openapi.json";
			List<EndpointInfo> endpoints = parser.parseSwagger(swaggerUrl);
			for (EndpointInfo endpoint : endpoints) {
				System.out.println(endpoint.getMethod() + " " + endpoint.getPath() + " | Expected: " + endpoint.getExpectedStatusCode() + " | Type: " + endpoint.getContentType());
			}
		} catch (IOException e) {
			System.err.println("Error reading Swagger: " + e.getMessage());
		}
	}
}
