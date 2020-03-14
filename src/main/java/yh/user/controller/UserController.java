package yh.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import yh.common.Result;
import yh.common.StatusCode;
import yh.security.entity.SecurityUserDetails;
import yh.user.entity.User;
import yh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.util.JwtTokenUtils;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userService.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody User user) {
		userService.save(user);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestBody User user) {
		userService.update(user);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	//用户删除 必须是admin,dev角色才能删除
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev')")
	public Result deleteById(@PathVariable String id) {
		userService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

	//用户信息查询
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Result findByUsername(@PathVariable String username) {
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
			return new Result(false, StatusCode.ERROR, "没有此用户");
		}
		user.setPassword("");
		return new Result(true, StatusCode.SUCCESS, "查询成功", user);
	}

	//用户注册
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result register(@RequestBody User user) {
		if (user == null)
			return new Result(false, StatusCode.ERROR, "注册失败", "请输入用户名和密码");
		userService.save(user);
		return new Result(true, StatusCode.SUCCESS, "注册成功");
	}

	//用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody User user) {
		if (user == null)
			return new Result(false, StatusCode.LOGIN_ERROR, "登录失败", "请输入用户名和密码");
		// 执行登录认证过程
		Authentication authentication = userService.login(user);
		SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getPrincipal();
		if (securityUserDetails.getUserRoles() == null)
			return new Result(false, StatusCode.LOGIN_ERROR, "登录失败!","用户没有任何角色!");
		String token = JwtTokenUtils.createToken(authentication.getName(), authentication.getAuthorities());
		User newUser = securityUserDetails.getUser();
		if (newUser != null)
			newUser.setPassword("");
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", newUser);
		userInfo.put("roles", securityUserDetails.getUserRoles());
		userInfo.put("authorities", securityUserDetails.getUserAuthorities());
		userInfo.put("token", token);
		return new Result(true, StatusCode.SUCCESS, "登录成功", userInfo);
	}

}
