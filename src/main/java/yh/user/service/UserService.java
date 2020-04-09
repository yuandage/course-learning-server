package yh.user.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import yh.user.dao.UserDao;
import yh.user.entity.User;
import yh.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	IdWorker idWorker;
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	AuthenticationManager authenticationManager;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void save(User user) {
		User user1 = userDao.findByUsername(user.getUsername());
		if (user1 != null) {
			throw new RuntimeException("用户名已存在!");
		}
		user.setId(idWorker.nextStringId());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setFollowCount(0);//关注数
		user.setFansCount(0);//粉丝数
		user.setOnline(0L);//在线时长
		user.setRegDate(new Date());//注册日期
		user.setUpdateDate(new Date());//更新日期
		user.setLastDate(new Date());//最后登陆日期
		userDao.save(user);
	}

	public Authentication login(User user) {
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword());
		return authenticationManager.authenticate(authRequest);
	}

	public void deleteById(String id) {
		userDao.deleteById(id);
	}

	public User findById(String userId) {
		return userDao.findById(userId).orElse(null);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public void update(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

}
