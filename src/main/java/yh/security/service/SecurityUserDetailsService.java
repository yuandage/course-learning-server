package yh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yh.role.entity.Role;
import yh.security.entity.SecurityUserDetails;
import yh.user.entity.User;
import yh.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Autowired
	RoleAndPermissionService roleAndPermissionService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = userService.findByUsername(name);
		if (user == null) {
			throw new BadCredentialsException("用户名不存在!");
		}
		List<Role> userRoles = roleAndPermissionService.getUserRole(user.getId());
		if (userRoles == null || userRoles.isEmpty())
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null,user,null,null);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		List<yh.permission.entity.Permission> userPermissions = roleAndPermissionService.getUserPermission(userRoles);
		List<String> userRolesList = new ArrayList<>();
		if (userPermissions == null || userPermissions.isEmpty()) {
			for (Role role : userRoles) {
				userRolesList.add(role.getName());
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			}
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null, user, userRolesList, null);
		} else {
			for (Role role : userRoles) {
				userRolesList.add(role.getName());
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			}
			List<String> userPermissionsList = new ArrayList<>();
			for (yh.permission.entity.Permission permission : userPermissions) {
				userPermissionsList.add(permission.getName());
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			}
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), authorities, user, userRolesList, userPermissionsList);
		}
	}

}
