package com.user.managemant.system.usermanagemantsystem.repository;

import com.user.managemant.system.usermanagemantsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
