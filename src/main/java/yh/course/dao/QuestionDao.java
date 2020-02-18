package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import yh.course.entity.Question;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, String>, JpaSpecificationExecutor<Question> {
    List<Question> findByCourseIdAndType(String courseId, String type);
    @Query(value = "SELECT DISTINCT type FROM question WHERE course_id=:courseId",nativeQuery = true)
    List<String> findType(String courseId);
}
