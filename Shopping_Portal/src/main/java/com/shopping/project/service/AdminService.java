package com.shopping.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.project.entity.Admin;
import com.shopping.project.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin findUserData(String username) {
		return adminRepository.findByUsername(username);
	}

	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	public Page<Admin> getPaginateAdmin(int currentpage, int size, String username) {
		Pageable pageable = PageRequest.of(currentpage, size);

		if (username != null) {
			return adminRepository.findByUsernameContaining(username, pageable);
		}
		return adminRepository.findAll(pageable);
	}
}
