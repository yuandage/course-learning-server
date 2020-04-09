package yh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.user.dao.UserFavoriteDao;
import yh.user.entity.UserFavorite;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class UserFavoriteService {
	@Autowired
	private UserFavoriteDao userFavoriteDao;
	@Autowired
	private IdWorker idWorker;

	public List<UserFavorite> findAll() {
		return userFavoriteDao.findAll();
	}

	public UserFavorite findById(String id) {
		return userFavoriteDao.findById(id).orElse(null);
	}

	public String save(UserFavorite userFavorite) {
		String id = idWorker.nextStringId();
		userFavorite.setId(id);//设置分布式ID
		userFavoriteDao.save(userFavorite);
		return id;
	}

	public void update(UserFavorite userFavorite) {
		userFavoriteDao.save(userFavorite);
	}

	public void deleteById(String id) {
		userFavoriteDao.deleteById(id);
	}

	public List<UserFavorite> findByUserId(String userId) {
		return userFavoriteDao.findByUserId(userId);
	}
}
