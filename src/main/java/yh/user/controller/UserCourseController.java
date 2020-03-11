package yh.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.user.service.UserCourseService;
import yh.user.entity.UserCourse;

@RestController
@CrossOrigin
@RequestMapping("/userCourse")
public class UserCourseController {
	@Autowired
	private UserCourseService userCourseService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userCourseService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userCourseService.findById(id));
	}

	@RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
	public Result findByUserId(@PathVariable String userId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", userCourseService.findByUserId(userId));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody UserCourse userCourse) {
		userCourseService.save(userCourse);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Result update(@RequestBody UserCourse userCourse) {
		userCourseService.update(userCourse);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String id) {
		userCourseService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
