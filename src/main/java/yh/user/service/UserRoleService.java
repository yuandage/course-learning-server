package yh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.user.dao.UserRoleDao;
import yh.user.entity.UserRole;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class UserRoleService {
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
}
