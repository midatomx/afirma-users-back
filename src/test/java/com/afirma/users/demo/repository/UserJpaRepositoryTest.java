package com.afirma.users.demo.repository;

import com.afirma.users.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserJpaRepositoryTest {

  @Autowired
  private IUserJpaRepository repository;

  @Test
  public void saveUser() {
    User miguel = new User();
    miguel.setId(new Long(36));
    miguel.setNombre("Miguel Angel");
    miguel.setApellido("García");
    miguel.setCorreo_electronico("midato.mx@gmail.com");
    miguel.setFecha_nacimiento("23/03/1975");

    User erick = new User();
    erick.setNombre("E. TONATIUH");
    erick.setApellido("López");
    erick.setCorreo_electronico("erick.mx@gmail.com");
    erick.setFecha_nacimiento("15/10/2003");

    miguel = repository.save(miguel);
    erick = repository.save(erick);

    repository.flush();

    assertEquals(miguel, repository.findById(new Long(10)));
    assertEquals(erick, repository.findById(new Long(11)));
    assertEquals(2, repository.findAll().size());
  }

}
