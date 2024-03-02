package com.protecNet.protecNet.controllers;


import com.protecNet.protecNet.dto.UserDTO;
import com.protecNet.protecNet.entities.Login;
import com.protecNet.protecNet.entities.User;
import com.protecNet.protecNet.exceptions.InvalidLoginException;
import com.protecNet.protecNet.services.UsersService;
import com.protecNet.protecNet.entities.Token;
import com.protecNet.protecNet.services.token.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private final UsersService usersService;

    private final ITokenService tokenService;

    private final PasswordEncoder encryptionService;

    public AuthController(@Autowired UsersService usersService, @Autowired ITokenService tokenService
            , @Autowired PasswordEncoder encryptionService) {
        this.usersService = usersService;
        this.tokenService = tokenService;
        this.encryptionService = encryptionService;
    }

    @PostMapping("/login")
    public Token enableService(@RequestBody Login login) throws InvalidLoginException {
        return this.tokenService.getToken(login);
    }

    @GetMapping("/password/{psswrd}")
    public String getPasswordEncrypted(@PathVariable String psswrd){
        return encryptionService.encode(psswrd);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserDTO userDto){
        return this.usersService.create(userDto);
    }
}
