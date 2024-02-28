package com.shopping.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shopping.project.entity.Home;
import com.shopping.project.repository.HomeRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private HomeRepository homeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Home home = homeRepository.findByUsername(username);

		if (home == null) {
			throw new UsernameNotFoundException("user name not found");
		} else {
			return new CustomUser(home);
		}

	}

}
