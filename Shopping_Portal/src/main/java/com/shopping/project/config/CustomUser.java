package com.shopping.project.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shopping.project.entity.Home;

public class CustomUser implements UserDetails {

	private Home home;

	public CustomUser(Home home) {
		super();
		this.home = home;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(home.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {

		return home.getPassword();
	}

	@Override
	public String getUsername() {

		return home.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
