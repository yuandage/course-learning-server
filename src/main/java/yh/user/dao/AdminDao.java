package yh.user.dao;

import yh.user.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    Admin findByUsername(String username);
}
