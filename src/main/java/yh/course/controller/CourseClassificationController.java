package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.service.CourseClassificationService;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class CourseClassificationController {

	@Autowired
	CourseClassificationService courseClassificationService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findSubjectType() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findSubjectType());
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public Result findChildSubject() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findChildSubject());
	}
}
