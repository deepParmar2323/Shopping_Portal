package com.shopping.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.project.entity.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {

	public Home findByUsername(String userName);
}
