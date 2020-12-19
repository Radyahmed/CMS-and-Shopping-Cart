package com.cms.restclient.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.restclient.models.data.Page;

public interface PageRepository extends JpaRepository<Page, Integer> {

	Page findBySlug(String slug);

	Page findBySlugAndIdNot(String slug, int id);

	List<Page> findAllByOrderBySortingAsc();

}