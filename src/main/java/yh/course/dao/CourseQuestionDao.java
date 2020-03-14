package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yh.course.entity.CourseQuestion;

import java.util.List;

public interface CourseQuestionDao extends JpaRepository<CourseQuestion, String> {
	List<CourseQuestion> findByCourseId(String courseId);

	List<CourseQuestion> findByCourseIdAndType(String courseId, String type);

	@Query(value = "SELECT DISTINCT type FROM course_question WHERE course_id=:courseId", nativeQuery = true)
	List<String> findType(String courseId);
}
