package com.ridzaq.springbootmasterclass.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

public record ApiException (String message,Throwable throwable,HttpStatus httpStatus,ZonedDateTime zonedDateTime) {

}
