package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseClassification;

import java.util.List;

public interface CourseClassificationDao extends JpaRepository<CourseClassification, String> {
	int countByParentIdIsNull();

	List<CourseClassification> findByParentIdNotNull();
}

