package yh.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yh.role.entity.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
