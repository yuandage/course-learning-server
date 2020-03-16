package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseResourceDao;
import yh.course.entity.CourseResource;

import java.util.List;

@Service
@Transactional
public class CourseResourceService {
	@Autowired
	private CourseResourceDao courseResourceDao;

	public List<CourseResource> findAll() {
		return courseResourceDao.findAll();
	}

	public CourseResource findById(String id) {
		return courseResourceDao.findById(id).orElse(null);
	}

	public void save(CourseResource courseResource) {
		courseResourceDao.save(courseResource);
	}

	public void update(CourseResource courseResource) {
		courseResourceDao.save(courseResource);
	}

	public void deleteById(String id) {
		courseResourceDao.deleteById(id);
	}

	public List<CourseResource> findByCourseId(String courseId) {
		return courseResourceDao.findByCourseId(courseId);
	}
}
