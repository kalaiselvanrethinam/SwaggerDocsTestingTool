package com.example.TestingSwaggerDocs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwaggerParserService {

    public List<EndpointInfo> parseSwagger(String swaggerUrl) throws IOException {
        List<EndpointInfo> endpointList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new URL(swaggerUrl));

        JsonNode pathsNode = rootNode.get("paths");
        if (pathsNode != null) {
            Iterator<String> fieldNames = pathsNode.fieldNames();

            while (fieldNames.hasNext()) {
                String path = fieldNames.next();
                JsonNode methodsNode = pathsNode.get(path);

                methodsNode.fieldNames().forEachRemaining(method -> {
                    if (method.equalsIgnoreCase("get") || method.equalsIgnoreCase("put") || method.equalsIgnoreCase("delete")) {
                        JsonNode methodNode = methodsNode.get(method);
                        JsonNode responses = methodNode.get("responses");
                        int expectedStatus = 200; // Default to 200
                        String contentType = "application/json"; // Default

                        if (responses != null && responses.has("200")) {
                            JsonNode response200 = responses.get("200");
                            JsonNode content = response200.get("content");

                            if (content != null && content.fieldNames().hasNext()) {
                                contentType = content.fieldNames().next(); // e.g., application/json
                            }
                        }

                        endpointList.add(new EndpointInfo(method.toUpperCase(), path, expectedStatus, contentType));
                    }
                });
            }
        }

        return endpointList;
    }
}
