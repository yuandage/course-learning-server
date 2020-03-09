package yh.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.role.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao extends JpaRepository<RolePermission,String>, JpaSpecificationExecutor<RolePermission> {

	List<RolePermission> findByRoleId(String roleId);
}
