package yh.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.role.entity.Role;
import yh.role.service.RoleService;
import yh.util.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", roleService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", roleService.findById(id));
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET)
	public Result getUserRoles(HttpServletRequest request) {
		String requestToken = request.getHeader("Authorization");
		if (requestToken == null || "".equals(requestToken)) {
			return new Result(true, StatusCode.ERROR, "令牌无效");
		}
		if (!requestToken.startsWith("Bearer ")) {
			return new Result(true, StatusCode.SUCCESS, "令牌格式不正确");
		}
		String token=requestToken.substring(7);
		List<String> roles = JwtTokenUtils.getRolesFromToken(token);
		System.out.println("用户角色信息查询:"+roles);
		return new Result(true, StatusCode.SUCCESS, "查询成功", roles);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Role role) {
		roleService.save(role);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public Result update(@PathVariable String id,@RequestBody Role role) {
		//有才能更新,不然异常
		roleService.update(role);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String id) {
		//有才能删除,不然异常
		roleService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
