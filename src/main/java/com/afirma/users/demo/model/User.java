package com.afirma.users.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String nombre;

  @Column(length = 100, nullable = false)
  private String apellido;

  @Column(length = 100, nullable = false, unique = true)
  private String correo_electronico;

  @Column(length = 100, nullable = false)
  private String fecha_nacimiento;

}
