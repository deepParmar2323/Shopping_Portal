package com.shopping.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.project.entity.Home;
import com.shopping.project.repository.HomeRepository;

@Service
public class HomeService {

	@Autowired
	private HomeRepository homeRepository;

	public Home save(Home home) {
		return homeRepository.save(home);
	}
}
