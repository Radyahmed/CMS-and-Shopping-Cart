package com.rady.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rady.cmsshoppingcart.models.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
