package yh.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.role.dao.RolePermissionDao;
import yh.role.entity.Role;
import yh.role.entity.RolePermission;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class RolePermissionService {
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Autowired
	private IdWorker idWorker;

	public List<RolePermission> findAll() {
		return rolePermissionDao.findAll();
	}

	public RolePermission findById(String id) {
		return rolePermissionDao.findById(id).orElse(null);
	}

	public void save(RolePermission rolePermission) {
		rolePermission.setId(idWorker.nextId() + "");//设置分布式ID
		rolePermissionDao.save(rolePermission);
	}

	public void update(RolePermission rolePermission) {
		rolePermissionDao.save(rolePermission);
	}

	public void deleteById(String id) {
		rolePermissionDao.deleteById(id);
	}

	public List<RolePermission> findByRoleId(String roleId) {
		return rolePermissionDao.findByRoleId(roleId);
	}
}
