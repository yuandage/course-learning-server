package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseQuestionCommentDao;
import yh.course.entity.CourseQuestionComment;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseQuestionCommentService {
	@Autowired
	private CourseQuestionCommentDao courseQuestionCommentDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseQuestionComment> findAll() {
		return courseQuestionCommentDao.findAll();
	}

	public CourseQuestionComment findById(String id) {
		return courseQuestionCommentDao.findById(id).orElse(null);
	}

	public void save(CourseQuestionComment courseQuestionComment) {
		courseQuestionComment.setId(idWorker.nextStringId());//设置分布式ID
		this.courseQuestionCommentDao.save(courseQuestionComment);
	}

	public void update(CourseQuestionComment courseQuestionComment) {
		this.courseQuestionCommentDao.save(courseQuestionComment);
	}

	public void deleteById(String id) {
		courseQuestionCommentDao.deleteById(id);
	}

	public List<CourseQuestionComment> findByCourseId(String courseId) {
		return courseQuestionCommentDao.findByCourseId(courseId);
	}

	public List<CourseQuestionComment> findByQuestionId(String id) {
		return courseQuestionCommentDao.findByQuestionId(id);
	}
}
