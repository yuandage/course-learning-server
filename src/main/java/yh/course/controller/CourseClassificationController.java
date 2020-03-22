package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result findSubjectType() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findSubjectType());
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
	public Result findChildSubject() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", courseClassificationService.findChildSubject());
	}
}
