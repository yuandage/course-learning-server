package yh.permission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.permission.entity.Permission;

public interface PermissionDao extends JpaRepository<Permission,String>, JpaSpecificationExecutor<Permission> {

}
