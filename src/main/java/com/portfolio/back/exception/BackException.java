package com.portfolio.back.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class BackException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus state;
    private String message;

    public BackException(HttpStatus state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

}
