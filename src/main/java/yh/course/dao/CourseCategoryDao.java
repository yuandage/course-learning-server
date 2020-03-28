package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseCategory;

import java.util.List;

public interface CourseCategoryDao extends JpaRepository<CourseCategory, String> {
	int countByParentIdIsNull();

	List<CourseCategory> findByParentIdNotNull();

	List<CourseCategory> findByParentIdNot(String parentId);

	List<CourseCategory> findByParentId(String parentId);
}

