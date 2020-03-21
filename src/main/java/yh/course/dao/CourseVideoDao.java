package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseVideo;

import java.util.List;

public interface CourseVideoDao extends JpaRepository<CourseVideo, String> {
	List<CourseVideo> findByCourseId(String courseId);

    CourseVideo findByCourseIdAndSectionId(String courseId, String sectionId);
}
