package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseVideoDao;
import yh.course.entity.CourseVideo;

import java.util.List;

@Service
@Transactional
public class CourseVideoService {
	@Autowired
	private CourseVideoDao courseVideoDao;

	public List<CourseVideo> findAll() {
		return courseVideoDao.findAll();
	}

	public CourseVideo findById(String id) {
		return courseVideoDao.findById(id).orElse(null);
	}

	public void save(CourseVideo courseVideo) {
		courseVideoDao.save(courseVideo);
	}

	public void update(CourseVideo courseVideo) {
		courseVideoDao.save(courseVideo);
	}

	public void deleteById(String id) {
		courseVideoDao.deleteById(id);
	}

	public List<CourseVideo> findByCourseId(String courseId) {
		return courseVideoDao.findByCourseId(courseId);
	}
}
