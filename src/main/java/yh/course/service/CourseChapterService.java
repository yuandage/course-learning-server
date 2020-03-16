package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseChapterDao;
import yh.course.entity.CourseChapter;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseChapterService {
	@Autowired
	private CourseChapterDao courseChapterDao;
	@Autowired
	private IdWorker idWorker;

	public List<CourseChapter> findAll() {
		return courseChapterDao.findAll();
	}

	public CourseChapter findById(String id) {
		return courseChapterDao.findById(id).orElse(null);
	}

	public List<CourseChapter> findByCourseIdAndParentId(String courseId, String parentId) {
		return courseChapterDao.findByCourseIdAndParentId(courseId, parentId);
	}

	public List<CourseChapter> findByCourseId(String courseId) {
		return courseChapterDao.findByCourseId(courseId);
	}

	public void save(CourseChapter courseChapter) {
		courseChapter.setId(idWorker.nextId() + "");//设置分布式ID
		courseChapterDao.save(courseChapter);
	}

	public void update(CourseChapter courseChapter) {
		courseChapterDao.save(courseChapter);
	}

	public void deleteById(String id) {
		courseChapterDao.deleteById(id);
	}

}
