package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseComment;

import java.util.List;

public interface CourseCommentDao extends JpaRepository<CourseComment, String> {
	List<CourseComment> findByCourseId(String id);
}
