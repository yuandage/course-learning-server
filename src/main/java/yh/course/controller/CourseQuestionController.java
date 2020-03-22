package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseQuestion;
import yh.course.service.CourseQuestionService;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class CourseQuestionController {

	@Autowired
	private CourseQuestionService courseQuestionService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionService.findById(id));
	}

	@RequestMapping(value = "/questionType/{courseId}", method = RequestMethod.GET)
	public Result findType(@PathVariable String courseId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionService.findType(courseId));
	}

	@RequestMapping(value = "/courseId/{courseId}", method = RequestMethod.GET)
	public Result findByCourseId(@PathVariable String courseId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionService.findByCourseId(courseId));
	}

	@RequestMapping(value = "/{courseId}/{type}", method = RequestMethod.GET)
	public Result findByCourseIdAndType(@PathVariable String courseId, @PathVariable String type) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionService.findByCourseIdAndType(courseId, type));
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result save(@RequestBody CourseQuestion courseQuestion) {
		courseQuestionService.save(courseQuestion);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result update(@PathVariable String id, @RequestBody CourseQuestion courseQuestion) {
		courseQuestionService.update(courseQuestion);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result deleteById(@PathVariable String id) {
		courseQuestionService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
