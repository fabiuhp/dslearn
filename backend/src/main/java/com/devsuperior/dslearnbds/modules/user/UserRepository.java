package com.devsuperior.dslearnbds.modules.user;

import com.devsuperior.dslearnbds.modules.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
