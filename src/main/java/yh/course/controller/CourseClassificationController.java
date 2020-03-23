package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseClassification;
import yh.course.service.CourseClassificationService;

@RestController
@CrossOrigin
@RequestMapping("/classification")
public class CourseClassificationController {

	@Autowired
	CourseClassificationService courseClassificationService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findById(id));
	}

	//查询课程分类 parentId=0 父分类 parentId!=0 子分类
	@RequestMapping(value = "/parentId/{parentId}", method = RequestMethod.GET)
	public Result findByParentId(@PathVariable String parentId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findByParentId(parentId));
	}

	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result save(@RequestBody CourseClassification courseClassification) {
		courseClassificationService.save(courseClassification);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result update(@PathVariable String id, @RequestBody CourseClassification courseClassification) {
		courseClassificationService.update(courseClassification);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result deleteById(@PathVariable String id) {
		courseClassificationService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
