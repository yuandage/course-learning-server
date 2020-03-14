package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseVideoDao;
import yh.course.entity.CourseVideo;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseVideoService {
	@Autowired
	private CourseVideoDao courseVideoDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseVideo> findAll() {
		return courseVideoDao.findAll();
	}

	public CourseVideo findById(String id) {
		return courseVideoDao.findById(id).orElse(null);
	}

	public void save(CourseVideo courseVideo) {
		courseVideo.setId(idWorker.nextId() + "");//设置分布式ID
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
