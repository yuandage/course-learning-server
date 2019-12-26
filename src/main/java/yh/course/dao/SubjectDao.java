package yh.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.course.entity.Subject;

public interface SubjectDao extends JpaRepository<Subject, String>, JpaSpecificationExecutor<Subject> {
    int countByParentIdIsNull();
}

