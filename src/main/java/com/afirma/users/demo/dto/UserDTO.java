package com.afirma.users.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

  @EqualsAndHashCode.Include
  private Long id;

  @NotBlank
  @NotNull
  @Size(max = 100)
  private String nombre;

  @NotBlank
  @NotNull
  @Size(max = 100)
  private String apellido;

  @NotBlank
  @NotNull
  @Size(max = 100)
  private String correo_electronico;

  @NotBlank
  @NotNull
  @Size(max = 100)
  private String fecha_nacimiento;

}
