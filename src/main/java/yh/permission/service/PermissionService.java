package yh.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.permission.dao.PermissionDao;
import yh.permission.entity.Permission;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private IdWorker idWorker;

	public List<Permission> findAll() {
		return permissionDao.findAll();
	}

	public Permission findById(String id) {
		return permissionDao.findById(id).orElse(null);
	}

	public void save(Permission permission) {
		permission.setId(idWorker.nextId() + "");//设置分布式ID
		permissionDao.save(permission);
	}

	public void update(Permission permission) {
		permissionDao.save(permission);
	}

	public void deleteById(String id) {
		permissionDao.deleteById(id);
	}

}
