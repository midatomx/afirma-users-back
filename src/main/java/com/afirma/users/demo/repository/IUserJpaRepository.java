package com.afirma.users.demo.repository;

import com.afirma.users.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserJpaRepository extends JpaRepository<User, Long> {

  User findById(Integer id);

}
