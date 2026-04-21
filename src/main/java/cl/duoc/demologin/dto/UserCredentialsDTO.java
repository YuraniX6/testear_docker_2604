package cl.duoc.demologin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCredentialsDTO {
    
    @NotBlank(message = "El username no puede esta vacio")
    @Size(min = 4, max = 20, message = "El username debe contener entre 4 y 20 caracteres")
    private String username;

    @NotBlank(message = "La contrasena no puede esta vacio")
    @Size(min = 6, max = 30, message = "La contrasena debe contener entre 6 y 30 caracteres")
    private String password;

}
