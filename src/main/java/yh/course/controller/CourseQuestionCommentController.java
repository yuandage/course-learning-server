package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseQuestionComment;
import yh.course.service.CourseQuestionCommentService;

@RestController
@CrossOrigin
@RequestMapping("/questionComment")
public class CourseQuestionCommentController {

    @Autowired
    private CourseQuestionCommentService courseQuestionCommentService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionCommentService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionCommentService.findById(id));
    }

    @RequestMapping(value = "/courseId/{courseId}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String courseId) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionCommentService.findByCourseId(courseId));
    }

    @RequestMapping(value = "/questionId/{id}", method = RequestMethod.GET)
    public Result findByQuestionId(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseQuestionCommentService.findByQuestionId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody CourseQuestionComment courseQuestionComment) {
        courseQuestionCommentService.save(courseQuestionComment);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody CourseQuestionComment courseQuestionComment) {
        courseQuestionCommentService.update(courseQuestionComment);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        courseQuestionCommentService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
