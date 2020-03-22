package yh.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yh.common.Result;
import yh.common.StatusCode;
import yh.course.entity.CourseComment;
import yh.course.service.CourseCommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CourseCommentController {

    @Autowired
    private CourseCommentService courseCommentService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseCommentService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseCommentService.findById(id));
    }

    @RequestMapping(value = "/courseId/{id}", method = RequestMethod.GET)
    public Result findByCourseId(@PathVariable String id) {
        return new Result(true, StatusCode.SUCCESS, "查询成功", courseCommentService.findByCourseId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('add')")
    public Result save(@RequestBody CourseComment courseComment) {
        courseCommentService.save(courseComment);
        return new Result(true, StatusCode.SUCCESS, "添加成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result update(@PathVariable String id, @RequestBody CourseComment courseComment) {
        courseCommentService.update(courseComment);
        return new Result(true, StatusCode.SUCCESS, "更新成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyRole('admin','dev','test','teacher')")
    public Result deleteById(@PathVariable String id) {
        courseCommentService.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "删除成功");
    }

}
