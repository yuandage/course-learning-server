package yh.user.controller;

import yh.common.Result;
import yh.common.StatusCode;
import yh.user.entity.User;
import yh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    //用户信息查询
    @RequestMapping(method = RequestMethod.GET)
    public Result findByUsername(@RequestParam String username){
        User user=userService.findByUsername(username);
        user.setPassword("");
        return new Result(true, StatusCode.SUCCESS, "查询成功",user);
    }

    //用户信息查询
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String userId){
        User user=userService.findById(userId);
        user.setPassword("");
        return new Result(true, StatusCode.SUCCESS, "查询成功",user);
    }

    //用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.SUCCESS, "注册成功");
    }

    //用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        user = userService.login(user);
        if (user == null) {
            return new Result(false, StatusCode.LOGIN_ERROR, "登录失败");
        }
        user.setPassword("");
        //前后端通信,使用JWT
        String token = jwtUtil.createJWT(user.getId(), user.getUsername(), user.getRole());
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("role","user");
        map.put("user",user);
        return new Result(true, StatusCode.SUCCESS, "登录成功",map);
    }

    //用户删除 必须是admin角色才能删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        userService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
