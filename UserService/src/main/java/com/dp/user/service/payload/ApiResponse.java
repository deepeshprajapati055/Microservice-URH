package com.dp.user.service.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

    private ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // ✅ Builder method
    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

    // ✅ Static Builder Class
    public static class ApiResponseBuilder {
        private String message;
        private boolean success;
        private HttpStatus status;

        public ApiResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(message, success, status);
        }
    }
    
    @Override
    public String toString() {
        return "ApiResponse { " +
                "message='" + message + '\'' +
                ", success=" + success +
                ", status=" + status +
                " }";
    }
}
