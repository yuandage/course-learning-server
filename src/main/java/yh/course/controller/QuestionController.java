package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.Question;
import yh.course.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", questionService.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", questionService.findById(id));
	}

	@RequestMapping(value = "/questionType/{courseId}", method = RequestMethod.GET)
	public Result findType(@PathVariable String courseId) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", questionService.findType(courseId));
	}

	@RequestMapping(value = "/{courseId}/{type}", method = RequestMethod.GET)
	public Result findByCourseIdAndType(@PathVariable String courseId, @PathVariable String type) {
		return new Result(true, StatusCode.SUCCESS, "查询成功", questionService.findByCourseIdAndType(courseId, type));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Question question) {
		questionService.save(question);
		return new Result(true, StatusCode.SUCCESS, "添加成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestBody Question question) {
		questionService.update(question);
		return new Result(true, StatusCode.SUCCESS, "更新成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable String id) {
		questionService.deleteById(id);
		return new Result(true, StatusCode.SUCCESS, "删除成功");
	}

}
