package yh.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.role.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao extends JpaRepository<RolePermission, String> {

	List<RolePermission> findByRoleId(String roleId);

	void deleteByRoleIdAndPermissionId(String roleId, String permissionId);
}
