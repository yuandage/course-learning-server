package yh.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.role.entity.RolePermission;
import yh.role.service.RolePermissionService;
import yh.security.service.RoleAndPermissionService;

@RestController
@CrossOrigin
@RequestMapping("/rolePermission")
public class RolePermissionController {
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	RoleAndPermissionService roleAndPermissionService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", rolePermissionService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", rolePermissionService.findById(id));
	}

	@RequestMapping(value = "/roleId/{roleId}", method = RequestMethod.GET)
	public Result findUserRoles(@PathVariable String roleId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", roleAndPermissionService.getRolePermissions(roleId));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody RolePermission rolePermission) {
		rolePermissionService.save(rolePermission);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestBody RolePermission rolePermission) {
		rolePermissionService.update(rolePermission);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String id) {
		rolePermissionService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

	@RequestMapping(value = "/{roleId}/{permissionId}", method = RequestMethod.DELETE)
	public Result deleteByRoleIdAndPermissionId(@PathVariable String roleId, @PathVariable String permissionId) {
		rolePermissionService.deleteByRoleIdAndPermissionId(roleId, permissionId);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}
}
