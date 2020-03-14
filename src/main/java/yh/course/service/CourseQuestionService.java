package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseQuestionDao;
import yh.course.entity.CourseQuestion;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseQuestionService {
	@Autowired
	private CourseQuestionDao courseQuestionDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseQuestion> findAll() {
		return courseQuestionDao.findAll();
	}

	public CourseQuestion findById(String id) {
		return courseQuestionDao.findById(id).orElse(null);
	}

	public void save(CourseQuestion courseQuestion) {
		courseQuestion.setId(idWorker.nextId() + "");//设置分布式ID
		courseQuestionDao.save(courseQuestion);
	}

	public void update(CourseQuestion courseQuestion) {
		courseQuestionDao.save(courseQuestion);
	}

	public void deleteById(String id) {
		courseQuestionDao.deleteById(id);
	}

	public List<CourseQuestion> findByCourseIdAndType(String courseId, String type) {
		return courseQuestionDao.findByCourseIdAndType(courseId, type);
	}

	public List<String> findType(String courseId) {
		return courseQuestionDao.findType(courseId);
	}

	public List<CourseQuestion> findByCourseId(String courseId) {
		return courseQuestionDao.findByCourseId(courseId);
	}
}
