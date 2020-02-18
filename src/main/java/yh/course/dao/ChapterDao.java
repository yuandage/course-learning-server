package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.Chapter;
import java.util.List;

public interface ChapterDao extends JpaRepository<Chapter, String>, JpaSpecificationExecutor<Chapter> {

    List<Chapter> findByCourseIdAndParentIdIsNull(String courseId);

    List<Chapter> findByCourseIdAndParentId(String courseId,String parentId);
}
