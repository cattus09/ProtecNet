package com.protecNet.protecNet.persistence;

import com.protecNet.protecNet.entities.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {
}
