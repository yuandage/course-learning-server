package yh.course.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yh.course.entity.Course;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course> {
    List<Course> findByName(String name);

    Page<Course> findByName(String name, Pageable pageable);

    List<Course> findByParentId(String parentId);

    @Query(value = "SELECT id,name,summary,catalog,parent_id,create_date,update_date FROM course WHERE parent_id in ( SELECT id FROM subject where parent_id=:id)", nativeQuery = true)
    List<Course> findBySubjectId(@Param("id") Integer subjectId);
}
