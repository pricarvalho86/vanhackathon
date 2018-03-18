package com.skipthedishes.vanhackathon.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Invalid username or password")
public class UnauthorizedException extends RuntimeException {


}
