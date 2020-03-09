package yh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yh.permission.entity.Permission;
import yh.permission.service.PermissionService;
import yh.role.entity.Role;
import yh.role.entity.RolePermission;
import yh.role.service.RolePermissionService;
import yh.role.service.RoleService;
import yh.security.entity.SecurityUserDetails;
import yh.user.entity.User;
import yh.user.entity.UserRole;
import yh.user.service.UserRoleService;
import yh.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Autowired
	RoleAndPermissionService roleAndPermissionService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	PermissionService permissionService;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = userService.findByUsername(name);
		if (user == null){
			throw new RuntimeException("用户名不存在");
		}
		System.out.println("用户:" + user.getUsername());

		List<Role> userRoles = roleAndPermissionService.getUserRole(user.getId());
		if (userRoles == null || userRoles.isEmpty())
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		List<Permission> userPermissions = roleAndPermissionService.getUserPermission(userRoles);
		if (userPermissions == null || userPermissions.isEmpty()) {
			for (Role role : userRoles)
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), null);
		} else {
			for (Role role : userRoles)
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			System.out.println("角色:" + authorities);
			int size = authorities.size();
			for (Permission permission : userPermissions)
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			System.out.println("权限:" + authorities.subList(size, authorities.size()));
			return new SecurityUserDetails(user.getUsername(), user.getPassword(), authorities);
		}

	}

}
