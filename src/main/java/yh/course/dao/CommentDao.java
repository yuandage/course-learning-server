package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.Comment;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, String> {
	List<Comment> findByCourseId(String id);
}
