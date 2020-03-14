package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseResource;

import java.util.List;

public interface CourseResourceDao extends JpaRepository<CourseResource, String> {
	List<CourseResource> findByCourseId(String courseId);
}
