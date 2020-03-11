package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CommentDao;
import yh.course.entity.Comment;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private IdWorker idWorker;

	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	public Comment findById(String id) {
		return commentDao.findById(id).orElse(null);
	}

	public void save(Comment comment) {
		comment.setId(idWorker.nextId() + "");//设置分布式ID
		commentDao.save(comment);
	}

	public void update(Comment comment) {
		commentDao.save(comment);
	}

	public void deleteById(String id) {
		commentDao.deleteById(id);
	}

	public List<Comment> findByCourseId(String id) {
		return commentDao.findByCourseId(id);
	}
}
