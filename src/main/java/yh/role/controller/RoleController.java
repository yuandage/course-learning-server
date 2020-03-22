package yh.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.role.entity.Role;
import yh.role.service.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", roleService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", roleService.findById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result save(@RequestBody Role role) {
		roleService.save(role);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result update(@PathVariable String id,@RequestBody Role role) {
		//有才能更新,不然异常
		roleService.update(role);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test')")
	public Result deleteById(@PathVariable String id) {
		//有才能删除,不然异常
		roleService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
