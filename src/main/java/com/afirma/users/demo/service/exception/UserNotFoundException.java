package com.afirma.users.demo.service.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(Long id, Throwable cause) {
    super("User with id=" + id + " not found", cause);
  }

}
