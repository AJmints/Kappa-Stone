package org.backend.kappastoneletsgo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User already exist!")
public class UserAlreadyExistException extends RuntimeException{
}
