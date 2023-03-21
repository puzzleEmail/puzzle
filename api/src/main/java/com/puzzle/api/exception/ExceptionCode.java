package com.puzzle.api.exception;

public class ExceptionCode {
    public static class Api{
        final public static String UNKNOWN_EXCEPTION = "Unknown Exception";
        final public static String ILLEGAL_ENUM_STRING_EXCEPTION = "Illegal Enum Value";
    }

    public static class User{
        final public static String USER_NOT_FOUND_EXCEPTION = "User Not Found";
        final public static String NOT_VALID_PASSWORD_EXCEPTION = "Not Valid Password";
        final public static String USER_NOT_EXIST_EXCEPTION = "User Not Exist";
        final public static String INVALID_CREDENTIAL_EXCEPTION = "Invalid Credential";
    }
}
