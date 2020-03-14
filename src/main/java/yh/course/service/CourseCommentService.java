package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseCommentDao;
import yh.course.entity.CourseComment;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseCommentService {
	@Autowired
	private CourseCommentDao courseCommentDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseComment> findAll() {
		return courseCommentDao.findAll();
	}

	public CourseComment findById(String id) {
		return courseCommentDao.findById(id).orElse(null);
	}

	public void save(CourseComment courseComment) {
		courseComment.setId(idWorker.nextId() + "");//设置分布式ID
		courseCommentDao.save(courseComment);
	}

	public void update(CourseComment courseComment) {
		courseCommentDao.save(courseComment);
	}

	public void deleteById(String id) {
		courseCommentDao.deleteById(id);
	}

	public List<CourseComment> findByCourseId(String id) {
		return courseCommentDao.findByCourseId(id);
	}
}
