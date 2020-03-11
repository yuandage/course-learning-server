package yh.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.user.entity.UserCourse;

import java.util.List;

public interface UserCourseDao extends JpaRepository<UserCourse, String> {

	List<UserCourse> findByUserId(String userId);
}
