package com.shopping.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shopping.project.entity.Admin;
import com.shopping.project.repository.AdminRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Admin admin = adminRepository.findByUsername(username);

		if (admin == null) {
			throw new UsernameNotFoundException("user name not found");
		} else {
			return new CustomUser(admin);
		}

	}

}
