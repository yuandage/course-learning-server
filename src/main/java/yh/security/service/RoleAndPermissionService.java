package yh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.permission.service.PermissionService;
import yh.role.entity.Role;
import yh.role.entity.RolePermission;
import yh.role.service.RolePermissionService;
import yh.role.service.RoleService;
import yh.user.entity.UserRole;
import yh.user.service.UserRoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleAndPermissionService {

	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	PermissionService permissionService;

	public List<Role> getUserRole(String userId) {
		if (userId == null)
			return null;
		List<UserRole> userRoles = userRoleService.findByUserId(userId);
		if (userRoles == null)
			return null;
		List<Role> roles = new ArrayList<>();
		for (UserRole userRole : userRoles) {
			Role role = roleService.findById(userRole.getRoleId());
			roles.add(role);
		}
		return roles;
	}

	public List<yh.permission.entity.Permission> getUserPermission(List<Role> roles) {
		if (roles == null)
			return null;
		List<RolePermission> rolePermissions = new ArrayList<>();
		for (Role role : roles) {
			List<RolePermission> rolePermission = rolePermissionService.findByRoleId(role.getId());
			rolePermissions.addAll(rolePermission);
		}
		if (rolePermissions.isEmpty())
			return null;
		List<yh.permission.entity.Permission> permissions = new ArrayList<>();
		for (RolePermission rolePermission : rolePermissions) {
			yh.permission.entity.Permission permission = permissionService.findById(rolePermission.getPermissionId());
			permissions.add(permission);
		}
		return permissions;
	}

}
