package com.example.TestingSwaggerDocs;

public class EndpointInfo {
    private String method;
    private String path;
    private int expectedStatusCode;
    private String contentType;

    public EndpointInfo(String method, String path, int expectedStatusCode, String contentType) {
        this.method = method;
        this.path = path;
        this.expectedStatusCode = expectedStatusCode;
        this.contentType = contentType;
    }

    // 🔧 Getters
    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public String getContentType() {
        return contentType;
    }
}
