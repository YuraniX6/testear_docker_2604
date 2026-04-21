package cl.duoc.demologin.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//creara la respuesta del sistema
public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;

}
