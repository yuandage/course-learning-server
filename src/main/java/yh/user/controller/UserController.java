package yh.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import yh.common.Result;
import yh.common.StatusCode;
import yh.security.service.SecurityUserDetailsService;
import yh.user.entity.User;
import yh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.util.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SecurityUserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;

	//用户信息查询
	@RequestMapping(method = RequestMethod.GET)
	public Result findByUsername(@RequestParam String username) {
		User user = userService.findByUsername(username);
		user.setPassword("");
		return new Result(true, StatusCode.SUCCESS, "查询成功", user);
	}

	//用户信息查询
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','developer')")
	public Result findById(@PathVariable String userId) {
		User user = userService.findById(userId);
		if (user == null) {
			return new Result(true, StatusCode.SUCCESS, "没有此用户");
		}
		user.setPassword("");
		return new Result(true, StatusCode.SUCCESS, "查询成功", user);
	}

	//用户注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result register(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		userService.add(user);
		return new Result(true, StatusCode.SUCCESS, "注册成功");
	}

	//用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody User user, HttpServletRequest request) {
		if (user == null)
			return new Result(true, StatusCode.SUCCESS, "登录失败", "请输入用户名和密码");
		// 执行登录认证过程
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword());
		Authentication authentication = authenticationManager.authenticate(authRequest);

		Map<String, Object> userInfo=new HashMap<>();
		userInfo.put("userInfo",authentication.getAuthorities());
		String token = JwtTokenUtils.createToken(authentication.getName(), authentication.getAuthorities().toString());
		userInfo.put("token",token);
		return new Result(true, StatusCode.SUCCESS, "登录成功", userInfo);
	}

	//用户删除 必须是admin角色才能删除
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		userService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
