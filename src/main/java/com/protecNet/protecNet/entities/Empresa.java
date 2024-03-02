package com.protecNet.protecNet.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="companies", uniqueConstraints= @UniqueConstraint(columnNames={"correo"}))
@Getter
public class Empresa {
    @Id
    private String id;

    private String correo;
}
