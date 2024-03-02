package com.protecNet.protecNet.dto;

import com.protecNet.protecNet.entities.Rol;
import lombok.Getter;

@Getter
public class UserDTO {

    private String username;

    private String password;

    private String empresaId;

    private Rol rol;
}
