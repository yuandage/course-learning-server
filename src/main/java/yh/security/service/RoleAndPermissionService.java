package yh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.permission.entity.Permission;
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

	public List<Role> getUserRoles(String userId) {
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

	public List<Permission> getRolePermissions(String roleId) {
		if (roleId == null)
			return null;
		List<RolePermission> rolePermissions = rolePermissionService.findByRoleId(roleId);
		if (rolePermissions == null)
			return null;
		List<Permission> permissions = new ArrayList<>();
		for (RolePermission rolePermission : rolePermissions) {
			Permission permission = permissionService.findById(rolePermission.getPermissionId());
			permissions.add(permission);
		}
		return permissions;
	}

	public List<Permission> getUserPermissions(List<Role> roles) {
		if (roles == null||roles.isEmpty())
			return null;
		List<Permission> permissions = new ArrayList<>();
		for (Role role : roles) {
			permissions.addAll(getRolePermissions(role.getId()));
		}
		return permissions;
	}

}
