package yh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.permission.entity.Permission;
import yh.permission.service.PermissionService;
import yh.role.entity.Role;
import yh.role.entity.RolePermission;
import yh.role.service.RolePermissionService;
import yh.role.service.RoleService;
import yh.user.dao.UserRoleDao;
import yh.user.entity.UserRole;
import yh.util.IdWorker;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private IdWorker idWorker;

	public List<UserRole> findAll() {
		return userRoleDao.findAll();
	}

	public UserRole findById(String id) {
		return userRoleDao.findById(id).orElse(null);
	}

	public void save(UserRole userRole) {
		userRole.setId(idWorker.nextId() + "");//设置分布式ID
		userRoleDao.save(userRole);
	}

	public void update(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	public void deleteById(String id) {
		userRoleDao.deleteById(id);
	}

	public List<UserRole> findByUserId(String id) {
		return userRoleDao.findByUserId(id);
	}

	public void deleteByUserIdAndRoleId(String userId, String roleId) {
		userRoleDao.deleteByUserIdAndRoleId(userId, roleId);
	}

	public List<Role> getUserRoles(String userId) {
		if (userId == null)
			return null;
		List<UserRole> userRoles = findByUserId(userId);
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
