package com.pe.relari.domain.exceptionhandler;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private static final String EMPTY = "";

    private final ErrorCategory catalog;
    private final Throwable detail;

    protected ApiException(ErrorCategory catalog) {
        super(EMPTY);
        this.catalog = catalog;
        this.detail = null;
    }

    protected ApiException(ErrorCategory catalog, Throwable detail) {
        super(EMPTY);
        this.catalog = catalog;
        this.detail = detail;
    }

    public static ApiException of(ErrorCategory catalog) {
        return new ApiException(catalog);
    }

    public static ApiException of(ErrorCategory catalog, Throwable throwable) {
        return new ApiException(catalog, throwable);
    }

}
