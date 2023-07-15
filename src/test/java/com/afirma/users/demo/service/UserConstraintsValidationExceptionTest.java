package com.afirma.users.demo.service;

import com.afirma.users.demo.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserConstraintsValidationExceptionTest {

  @Autowired
  private UserServiceImpl userService;

  @Test
  public void constraintsValidationExceptionTest() {
    UserDTO userDTO = new UserDTO();
    assertThrows(ConstraintViolationException.class, () -> {
      userService.save(userDTO);
    });

    // SOLO PARA VALIDACIONES
    /*try {
      UserDTO userDTO = new UserDTO();
      userService.create(userDTO);
    } catch (Exception e) {
      System.out.println();
    }*/
  }
}
