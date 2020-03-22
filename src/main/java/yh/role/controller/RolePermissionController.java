package yh.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.role.entity.RolePermission;
import yh.role.service.RolePermissionService;
import yh.user.service.UserRoleService;

@RestController
@CrossOrigin
@RequestMapping("/rolePermission")
public class RolePermissionController {
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	UserRoleService userRoleService;

	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", rolePermissionService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", rolePermissionService.findById(id));
	}

	@RequestMapping(value = "/roleId/{roleId}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findUserRoles(@PathVariable String roleId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userRoleService.getRolePermissions(roleId));
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result save(@RequestBody RolePermission rolePermission) {
		rolePermissionService.save(rolePermission);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result update(@PathVariable String id, @RequestBody RolePermission rolePermission) {
		rolePermissionService.update(rolePermission);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteById(@PathVariable String id) {
		rolePermissionService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

	@RequestMapping(value = "/{roleId}/{permissionId}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteByRoleIdAndPermissionId(@PathVariable String roleId, @PathVariable String permissionId) {
		rolePermissionService.deleteByRoleIdAndPermissionId(roleId, permissionId);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}
}
