package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.QuestionComment;

import java.util.List;

public interface QuestionCommentDao extends JpaRepository<QuestionComment, String> {
	List<QuestionComment> findByQuestionId(String id);
}
