package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.Resource;

import java.util.List;

public interface ResourceDao extends JpaRepository<Resource, String>, JpaSpecificationExecutor<Resource> {
    List<Resource> findByCourseId(String courseId);
}
