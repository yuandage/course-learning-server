package yh.user.controller;

import yh.common.Result;
import yh.common.StatusCode;
import yh.user.entity.Admin;
import yh.user.service.AdminService;
import yh.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    JwtUtil jwtUtil;

    //添加管理员
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Admin admin){
       adminService.add(admin);
        return new Result(true,StatusCode.SUCCESS,"添加成功");
    }

    //管理员登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin){
        System.out.println(admin.getUsername());
        admin= adminService.login(admin);
        if (admin==null){
        return new Result(false,StatusCode.LOGIN_ERROR,"登录失败");
        }
        //前后端通信,使用JWT,生成令牌token
        String token = jwtUtil.createJWT(admin.getId(), admin.getUsername(), "admin");
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("role","admin");
        map.put("username",admin.getUsername());
        return new Result(true,StatusCode.SUCCESS,"登录成功",map);
    }
}
