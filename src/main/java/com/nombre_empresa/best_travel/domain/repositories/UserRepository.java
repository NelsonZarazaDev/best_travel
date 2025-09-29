package com.nombre_empresa.best_travel.domain.repositories;

import com.nombre_empresa.best_travel.domain.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    Object findByUserName(String userName);
}
