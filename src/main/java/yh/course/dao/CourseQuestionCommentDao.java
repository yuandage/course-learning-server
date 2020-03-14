package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseQuestionComment;

import java.util.List;

public interface CourseQuestionCommentDao extends JpaRepository<CourseQuestionComment, String> {
	List<CourseQuestionComment> findByCourseId(String courseId);

	List<CourseQuestionComment> findByQuestionId(String id);
}
