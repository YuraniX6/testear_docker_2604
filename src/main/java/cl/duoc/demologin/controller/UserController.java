package cl.duoc.demologin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.demologin.dto.ApiResponse;
import cl.duoc.demologin.dto.UserDto;
import cl.duoc.demologin.service.UserService;
import lombok.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    

}
