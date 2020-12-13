package com.rady.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rady.cmsshoppingcart.models.data.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
