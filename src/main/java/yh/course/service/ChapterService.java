package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.ChapterDao;
import yh.course.entity.Chapter;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ChapterService {
	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private IdWorker idWorker;

	public List<Chapter> findAll() {
		return chapterDao.findAll();
	}

	public Chapter findById(String id) {
		return chapterDao.findById(id).orElse(null);
	}

	public List<Chapter> findParentChapter(String courseId) {
		return chapterDao.findByCourseIdAndParentIdIsNull(courseId);
	}

	public List<Chapter> findSubChapter(String courseId, String parentId) {
		return chapterDao.findByCourseIdAndParentId(courseId, parentId);
	}

	public void save(Chapter chapter) {
		chapter.setId(idWorker.nextId() + "");//设置分布式ID
		chapterDao.save(chapter);
	}

	public void update(Chapter chapter) {
		chapterDao.save(chapter);
	}

	public void deleteById(String id) {
		chapterDao.deleteById(id);
	}

}
