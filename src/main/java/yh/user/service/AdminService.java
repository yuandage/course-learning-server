package yh.user.service;

import yh.user.dao.AdminDao;
import yh.user.entity.Admin;
import yh.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    IdWorker idWorker;
    @Autowired
    BCryptPasswordEncoder encoder;

    public void add(Admin admin) {
        admin.setId(idWorker.nextId() + "");
        admin.setPassword(encoder.encode(admin.getPassword())); //密码加密
        adminDao.save(admin);
    }

    public Admin login(Admin admin) {
        //先查用户名
        Admin adminLogin = adminDao.findByUsername(admin.getUsername());
        //再匹配两个密码
        if (adminLogin != null && encoder.matches(admin.getPassword(), adminLogin.getPassword())) {
            return adminLogin;
        }
        return null;
    }
}
