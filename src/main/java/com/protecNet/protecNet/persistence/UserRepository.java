package com.protecNet.protecNet.persistence;

import com.protecNet.protecNet.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
