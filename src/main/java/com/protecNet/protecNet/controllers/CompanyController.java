package com.protecNet.protecNet.controllers;

import com.protecNet.protecNet.entities.Empresa;
import com.protecNet.protecNet.services.EmpresaService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/companies")
public class CompanyController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    @RolesAllowed("hasRole('ADMIN'")
    public String prueba(){
        return "aaaaaaaa";
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.create(empresa);
    }
}
