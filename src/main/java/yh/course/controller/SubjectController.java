package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.service.SubjectService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@RequestMapping(method = RequestMethod.GET)
	public Result findSubjectType() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", subjectService.findSubjectType());
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public Result findChildSubject() {
		return new Result(true, StatusCode.SUCCESS, "查询成功", subjectService.findChildSubject());
	}
}
