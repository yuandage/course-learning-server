package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.Subject;

import java.util.List;

public interface SubjectDao extends JpaRepository<Subject, String>, JpaSpecificationExecutor<Subject> {
    int countByParentIdIsNull();
    List<Subject> findByParentIdNotNull();
}

