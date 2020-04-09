package yh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.user.dao.UserCourseDao;
import yh.user.entity.UserCourse;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class UserCourseService {
	@Autowired
	private UserCourseDao userCourseDao;
	@Autowired
	private IdWorker idWorker;

	public List<UserCourse> findAll() {
		return userCourseDao.findAll();
	}

	public UserCourse findById(String id) {
		return userCourseDao.findById(id).orElse(null);
	}

	public void save(UserCourse userCourse) {
		userCourse.setId(idWorker.nextStringId());//设置分布式ID
		userCourseDao.save(userCourse);
	}

	public void update(UserCourse userCourse) {
		userCourseDao.save(userCourse);
	}

	public void deleteById(String id) {
		userCourseDao.deleteById(id);
	}

	public List<UserCourse> findByUserId(String userId) {
		return userCourseDao.findByUserId(userId);
	}
}
