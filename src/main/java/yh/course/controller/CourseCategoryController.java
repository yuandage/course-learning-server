package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseCategory;
import yh.course.service.CourseCategoryService;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CourseCategoryController {

	@Autowired
	CourseCategoryService courseCategoryService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseCategoryService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseCategoryService.findById(id));
	}

	//查询课程分类 parentId=0 父分类 parentId!=0 子分类
	@RequestMapping(value = "/parentId/{parentId}", method = RequestMethod.GET)
	public Result findByParentId(@PathVariable String parentId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseCategoryService.findByParentId(parentId));
	}

	//查询课程子分类 parentId!=0 子分类
	@RequestMapping(value = "/subCategory", method = RequestMethod.GET)
	public Result findSubCategory() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseCategoryService.findSubCategory());
	}

	//查询课程分类树
	@RequestMapping(value = "/courseCategory", method = RequestMethod.GET)
	public Result findCourseCategory() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseCategoryService.findCourseCategory());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result save(@RequestBody CourseCategory courseCategory) {
		courseCategoryService.save(courseCategory);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result update(@PathVariable String id, @RequestBody CourseCategory courseCategory) {
		courseCategoryService.update(courseCategory);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result deleteById(@PathVariable String id) {
		courseCategoryService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
