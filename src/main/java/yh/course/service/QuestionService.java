package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.QuestionDao;
import yh.course.entity.Question;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private IdWorker idWorker;

	public List<Question> findAll() {
		return questionDao.findAll();
	}

	public Question findById(String id) {
		return questionDao.findById(id).orElse(null);
	}

	public void save(Question question) {
		question.setId(idWorker.nextId() + "");//设置分布式ID
		questionDao.save(question);
	}

	public void update(Question question) {
		questionDao.save(question);
	}

	public void deleteById(String id) {
		questionDao.deleteById(id);
	}

	public List<Question> findByCourseIdAndType(String courseId, String type) {
		return questionDao.findByCourseIdAndType(courseId, type);
	}

	public List<String> findType(String courseId) {
		return questionDao.findType(courseId);
	}
}
