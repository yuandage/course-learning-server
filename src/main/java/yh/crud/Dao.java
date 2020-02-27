package yh.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.base.entity.Label;

public interface Dao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
