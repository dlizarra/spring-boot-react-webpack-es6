package com.dlizarra.startuphub.user;

import java.util.Optional;

import com.dlizarra.startuphub.support.jpa.CustomJpaRepository;

public interface UserRepository extends CustomJpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
