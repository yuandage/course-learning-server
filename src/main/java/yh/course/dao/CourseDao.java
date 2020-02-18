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
    List<Course> findByNameLike(String name);

    List<Course> findByName(String name);

    Page<Course> findByName(String name, Pageable pageable);

    List<Course> findByParentId(String parentId);
    Page<Course> findByParentId(String parentId,Pageable pageable);

    @Query(value = "SELECT * FROM course WHERE parent_id in ( SELECT id FROM subject where parent_id=:id )", nativeQuery = true)
    List<Course> findBySubjectId(@Param("id") Integer subjectId);

    //在查询语句结尾增加 pageable 传入分页信息
    //增加countQuery属性，用于总数的统计 --关键
    //Pageable参数支持排序功能，如果在sql语句中同时使用了ORDER进行排序，就会产生冲突。所以只能二选一。
    @Query(value = "SELECT * FROM course WHERE parent_id in ( SELECT id FROM subject where parent_id=:subjectId )",
            countQuery = "SELECT count(*) FROM course WHERE parent_id in ( SELECT id FROM subject where parent_id=:subjectId )",nativeQuery = true)
    Page<Course> findBySubjectId(@Param("subjectId") Integer subjectId,Pageable pageable);

    List<Course> findByPopular(String popular);
}
