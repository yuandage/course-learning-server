package yh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yh.permission.entity.Permission;
import yh.role.entity.Role;
import yh.security.entity.SecurityUserDetails;
import yh.user.entity.User;
import yh.user.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		List<Role> userRoles = roleAndPermissionService.getUserRoles(user.getId());
		if (userRoles == null || userRoles.isEmpty())
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null,user,null,null);
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();

		List<Permission> userPermissions = roleAndPermissionService.getUserPermissions(userRoles);
		Set<String> userRolesSet = new HashSet<>();
		if (userPermissions == null || userPermissions.isEmpty()) {
			for (Role role : userRoles) {
				userRolesSet.add(role.getName());
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			}
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null, user, userRolesSet, null);
		} else {
			for (Role role : userRoles) {
				userRolesSet.add(role.getName());
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			}
			Set<String> userPermissionsSet = new HashSet<>();
			for (Permission permission : userPermissions) {
				userPermissionsSet.add(permission.getName());
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			}
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), authorities, user, userRolesSet, userPermissionsSet);
		}
	}

}
