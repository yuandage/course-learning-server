package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.course.entity.CourseChapter;

import java.util.List;

public interface CourseChapterDao extends JpaRepository<CourseChapter, String> {

	List<CourseChapter> findByCourseIdAndParentId(String courseId, String parentId);

	List<CourseChapter> findByCourseId(String courseId);
}
