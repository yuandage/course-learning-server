package yh.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.permission.entity.Permission;
import yh.permission.service.PermissionService;

@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;

	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", permissionService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", permissionService.findById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result save(@RequestBody Permission permission) {
		permissionService.save(permission);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result update(@PathVariable String id,@RequestBody Permission permission) {
		permissionService.update(permission);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteById(@PathVariable String id) {
		permissionService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
