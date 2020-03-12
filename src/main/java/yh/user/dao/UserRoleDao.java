package yh.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.user.entity.UserRole;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole, String> {

	List<UserRole> findByUserId(String id);

	void deleteByUserIdAndRoleId(String userId, String roleId);
}
