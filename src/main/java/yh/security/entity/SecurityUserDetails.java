package yh.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import yh.user.entity.User;

import java.util.Collection;
import java.util.List;

public class SecurityUserDetails implements UserDetails {

	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private User user;
	private List<String> userRoles;
	private List<String> userAuthorities;

	public SecurityUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public SecurityUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, User user, List<String> userRoles, List<String> userAuthorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.user = user;
		this.userRoles = userRoles;
		this.userAuthorities = userAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public User getUser() {
		return user;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public List<String> getUserAuthorities() {
		return userAuthorities;
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
