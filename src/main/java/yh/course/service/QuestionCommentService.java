package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.QuestionCommentDao;
import yh.course.entity.QuestionComment;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class QuestionCommentService {
    @Autowired
    private QuestionCommentDao questionCommentDao;
    @Autowired
    private IdWorker idWorker;

    public List<QuestionComment> findAll() {
        return questionCommentDao.findAll();
    }

    public QuestionComment findById(String id) {
        return questionCommentDao.findById(id).get();
    }

    public void save(QuestionComment questionComment) {
        questionComment.setId(idWorker.nextId()+"");//设置分布式ID
        this.questionCommentDao.save(questionComment);
    }

    public void update(QuestionComment questionComment) {
        this.questionCommentDao.save(questionComment);
    }

    public void deleteById(String id) {
        questionCommentDao.deleteById(id);
    }

    public List<QuestionComment> findByQuestionId(String id) {
        return questionCommentDao.findByQuestionId(id);
    }
}
