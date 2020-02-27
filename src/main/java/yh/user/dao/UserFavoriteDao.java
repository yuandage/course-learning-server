package yh.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import yh.user.entity.UserFavorite;

import java.util.List;

public interface UserFavoriteDao extends JpaRepository<UserFavorite,String>, JpaSpecificationExecutor<UserFavorite> {

    List<UserFavorite> findByUserId(String userId);
}
