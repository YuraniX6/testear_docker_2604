package cl.duoc.demologin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.demologin.dto.ApiResponse;
import cl.duoc.demologin.dto.UserCredentialsDTO;
import cl.duoc.demologin.dto.UserDto;
import cl.duoc.demologin.model.User;
import cl.duoc.demologin.service.UserService;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    
    private final UserService userService;

    //ocupar el listar de service, con elementos de ApiResponse y DTO
    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUser(){
        List<UserDto> users = userService.getAllUserDTO();
        ApiResponse<List<UserDto>> response = new ApiResponse<>(
            200,
            "Listado de Usuarios",
            users
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resgister")
    public ResponseEntity<ApiResponse<UserDto>> register(
        @Valid @RequestBody UserCredentialsDTO dto){
            User newUser = userService.registerUser(dto.getUsername(), dto.getPassword());
            UserDto userDto = new UserDto(newUser.getId(), newUser.getUsername());

            ApiResponse<UserDto> response =
            new ApiResponse<>(
                200,
                "Usuario Registrado",
                userDto
            );
            return ResponseEntity.ok(response);
        }
    
    
    

}
