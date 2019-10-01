package yh.base.dao;

import yh.base.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
    List<Label> findByLabelNameLikeAndState(String labelName, String state);
    Page<Label> findByLabelNameLikeAndState(String labelName, String state, Pageable pageable);
}
