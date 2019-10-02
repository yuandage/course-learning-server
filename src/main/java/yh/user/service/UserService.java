package yh.user.service;

import yh.user.dao.UserDao;
import yh.user.entity.User;
import yh.util.IdWorker;
import yh.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    JwtUtil jwtUtil;
    @Autowired
    HttpServletRequest request;


    public void add(User user) {
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1!=null){
            throw new RuntimeException("用户名已存在!");
        }
        if(!user.getRole().equals("1")&&!user.getRole().equals("2")){
            throw new RuntimeException("用户身份错误!");
        }
        if (user.getRole().equals("2")){
            user.setRole("待审核");//教师注册,需管理员审核
        }
        user.setId(idWorker.nextId()+"");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setFollowCount(0);//关注数
        user.setFansCount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setLastDate(new Date());//最后登陆日期
        userDao.save(user);
    }

    public User login(User user) {
        //先查用户名
        User userLogin = userDao.findByUsername(user.getUsername());
        //再匹配两个密码
        if (userLogin != null && encoder.matches(user.getPassword(), userLogin.getPassword())) {
            return userLogin;
        }
        return null;
    }

    public void deleteById(String id) {
        String token = (String) request.getAttribute("claims_admin");//管理员角色
        if(token==null||"".equals(token)){
            throw new RuntimeException("权限不足!");
        }
        userDao.deleteById(id);
    }

    public User findById(String userId) {
        return userDao.findById(userId).get();
    }
}
