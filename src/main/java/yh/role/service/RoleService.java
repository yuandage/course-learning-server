package yh.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.role.dao.RoleDao;
import yh.role.entity.Role;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private IdWorker idWorker;

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public Role findById(String id) {
		return roleDao.findById(id).orElse(null);
	}

	public void save(Role role) {
		role.setId(idWorker.nextStringId());//设置分布式ID
		roleDao.save(role);
	}

	public void update(Role role) {
		roleDao.save(role);
	}

	public void deleteById(String id) {
		roleDao.deleteById(id);
	}

}
