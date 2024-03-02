package com.protecNet.protecNet.entities;


import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table(name="users")
public class User {

    @Id
    private String username;
    // Relación con Empresa
    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private String encryptedPassword;

    public User(String username,String encryptedPassword, Empresa empresa, Rol rol){
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.empresa = empresa;
        this.rol = rol;
    }

    public User(){

    }

}
