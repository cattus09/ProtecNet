package com.protecNet.protecNet.services;



import com.protecNet.protecNet.entities.Empresa;
import com.protecNet.protecNet.entities.User;
import com.protecNet.protecNet.persistence.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public boolean isValidLicense(User user, String license) {
        //TODO Mira en BD si la licencia existe y esta activa
        return true;
    }

    public Empresa getById(String empresaId) {
        return empresaRepository.findById(empresaId).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
    }

    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
